package com.test.springboot.todo.model;

public class AuthenticateBean {
	private String message;

	public AuthenticateBean(String message) {
		this.setMessage(message);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
