package pl.java4me.hospitalspringbootjsp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import pl.java4me.hospitalspringbootjsp.entities.Patient;


@Controller
@SessionAttributes("loggedPatient")//po to zeby po zalogowaniu byl przechowywany w sesji. Nazwa klucza pod jakim uzytkownik zostanie zapisany w sesji to loggedDoctor
public class PatientPageController {

	@GetMapping(value = "/patient_page")
	public String doctorPage(Model model, @SessionAttribute("loggedPatient") Patient patient) {// poprzez @SessionAttribute("loggedUser") User user przechwytuje obiekt zapisany w sesji, czyli loggerUser (jest on kluczem w tej adnotacji)

		model.addAttribute("pati",patient);//dodaje do modelu tego zalogowanego uzytkownika pod kluczem pati
		return "patient_page";//przekierowanie na widok patient_page
	}
	
	@ExceptionHandler(ServletRequestBindingException.class)//zeby uzytkownik po wylogowaniu i po wejsciu na /doctor_page (wpisana z palca) byl przenoszony na stone logowania
	public String handle() {
		
		return "redirect:/login_patient";
	}
	
}
