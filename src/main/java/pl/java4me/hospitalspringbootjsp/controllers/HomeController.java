package pl.java4me.hospitalspringbootjsp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller//teraz widzi go jako komponent springowy
public class HomeController {
	
	@RequestMapping("/")
	public String home(Model model) {
		
		model.addAttribute("greeting", "Welcome");//klucz w cudzyslowie ma sie zgadzac z tym co w jsp
		
		return "home";//zwraca nazwe widoku strony jsp, niech to bedzie home. Tak sie nazywa utworzona przeze mnie strona home.jsp
		//ktora jest w src/main/webapp/WEB-INF/jsp/home.jsp
	}
}
