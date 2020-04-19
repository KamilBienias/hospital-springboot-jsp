package pl.java4me.hospitalspringbootjsp.validators;

public enum ValidatorEnum {

	FIRSTNAME("[a-zA-z]{3,}", "err_code", "User name should contain a minimum of 3 characters, which are letters or numbers"),
	LASTNAME("[a-zA-z]{3,}", "err_code", "User name should contain a minimum of 3 characters, which are letters or numbers"),
//	DATEOFBIRTH("[0-9]{2}-[0-9]{2}-[0-9]{4}","err_code", "Date of birth should look dd-MM-yyyy"),
	PESEL("[0-9]{2}[0-3]{1}[0-9]{1}[0-3]{1}[0-9]{6}", "err_code", "The pesel should contain 11 digits, of which the first 6 form the birth date yy-MM-dd in database."),
	PASSWORD("[a-zA-z0-9]{6,}", "err_code", "Password should contain a minimum of 6 characters, which are letters or numbers"),
	NICKNAME("[a-z]{6}[0-9]{1}", "err_code", "Nickme should contain 6 characters and last digit"),
//	EMAIL("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$","err_code", "Email format required");
	SALARY("[0-9]{1,}", "err_code", "Salary shoud be a number.");
//	BONUS("[0-9]{0,}", "err_code", "Bonus shoud be true or false.");
	
	private String pattern;//wyrazenie regularne
	private String errCode;//klucz do pliku properties, z ktorych na razie nie korzystamy
	private String errMessage;//wiadomosc ktora zostanie wyswietlona w przypadku zlej walidacji
	
	private ValidatorEnum(String pattern, String errCode, String errMessage) {
		this.pattern = pattern;
		this.errCode = errCode;
		this.errMessage = errMessage;
	}

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	public String getErrMessage() {
		return errMessage;
	}

	public void setErrMessage(String errMessage) {
		this.errMessage = errMessage;
	}
	
}
