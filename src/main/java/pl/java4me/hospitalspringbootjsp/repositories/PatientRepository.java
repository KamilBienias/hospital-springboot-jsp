package pl.java4me.hospitalspringbootjsp.repositories;

import org.springframework.data.repository.CrudRepository;

import pl.java4me.hospitalspringbootjsp.entities.Patient;

public interface PatientRepository extends CrudRepository<Patient, Long> {

	public Patient findByNickname(String nickname);
	
	public Patient findByPassword(String doctor);
	
	public boolean existsByNickname(String nickname);
	
//	public boolean exists(Doctor doctor);
	
	public Patient findById(long id);
}
