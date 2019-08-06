package pl.java4me.hospitalspringbootjsp.repositories;

import org.springframework.data.repository.CrudRepository;

import pl.java4me.hospitalspringbootjsp.entities.Doctor;

public interface DoctorRepository extends CrudRepository<Doctor, Long> {
	
	public Doctor findByNickname(String nickname);
	
	public Doctor findByPassword(String doctor);
	
	public boolean existsByNickname(String nickname);
	
//	public boolean exists(Doctor doctor);
	
	public Doctor findById(long id);
	
}
