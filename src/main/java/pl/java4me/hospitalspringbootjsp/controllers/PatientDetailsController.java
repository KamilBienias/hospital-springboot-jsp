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
public class PatientDetailsController {
	
	@Autowired
    public PatientRepository patientRepository;//repozytorium jest polem
	
	@RequestMapping("/patient_details")
	public String patientDetailsInstruction(Model model) {
		
		List<Patient> patients = (List<Patient>) patientRepository.findAll();//pobieram liste pacjentow
		
		model.addAttribute("show_patients", patients);//pokazuje liste pacjentow w jsp (tam gdzie jest show_patients)
		
		return "patient_details";//zwraca nazwe widoku strony jsp, niech to bedzie home. Tak sie nazywa utworzona przeze mnie strona home.jsp
		//ktora jest w src/main/webapp/WEB-INF/jsp/home.jsp
	}
	
	@RequestMapping("/patient_details/{patient.id}/{patient.disease}")
	public String setPatientDisease(Model model, @PathVariable("patient.id") int id, @PathVariable("patient.disease") String disease) {
		
		Patient patient = patientRepository.findById(id);
		patient.setDisease(disease);
		patientRepository.save(patient);
		
		List<Patient> patients = (List<Patient>) patientRepository.findAll();//pobieram liste pacjentow
		
		model.addAttribute("show_patients", patients);//pokazuje liste pacjentow w jsp (tam gdzie jest show_patients)
		
		return "patient_details";		
	}
	
}
