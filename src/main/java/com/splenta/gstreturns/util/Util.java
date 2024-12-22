package com.splenta.gstreturns.util;

import java.util.Base64;

import org.springframework.context.annotation.Configuration;

@Configuration
public class Util {

	public String generateBase64Code(String mainObject) {
		// Encode to Base64

		String encodedString = Base64.getEncoder().encodeToString(mainObject.getBytes());
		System.out.println("Encoded string: " + encodedString);
		return encodedString;

	}

}
