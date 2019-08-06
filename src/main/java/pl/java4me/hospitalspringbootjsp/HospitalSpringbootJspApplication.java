package pl.java4me.hospitalspringbootjsp;

//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import pl.java4me.hospitalspringbootjsp.repositories.DoctorRepository;
import pl.java4me.hospitalspringbootjsp.repositories.PatientRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = {DoctorRepository.class, PatientRepository.class})
public class HospitalSpringbootJspApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalSpringbootJspApplication.class, args);
	}

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	    return application.sources(HospitalSpringbootJspApplication.class);
	  }
	
	//to z artur owczarek. Na serwerze MySQL utworzone zostana dwie tabele doctor i patient 
//	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");//to myDatabase z pliku persistence.xml
//	EntityManager entityManager = entityManagerFactory.createEntityManager();//obiekt entityManager to obiekt, dzieki ktoremu robimy cos z baza danych
	
//	entityManager.close();//zeby program poprawnie sie zakonczyl
//	entityManagerFactory.close();//zeby program poprawnie sie zakonczyl
}
