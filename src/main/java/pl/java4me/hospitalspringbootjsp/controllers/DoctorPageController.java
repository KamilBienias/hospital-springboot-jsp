package pl.java4me.hospitalspringbootjsp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import pl.java4me.hospitalspringbootjsp.entities.Doctor;


@Controller
@SessionAttributes("loggedDoctor")//po to zeby po zalogowaniu byl przechowywany w sesji. Nazwa klucza pod jakim uzytkownik zostanie zapisany w sesji to loggedDoctor
public class DoctorPageController {

	@GetMapping(value = "/doctor_page")
	public String doctorPage(Model model, @SessionAttribute("loggedDoctor") Doctor doctor) {// poprzez @SessionAttribute("loggedUser") User user przechwytuje obiekt zapisany w sesji, czyli loggerUser (jest on kluczem w tej adnotacji)

		model.addAttribute("doc",doctor);//dodaje do modelu tego zalogowanego uzytkownika pod kluczem doc
		return "doctor_page";//przekierowanie na widok doctor_page
	}
	
	@ExceptionHandler(ServletRequestBindingException.class)//zeby uzytkownik po wylogowaniu i po wejsciu na /doctor_page (wpisana z palca) byl przenoszony na stone logowania
	public String handle() {
		
		return "redirect:/login_doctor";
	}
	
}
