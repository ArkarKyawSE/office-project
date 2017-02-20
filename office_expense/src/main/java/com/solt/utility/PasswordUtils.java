package com.solt.utility;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class PasswordUtils {

	public static String encript(String pass) {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] data = digest.digest(pass.getBytes());
			return Base64.getEncoder().encodeToString(data);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		String pass = encript("admin");
		System.out.println(pass);
	}
}
