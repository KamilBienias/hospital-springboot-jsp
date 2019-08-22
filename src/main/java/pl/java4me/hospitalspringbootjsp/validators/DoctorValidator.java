package pl.java4me.hospitalspringbootjsp.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import pl.java4me.hospitalspringbootjsp.entities.Doctor;


@Component//po to zeby spring mogl znalezc ten walidator i go wstrzyknac w klasie AddDoctorController w miejscu @Autowired DoctorValidator doctorValidator;
public class DoctorValidator implements Validator {

//	@Override// u niego jest ta adnotacja, ale u mnie blad wiec usunalem
	public boolean supports(Class<?> clazz) {// czy klasa przypieta do formularza obsluguje walidator
		return Doctor.class.isAssignableFrom(clazz);
	}

//	@Override// u niego jest ta adnotacja, ale u mnie blad wiec usunalem 
	public void validate(Object target, Errors errors) {
		
		Doctor doctor = (Doctor) target;
//		SimpleDateFormat formatowanie = new SimpleDateFormat("dd-MM-yyyy");// data bedzie sformatowana do Stringa
		
		
		validate(ValidatorEnum.FIRSTNAME, doctor.getFirstName(), "firstName", errors);//metoda przeciazona
		validate(ValidatorEnum.LASTNAME, doctor.getLastName(), "lastName", errors);
		validate(ValidatorEnum.PESEL, doctor.getPesel(), "pesel", errors);
		validate(ValidatorEnum.PASSWORD, doctor.getPassword(), "password", errors);

		
//		validate(ValidatorEnum.DATEOFBIRTH, formatowanie.format(doctor.getDateOfBirth()), "dateOfBirth", errors);
		
//		validate(ValidatorEnum.DATEOFBIRTH, 
//				String.valueOf(doctor.getDateOfBirth().get(GregorianCalendar.DAY_OF_MONTH)) + "-" +
//                String.valueOf((doctor.getDateOfBirth().get(GregorianCalendar.MONTH) + 1)) + "-" + 
//						String.valueOf(doctor.getDateOfBirth().get(GregorianCalendar.YEAR)),
//						"dateOfBirth", errors);
		
//		validate(ValidatorEnum.DATEOFBIRTH, doctor.getDateOfBirth(), "getDateOfBirth", errors);
		
		
//		validate(ValidatorEnum.EMAIL, user.getEmail(), "email", errors);
		
		String password = doctor.getPassword();
		String confirmPassword = doctor.getConfirmPassword();
		if(!password.equals(confirmPassword)) {//spr czy hasla nie sa rozne
			errors.rejectValue("password", "err_code", "Password must be the same");
		}
	}
	
	private void validate(ValidatorEnum validator, String value, String fieldName, Errors errors) {
		String patternReg = validator.getPattern();
		Pattern pattern = Pattern.compile(patternReg);
		Matcher matcher = pattern.matcher(value);
		if(!matcher.matches()) {//jesli wystapil blad to wywoluje metode rejectValue
			errors.rejectValue(fieldName, validator.getErrCode(), validator.getErrMessage());
		}
	}

}
