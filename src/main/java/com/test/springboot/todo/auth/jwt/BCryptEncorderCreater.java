package com.test.springboot.todo.auth.jwt;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptEncorderCreater {

	public static void main(String[] args) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String password = encoder.encode("toor");
		System.out.println(password);
	}

}
