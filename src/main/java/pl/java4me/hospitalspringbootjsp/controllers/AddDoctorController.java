package pl.java4me.hospitalspringbootjsp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import pl.java4me.hospitalspringbootjsp.entities.Doctor;
import pl.java4me.hospitalspringbootjsp.repositories.DoctorRepository;
import pl.java4me.hospitalspringbootjsp.validators.DoctorValidator;

@Controller
public class AddDoctorController {
	
	@Autowired
    public DoctorRepository doctorRepository;//repozytorium jest polem
	
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
	public DoctorValidator doctorValidator;//wstrzykuje walidator
	
	///nie dziala
//	@Autowired
//	public EntityManager entityManager;
//	
//	@Autowired
//	public EntityManagerFactory entityManagerFactory;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		
		binder.addValidators(doctorValidator);//dodaje walidator
	}
	
	@GetMapping(value="/add_doctor")//wysylam do uzytkownika pusty model formularza
	public String emptyNewDoctor(Model model) {
		model.addAttribute("doctor", new Doctor());
		return "add_doctor";
	}
	
//	@Transactional
	@PostMapping(value="/add_doctor")//uzytkownik wysyla wypelniony formularz
	public String postRegister(@ModelAttribute("doctor") @Validated Doctor doctor, BindingResult bindingResult) {//@ModelAttribute("user") User user odbiera zbindowanego usera
		if(bindingResult.hasErrors()) {//przy pomocy obiektu bindingResult spr rezultat walidacji
			return "add_doctor";//jesli sa bledy to zostaje na stronie rejestracji
		} 
				
		//ponizej ustawiam date urodzenia z peselu. Ma pare slabych stron (nie wszystkie przypadki z miesiacami i dniami)
		char thirdDigit = doctor.getPesel().charAt(2); 
		
		switch (thirdDigit) {//po case jest cyfra w apostrofach bo ta cyfra to char
			case '0'://data urodzenia 19..
			case '1'://data urodzenia 19..
				{
					doctor.setDateOfBirth(" day: " + doctor.getPesel().charAt(4) + doctor.getPesel().charAt(5) + ", month: "
					+ doctor.getPesel().charAt(2) + doctor.getPesel().charAt(3) + ", year: "  
					+ "19" + doctor.getPesel().charAt(0) + doctor.getPesel().charAt(1));
					break;
				}
			case '2'://data urodzenia 20.. z miesiacem 01,02,... 
				{
					doctor.setDateOfBirth(" day: " + doctor.getPesel().charAt(4) + doctor.getPesel().charAt(5) + ", month: "
					+ "0" + doctor.getPesel().charAt(3) + ", year: "  
					+ "20" + doctor.getPesel().charAt(0) + doctor.getPesel().charAt(1));
					break;
				}
			case '3'://data urodzenia 20.. z miesiacem 10,11,12
				{
					doctor.setDateOfBirth(" day: " + doctor.getPesel().charAt(4) + doctor.getPesel().charAt(5) + ", month: "
					+ "1" + doctor.getPesel().charAt(3) + ", year: "  
					+ "20" + doctor.getPesel().charAt(0) + doctor.getPesel().charAt(1));
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
		doctor.setNickname("" + Character.toLowerCase(doctor.getFirstName().charAt(0)) + Character.toLowerCase(doctor.getFirstName().charAt(1))
		+ Character.toLowerCase(doctor.getFirstName().charAt(2)) + Character.toLowerCase(doctor.getLastName().charAt(0)) + Character.toLowerCase(doctor.getLastName().charAt(1)) + Character.toLowerCase(doctor.getLastName().charAt(2)) + doctor.getPesel().charAt(10));
				
		doctorRepository.save(doctor);//sam to dodalem, zeby zapisywalo dodanego doktora do bazy
		
		//nie dziala bo rzuca:
//		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");//to myDatabase z pliku persistence.xml
//		EntityManager entityManager = entityManagerFactory.createEntityManager();//obiekt entityManager to obiekt, dzieki ktoremu robimy cos z baza danych
	 
		
//		entityManager.getTransaction().begin();//rozpoczynam transakcje na serwerze MySQL
//		entityManager.persist(doctor);//zapisuje do bazy danych
//		entityManager.getTransaction().commit();//zakanczam transakcje
		
	
		return "home";//po wyslaniu bezblednego formularza kontroler przerzuca nas na strone home		
	}
	
}
