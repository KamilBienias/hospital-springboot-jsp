package pl.java4me.hospitalspringbootjsp.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "doctor")
public class Doctor {
 
	@GeneratedValue(strategy = GenerationType.IDENTITY)//autoinkrementacja
    @Id
    private Long id;

    @Column(name = "first_name")
    private String firstName;
    
    @Column(name = "last_name")
    private String lastName;

    @Column(name = "pesel")
    private String pesel;
    
    @Column(name = "nickname")
    private String nickname;
    
    @Column(name = "date_of_birth")
    private String dateOfBirth;//zmienione na String
    
    @Column(name = "salary")
    private int salary;

    @Column(name = "bonus")
    private Boolean bonus;
    
    @Column(name = "password")
    private String password;
    
    @Column(name = "confirm_password")
	private String confirmPassword;
    
    @OneToMany(mappedBy = "doctor")
    private List<Patient> patientsOfThisDoctor;

    //gettrs, setters, hash code, equals, toString
        
	public Long getId() {
		return id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDateOfBirth() {//zwraca String, bo w DoctorValidator byly bledy. Ale i tak zrezygnowalem z dateOfBirth w formularzu	
		return dateOfBirth;
	}

	
//	public String getDateOfBirth() {//zwraca String po to, zeby w DoctorValidator nie bylo bledu
//		if(!pesel.equals(null)){
//			dateOfBirth = pesel.charAt(4) + pesel.charAt(5) + "-" + pesel.charAt(2) + pesel.charAt(3) + "-" + "19" + pesel.charAt(0) + pesel.charAt(1);
//			return dateOfBirth;
//		}		 
//		return null;
//	}
	
//	public GregorianCalendar getDateOfBirth() {
//		return dateOfBirth;
//	}

	
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPesel() {
		return pesel;
	}

	public void setPesel(String pesel) {
		this.pesel = pesel;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Boolean getBonus() {
		return bonus;
	}

	public void setBonus(Boolean bonus) {
		this.bonus = bonus;
	}

	public List<Patient> getPatientsOfThisDoctor() {
		return patientsOfThisDoctor;
	}

	public void setPatientsOfThisDoctor(List<Patient> patientsOfThisDoctor) {
		this.patientsOfThisDoctor = patientsOfThisDoctor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pesel == null) ? 0 : pesel.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Doctor other = (Doctor) obj;
		if (pesel == null) {
			if (other.pesel != null)
				return false;
		} else if (!pesel.equals(other.pesel))
			return false;
		return true;
	}

	@Override
	public String toString() {  
		
		return "Doctor:"
				+ "<br>id=" + id + "<br>first name=" + firstName + "<br>last name=" + lastName + "<br>date of birth="
				+ dateOfBirth + "<br>pesel=" + pesel + "<br>salary=" + salary + "<br>bonus=" + bonus
				+ "<br>password=" + password + "<br>nickname=" + nickname;
//		"<br>patients=" + patientsOfThisDoctor;//powodowal blad:
		//There was an unexpected error (type=Internal Server Error, status=500).
		//failed to lazily initialize a collection of role: pl.java4me.hospitalspringbootjsp.entities.Doctor.patientsOfThisDoctor, could not initialize proxy - no Session
	}

}
