package com.prueba.Utils;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

public class Validation {
	
	// RFC pattern validation (simplified)
    private static final Pattern RFC_PATTERN = Pattern.compile("^[A-Z&Ñ]{3,4}[0-9]{6}[A-Z0-9]{3}$");
    
    // Phone pattern (AndresFormat)
    private static final Pattern PHONE_PATTERN = Pattern.compile("^\\+?[0-9\\s]{10,15}$");
    
    public static boolean isValidRFC(String rfc) {
        return rfc != null && RFC_PATTERN.matcher(rfc).matches();
    }
    
    public static boolean isValidPhone(String phone) {
        if (phone == null) return false;
        String cleanPhone = phone.replaceAll("\\s", "");
        return PHONE_PATTERN.matcher(phone).matches() && cleanPhone.length() >= 10;
    }
    
   
}
