package pl.java4me.hospitalspringbootjsp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.java4me.hospitalspringbootjsp.entities.Doctor;
import pl.java4me.hospitalspringbootjsp.repositories.DoctorRepository;


@Controller
public class RemoveDoctorController {
	
	@Autowired
    public DoctorRepository doctorRepository;//repozytorium jest polem
	
	@RequestMapping("/remove_doctor")
	public String removeDoctorInstruction(Model model) {
		
		List<Doctor> doctors = (List<Doctor>) doctorRepository.findAll();//pobieram liste lekarzy
		
		model.addAttribute("show_doctors", doctors);//pokazuje liste lekarzy w jsp (tam gdzie jest show_doctors)
		
		return "remove_doctor";//zwraca nazwe widoku strony jsp, niech to bedzie home. Tak sie nazywa utworzona przeze mnie strona home.jsp
		//ktora jest w src/main/webapp/WEB-INF/jsp/home.jsp
	}
	
	@RequestMapping("/remove_doctor/{doctor.id}")
	public String removeDoctorById(Model model, @PathVariable("doctor.id") int id) {

		doctorRepository.deleteById((long) id); 
		
		List<Doctor> doctors = (List<Doctor>) doctorRepository.findAll();//pobieram liste lekarzy
		
		model.addAttribute("show_doctors", doctors);//pokazuje liste lekarzy w jsp (tam gdzie jest show_doctors)
		
		return "remove_doctor";		
	}
	
}
