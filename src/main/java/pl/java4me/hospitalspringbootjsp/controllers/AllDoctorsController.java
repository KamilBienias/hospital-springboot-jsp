package pl.java4me.hospitalspringbootjsp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.java4me.hospitalspringbootjsp.entities.Doctor;
import pl.java4me.hospitalspringbootjsp.repositories.DoctorRepository;

@Controller
public class AllDoctorsController {
	
	@Autowired
    public DoctorRepository doctorRepository;//repozytorium jest polem
	
	@RequestMapping(value = "/all_doctors")
	public String addDoctor(Model model) {
						
		List<Doctor> doctors = (List<Doctor>) doctorRepository.findAll();
		
		model.addAttribute("show_doctors", doctors);//klucz w cudzyslowie ma sie zgadzac z tym co w jsp
		
		return "all_doctors";//zwraca nazwe widoku strony jsp. 
		//Tak sie nazywa utworzona przeze mnie strona home.jsp ktora jest w src/main/webapp/WEB-INF/jsp/all_doctors.jsp
	}
}
