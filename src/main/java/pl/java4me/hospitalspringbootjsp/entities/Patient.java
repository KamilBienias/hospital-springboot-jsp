package pl.java4me.hospitalspringbootjsp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "patient")
public class Patient {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)//autoinkrementacja
    @Id
    private Long id;

    @Column(name = "first_name")
    private String firstName;
    
	@Column(name = "last_name")
    private String lastName;

    @Column(name = "date_of_birth")
    private String dateOfBirth;//zmienione na String
	
    @Column(name = "pesel")
    private String pesel;
    
    @Column(name = "nickname")
    private String nickname;
    
    @Column(name = "disease")
    @Lob//czyli large object, jest to adnotacja ktora pozwala na przechowywaniu w danym polu wiekszych obiektow typu TEXT. Bez niej byloby zwykle 255 znakow dla String tak jak VARCHAR(255) w bazie danych
    private String disease;
    
    @Column(name = "password")
    private String password;
    
    @Column(name = "confirm_password")
	private String confirmPassword;
    
    @ManyToOne
    private Doctor doctor;
    
  //gettrs, setters, hash code, equals, toString
    
    public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
    
	public Doctor getDoctor() {
		return doctor;
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

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Long getId() {
		return id;
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

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPesel() {
		return pesel;
	}

	public void setPesel(String pesel) {
		this.pesel = pesel;
	}

	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
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
		Patient other = (Patient) obj;
		if (pesel == null) {
			if (other.pesel != null)
				return false;
		} else if (!pesel.equals(other.pesel))
			return false;
		return true;
	}

		
	@Override
	public String toString() {
		
        return "Patient:"
        		+ "<br>id=" + id + "<br>first name=" + firstName + "<br>last name=" + lastName + "<br>date of birth="
		+ dateOfBirth + "<br>pesel=" + pesel + "<br>disease=" + disease + "<br>password=" + password + "<br>nickname=" + nickname
		+ "<br>doctor of this patient=" + doctor;
	}
	    
}
