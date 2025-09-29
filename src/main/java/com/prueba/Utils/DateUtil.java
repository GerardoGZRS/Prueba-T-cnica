package com.prueba.Utils;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {
	
	 public static String getCurrentMadagascarTime() {
	        ZoneId madagascarZone = ZoneId.of("Indian/Antananarivo");
	        ZonedDateTime now = ZonedDateTime.now(madagascarZone);
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
	        return now.format(formatter);
	    }


}
