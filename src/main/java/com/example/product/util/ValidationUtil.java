package com.example.product.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationUtil {

	public static boolean isValidContact(String value ) {
		String num=  "(?:\\s+|)((0|(?:(\\+|)91))(?:\\s|-)*(?:(?:\\d(?:\\s|-)*\\d{9})|(?:\\d{2}(?:\\s|-)*\\d{8})|(?:\\d{3}(?:\\s|-)*\\d{7}))|\\d{10})(?:\\s+|)";
	    Pattern p = Pattern.compile(num);
	    String  s = String.valueOf(value);
	    Matcher m = p.matcher(s);
	    return m.matches();
	} 
	
	public static boolean isValidEmailId(String value) {
		String email="^(?=.{1,64}@)[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z0-9.]+$";
		Pattern p = Pattern.compile(email);
		Matcher m = p.matcher(value);
		return m.matches();
	}
	
	public static boolean isValidName(String value) {
		String name= "^(?=.{1,40}$)[a-zA-Z]+(?:[-'\\\\s][a-zA-Z]+)*$ ";
		Pattern p = Pattern.compile(name);
		Matcher m = p.matcher(value);
		return m.matches();
	}
	
	 public static boolean isNullOrEmpty(String value) {
	        return null == value || value.trim().isEmpty();
	    }
	 
}
