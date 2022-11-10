package com.cloth.validation;



import org.springframework.stereotype.Component;
@Component
public class CommonValidation {
	public boolean validateOnlyAlphabet(String str) {
		return ((!str.equals(""))
	            && (str != null)
	            && (str.matches("[a-zA-Z]*")));
	}
	
}
