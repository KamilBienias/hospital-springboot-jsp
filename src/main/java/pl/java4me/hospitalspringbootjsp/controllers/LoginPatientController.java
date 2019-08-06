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
import org.springframework.web.bind.annotation.SessionAttributes;

import pl.java4me.hospitalspringbootjsp.entities.Patient;
import pl.java4me.hospitalspringbootjsp.repositories.PatientRepository;
import pl.java4me.hospitalspringbootjsp.validators.PatientLoginValidator;


@Controller
@SessionAttributes("loggedPatient")//po to zeby po zalogowaniu byl przechowywany w sesji. Nazwa klucza pod jakim uzytkownik zostanie zapisany w sesji to loggedPatient 
public class LoginPatientController {

	@Autowired
    public PatientRepository patientRepository;//repozytorium jest polem
		
	@Autowired
	public PatientLoginValidator patientLoginValidator;//wstrzykuje walidator
		
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		
		binder.addValidators(patientLoginValidator);//dodaje walidator
	}
	
	@GetMapping(value = "/login_patient")
	public String login(Model model) {

		model.addAttribute("patient", new Patient());
		return "login_patient";
	}
	
	@PostMapping(value = "/login_patient")
	public String postLogin(Model model, @ModelAttribute("patient") @Validated Patient patient, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
		return "login_patient";
		}
		else if (patient.getPassword().equals(patientRepository.findByNickname(patient.getNickname()).getPassword())) {//jesli haslo podane przy logowaniu zgadza sie z tym przy rejestracji
			patient = patientRepository.findByNickname(patient.getNickname());//pobieram doktora z bazy danych, ktory ma taki sam nickname jak ten przekazany w formularzu
			model.addAttribute("loggedPatient", patient);//klucz i wartosc. Wartosc to ten uzytkownik ktory przychodzi z formularza. Czyli zapisuje go w sesji
			return "redirect:patient_page";//jesli nie ma bledow, to przechodzi na strone doktora. Te redirect mowil po co jest redirect w cz IV min 11:30, ale nie wiem
		} else if (!patientRepository.existsByNickname(patient.getNickname())) {//jesli nie istnieje taki doktor w bazie danych (nie dziala)
			return "login_patient";//po wpisaniu nicku spoza bazy danych bedzie nadal strona logowania. Ale nie dziala bo blad wyskakuje
		} else {
			return "login_patient";
		}
	}
}


