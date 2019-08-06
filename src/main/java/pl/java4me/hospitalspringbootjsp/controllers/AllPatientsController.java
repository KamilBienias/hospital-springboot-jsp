package pl.java4me.hospitalspringbootjsp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.java4me.hospitalspringbootjsp.entities.Patient;
import pl.java4me.hospitalspringbootjsp.repositories.PatientRepository;

@Controller
public class AllPatientsController {
	
	@Autowired
    public PatientRepository patientRepository;//repozytorium jest polem
	
	@RequestMapping(value = "/all_patients")
	public String addPatient(Model model) {
						
		List<Patient> patients = (List<Patient>) patientRepository.findAll();
		
		model.addAttribute("show_patients", patients);//klucz w cudzyslowie ma sie zgadzac z tym co w jsp
		
		return "all_patients";//zwraca nazwe widoku strony jsp. 
		//Tak sie nazywa utworzona przeze mnie strona home.jsp ktora jest w src/main/webapp/WEB-INF/jsp/all_patients.jsp
	}
}
