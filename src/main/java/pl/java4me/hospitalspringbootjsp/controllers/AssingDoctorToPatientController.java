package pl.java4me.hospitalspringbootjsp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.java4me.hospitalspringbootjsp.entities.Doctor;
import pl.java4me.hospitalspringbootjsp.entities.Patient;
import pl.java4me.hospitalspringbootjsp.repositories.DoctorRepository;
import pl.java4me.hospitalspringbootjsp.repositories.PatientRepository;


@Controller
public class AssingDoctorToPatientController {
	
	@Autowired
    public PatientRepository patientRepository;//repozytorium jest polem
	
	@Autowired
    public DoctorRepository doctorRepository;//repozytorium jest polem
	
	@RequestMapping("/assign_doctor_to_patient")
	public String showPatients(Model model) {
		
		List<Patient> patients = (List<Patient>) patientRepository.findAll();//pobieram liste pacjentow
		
		model.addAttribute("show_patients", patients);//pokazuje liste pacjentow w jsp (tam gdzie jest show_patients)
		
		List<Doctor> docotrs = (List<Doctor>) doctorRepository.findAll();//pobieram liste lekarzy
		
		model.addAttribute("show_doctors", docotrs);//pokazuje liste lekarzy w jsp (tam gdzie jest show_doctors)
		
		return "assign_doctor_to_patient";//zwraca nazwe widoku strony jsp, niech to bedzie home. Tak sie nazywa utworzona przeze mnie strona home.jsp
		//ktora jest w src/main/webapp/WEB-INF/jsp/home.jsp
	}
	
	@RequestMapping("/assign_doctor_to_patient/{patient.id}/{doctor.id}")
	public String chooseDoctorToThisPatient(Model model, @PathVariable("patient.id") int idPatient, @PathVariable("doctor.id") int idDoctor) {
		
		List<Patient> patients = (List<Patient>) patientRepository.findAll();//pobieram liste pacjentow
		
		model.addAttribute("show_patients", patients);//pokazuje liste pacjentow w jsp (tam gdzie jest show_patients)
		
		List<Doctor> docotrs = (List<Doctor>) doctorRepository.findAll();//pobieram liste lekarzy
		
		model.addAttribute("show_doctors", docotrs);//pokazuje liste lekarzy w jsp (tam gdzie jest show_doctors)
		
		Patient patient = patientRepository.findById(idPatient);
		Doctor doctor = doctorRepository.findById(idDoctor);
		
		patient.setDoctor(doctor);
		patientRepository.save(patient);
						
		return "assign_doctor_to_patient";		
	}
	
}
