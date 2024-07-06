package com.example.product.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationUtil {

   private ValidationUtil() {
		
    }
   
	public static boolean isValidContact(String contact ) {
		if(contact.length()>=10) {
			return true;
		}
		return false;
	} 
	
	public static boolean isValidEmailId(String value) {
		String email="^(?=.{1,64}@)[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z0-9.]+$";
		Pattern p = Pattern.compile(email);
		Matcher m = p.matcher(value);
		return m.matches();
	}
	
	 public static boolean isValidName(String value) {
	        String regex = "^(?=.{1,25}$)[a-zA-Z]+(?:[-'\\s][a-zA-Z]+)*$";
	        Pattern p = Pattern.compile(regex);
	        Matcher m = p.matcher(value);
	        return m.matches();
	    }
	
	 public static boolean isNullOrEmpty(String value) {
	        return null == value || value.trim().isEmpty();
	    }

	public static boolean isNull(int id) {
		return false;
	}

	public static String getFormattedString(String value) {
		 if (value != null) {
	            return value.trim();
	        }
	        return value;
	    }
	
	
	 
}
