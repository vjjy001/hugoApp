package com.collabera.hackton.common;

import org.springframework.stereotype.Component;

@Component
public class HugoHelper {

	public static String dataValidation(String text) {
		text = text.toLowerCase().trim();
		if(text.contains("form f1c") || text.contains("form f 1 c")
		  || text.contains("formf1c")
		  || text.contains("form1c")) {
			
			return "i want form f one c";
		}else if(text.contains("form f62") || text.contains("form f 6 2")
				  || text.contains("formf62")
				  || text.contains("form62")) {
			return "i want form six two";
		}
		
		return text;

	}
}
