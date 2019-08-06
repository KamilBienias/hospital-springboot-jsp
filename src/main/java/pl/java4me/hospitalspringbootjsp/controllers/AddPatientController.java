package pl.java4me.hospitalspringbootjsp.controllers;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import pl.java4me.hospitalspringbootjsp.entities.Patient;
import pl.java4me.hospitalspringbootjsp.repositories.PatientRepository;
import pl.java4me.hospitalspringbootjsp.validators.PatientValidator;

@Controller
public class AddPatientController {
	
	@Autowired
    public PatientRepository patientRepository;//repozytorium jest polem
	
	//tak sie dodaje lekarza "na sztywno", ale tego nie robie bo przez formularz:
	
//	Doctor newDoctor = new Doctor();
//	newDoctor.setFirstName("Jan");
//	newDoctor.setLastName("Kowalski");
//	newDoctor.setDateOfBirth(today);
//	newDoctor.setPesel("52532334");
//	newDoctor.setSalary(2341.42);
//	newDoctor.setBonus(true);
//	doctorRepository.save(newDoctor);
	
	@Autowired
	public PatientValidator patientValidator;//wstrzykuje walidator
	
//	@Autowired
//	public EntityManager entityManager;
	
	@Autowired
	public EntityManagerFactory entityManagerFactory;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		
		binder.addValidators(patientValidator);//dodaje walidator
	}
	
	@GetMapping(value="/add_patient")//wysylam do uzytkownika pusty model formularza
	public String emptyNewPatient(Model model) {
		model.addAttribute("patient", new Patient());
		return "add_patient";
	}
	
	@Transactional//sam dorzucilem ale nic nie zmienilo
	@PostMapping(value="/add_patient")//uzytkownik wysyla wypelniony formularz
	public String postRegister(@ModelAttribute("patient") @Validated Patient patient, BindingResult bindingResult) {//@ModelAttribute("user") User user odbiera zbindowanego usera
		if(bindingResult.hasErrors()) {//przy pomocy obiektu bindingResult spr rezultat walidacji
			return "add_patient";//jesli sa bledy to zostaje na stronie rejestracji
		} 
		//ponizej ustawiam date urodzenia z peselu. Ma pare slabych stron (nie wszystkie przypadki z miesiacami i dniami)
		char thirdDigit = patient.getPesel().charAt(2); 
		
		switch (thirdDigit) {//po case jest cyfra w apostrofach bo ta cyfra to char
			case '0'://data urodzenia 19..
			case '1'://data urodzenia 19..
				{
					patient.setDateOfBirth(" day: " + patient.getPesel().charAt(4) + patient.getPesel().charAt(5) + ", month: "
					+ patient.getPesel().charAt(2) + patient.getPesel().charAt(3) + ", year: "  
					+ "19" + patient.getPesel().charAt(0) + patient.getPesel().charAt(1));
					break;
				}
			case '2'://data urodzenia 20.. z miesiacem 01,02,... 
				{
					patient.setDateOfBirth(" day: " + patient.getPesel().charAt(4) + patient.getPesel().charAt(5) + ", month: "
					+ "0" + patient.getPesel().charAt(3) + ", year: "  
					+ "20" + patient.getPesel().charAt(0) + patient.getPesel().charAt(1));
					break;
				}
			case '3'://data urodzenia 20.. z miesiacem 10,11,12
				{
					patient.setDateOfBirth(" day: " + patient.getPesel().charAt(4) + patient.getPesel().charAt(5) + ", month: "
					+ "1" + patient.getPesel().charAt(3) + ", year: "  
					+ "20" + patient.getPesel().charAt(0) + patient.getPesel().charAt(1));
					break;
				}
			//ponizsze juz nie przechodza przez walidator, wiec ich nie trzeba
//			case 4://data urodzenia 21..
//			case 5:	
//			case 6://data urodzenia 22..
//			case 7:
//			case 8://data urodzenia 18..
//			case 9:
		}//koniec switch
	
		//ponizej ustawiam nickname uzytkownika, ktory powstanie z 3 pierwszych liter imienia, 3 pierwszych liter nazwiska i 3 ostatnich cyfr peselu
				patient.setNickname("" + Character.toLowerCase(patient.getFirstName().charAt(0)) + Character.toLowerCase(patient.getFirstName().charAt(1))
				+ Character.toLowerCase(patient.getFirstName().charAt(2)) + Character.toLowerCase(patient.getLastName().charAt(0)) + Character.toLowerCase(patient.getLastName().charAt(1)) + Character.toLowerCase(patient.getLastName().charAt(2)) + patient.getPesel().charAt(10));
		
		patientRepository.save(patient);//sam to dodalem, zeby zapisywalo dodanego doktora do bazy
		
		//nie dziala bo rzuca:
//		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");//to myDatabase z pliku persistence.xml
//		EntityManager entityManager = entityManagerFactory.createEntityManager();//obiekt entityManager to obiekt, dzieki ktoremu robimy cos z baza danych
	 
		
//		entityManager.getTransaction().begin();//rozpoczynam transakcje na serwerze MySQL
//		entityManager.persist(patient);//zapisuje do bazy danych
//		entityManager.getTransaction().commit();//zakanczam transakcje
		
	
		return "home";//po wyslaniu bezblednego formularza kontroler przerzuca nas na strone home		
	}
	
}
