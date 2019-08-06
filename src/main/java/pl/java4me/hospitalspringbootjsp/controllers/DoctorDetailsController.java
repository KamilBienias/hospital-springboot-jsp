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
public class DoctorDetailsController {
	
	@Autowired
    public DoctorRepository doctorRepository;//repozytorium jest polem
	
	@RequestMapping("/doctor_details")
	public String doctorDetailsInstruction(Model model) {
		
		List<Doctor> doctors = (List<Doctor>) doctorRepository.findAll();//pobieram liste lekarzy
		
		model.addAttribute("show_doctors", doctors);//pokazuje liste lekarzy w jsp (tam gdzie jest show_doctors)
		
		return "doctor_details";//zwraca nazwe widoku strony jsp, niech to bedzie home. Tak sie nazywa utworzona przeze mnie strona home.jsp
		//ktora jest w src/main/webapp/WEB-INF/jsp/home.jsp
	}
	
	@RequestMapping("/doctor_details/{doctor.id}/{doctor.salary}/{doctor.bonus}")
	public String setDoctorSalary(Model model, @PathVariable("doctor.id") int id, @PathVariable("doctor.salary") int salary, @PathVariable("doctor.bonus") boolean bonus) {
		
		Doctor doctor = doctorRepository.findById(id);
		doctor.setSalary(salary);
		doctor.setBonus(bonus);
		doctorRepository.save(doctor);
		
		List<Doctor> doctors = (List<Doctor>) doctorRepository.findAll();//pobieram liste lekarzy
		
		model.addAttribute("show_doctors", doctors);//pokazuje liste lekarzy w jsp (tam gdzie jest show_doctors)
		
		return "doctor_details";		
	}
//	
//	@RequestMapping("/doctor_details/{doctor.id}/{doctor.bonus}")
//	public String setDoctorBonus(Model model, @PathVariable("doctor.id") int id, @PathVariable("doctor.bonus") boolean bonus) {
//		
//		Doctor doctor = doctorRepository.findById(id);
//		doctor.setBonus(bonus);
//		doctorRepository.save(doctor);
//		
//		List<Doctor> doctors = (List<Doctor>) doctorRepository.findAll();//pobieram liste lekarzy
//		
//		model.addAttribute("show_doctors", doctors);//pokazuje liste lekarzy w jsp (tam gdzie jest show_doctors)
//		
//		return "doctor_details";		
//	}
//	
}
