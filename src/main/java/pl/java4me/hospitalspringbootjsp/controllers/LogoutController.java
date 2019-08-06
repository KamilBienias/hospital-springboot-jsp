package pl.java4me.hospitalspringbootjsp.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogoutController {

	@GetMapping(value = "/logout")
	public String userPage(Model model, HttpSession session) {

		session.invalidate();//invalidate() powoduje wyczyszczenie wszystkich wartosci biezacej sesji
		return "redirect:/";//tu po wylogowaniu na strone domowa. Redirect po to zeby żądanie bylo wykonane przez metode home z klasy HomeController
	}
}

