package pl.java4me.hospitalspringbootjsp.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import pl.java4me.hospitalspringbootjsp.entities.Patient;


@Component//po to zeby spring mogl znalezc ten walidator i go wstrzyknac w klasie RegisterController w miejscu @Autowired UserValidator userValidator;
public class PatientLoginValidator implements Validator {

//	@Override// u niego jest ta adnotacja, ale u mnie blad wiec usunalem
	public boolean supports(Class<?> clazz) {// czy klasa przypieta do formularza obsluguje walidator
		return Patient.class.isAssignableFrom(clazz);
	}

//	@Override// u niego jest ta adnotacja, ale u mnie blad wiec usunalem 
	public void validate(Object target, Errors errors) {
		
		Patient patient = (Patient) target;
//		SimpleDateFormat formatowanie = new SimpleDateFormat("dd-MM-yyyy");// data bedzie sformatowana do Stringa
		
		validate(ValidatorEnum.NICKNAME, patient.getNickname(), "nickname", errors);
		validate(ValidatorEnum.PASSWORD, patient.getPassword(), "password", errors);
	}
	
	private void validate(ValidatorEnum validator, String value, String fieldName, Errors errors) {
		String patternReg = validator.getPattern();
		Pattern pattern = Pattern.compile(patternReg);
		Matcher matcher = pattern.matcher(value);
		if(!matcher.matches()) {//jesli wystapil blad to wywoluje metode refectValue
			errors.rejectValue(fieldName, validator.getErrCode(), validator.getErrMessage());
		}
	}

}

