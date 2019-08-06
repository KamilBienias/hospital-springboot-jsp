package pl.java4me.hospitalspringbootjsp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.java4me.hospitalspringbootjsp.entities.Patient;
import pl.java4me.hospitalspringbootjsp.repositories.PatientRepository;


@Controller
public class RemovePatientController {
	
	@Autowired
    public PatientRepository patientRepository;//repozytorium jest polem
	
	@RequestMapping("/remove_patient")
	public String removePatientInstruction(Model model) {
		
		List<Patient> patients = (List<Patient>) patientRepository.findAll();//pobieram liste pacjentow
		
		model.addAttribute("show_patients", patients);//pokazuje liste pacjentow w jsp (tam gdzie jest show_patients)
		
		return "remove_patient";//zwraca nazwe widoku strony jsp. Tak sie nazywa utworzona przeze mnie strona 
		//ktora jest w src/main/webapp/WEB-INF/jsp/remove_patient.jsp
	}
	
	@RequestMapping("/remove_patient/{patient.id}")
	public String removePatientById(Model model, @PathVariable("patient.id") int id) {
		patientRepository.deleteById((long) id); 
		
List<Patient> patients = (List<Patient>) patientRepository.findAll();//pobieram liste pacjentow
		
		model.addAttribute("show_patients", patients);//pokazuje liste pacjentow w jsp (tam gdzie jest show_patients)
		
		return "remove_patient";		
	}
	
}
