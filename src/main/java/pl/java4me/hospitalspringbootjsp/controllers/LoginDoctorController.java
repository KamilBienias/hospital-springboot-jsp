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

import pl.java4me.hospitalspringbootjsp.entities.Doctor;
import pl.java4me.hospitalspringbootjsp.repositories.DoctorRepository;
import pl.java4me.hospitalspringbootjsp.validators.DoctorLoginValidator;


@Controller
@SessionAttributes("loggedDoctor")//po to zeby po zalogowaniu byl przechowywany w sesji. Nazwa klucza pod jakim uzytkownik zostanie zapisany w sesji to loggedDoctor 
public class LoginDoctorController {

	@Autowired
    public DoctorRepository doctorRepository;//repozytorium jest polem
		
	@Autowired
	public DoctorLoginValidator doctorLoginValidator;//wstrzykuje walidator
		
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		
		binder.addValidators(doctorLoginValidator);//dodaje walidator
	}
	
	@GetMapping(value = "/login_doctor")
	public String login(Model model) {

		model.addAttribute("doctor", new Doctor());
		return "login_doctor";
	}
	
	@PostMapping(value = "/login_doctor")
	public String postLogin(Model model, @ModelAttribute("doctor") @Validated Doctor doctor, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
		return "login_doctor";
		}
		else if (doctor.getPassword().equals(doctorRepository.findByNickname(doctor.getNickname()).getPassword())) {//jesli haslo podane przy logowaniu zgadza sie z tym przy rejestracji
			doctor = doctorRepository.findByNickname(doctor.getNickname());//pobieram doktora z bazy danych, ktory ma taki sam nickname jak ten przekazany w formularzu
			model.addAttribute("loggedDoctor", doctor);//klucz i wartosc. Wartosc to ten uzytkownik ktory przychodzi z formularza. Czyli zapisuje go w sesji
			return "redirect:doctor_page";//jesli nie ma bledow, to przechodzi na strone doktora. Te redirect mowil po co jest redirect w cz IV min 11:30, ale nie wiem
//		} else if (!doctorRepository.exists(doctor)) {//jesli nie istnieje taki doktor w bazie danych (nie dziala)	
//		} else if (!doctorRepository.existsById(doctor.getId())) {//jesli nie istnieje taki doktor w bazie danych (nie dziala)
		} else if (!doctorRepository.existsByNickname(doctor.getNickname())) {//jesli nie istnieje taki doktor w bazie danych (nie dziala)
			return "login_doctor";//po wpisaniu nicku spoza bazy danych bedzie nadal strona logowania. Ale nie dziala bo blad wyskakuje
		} else {
			return "login_doctor";
		}
	}
}


