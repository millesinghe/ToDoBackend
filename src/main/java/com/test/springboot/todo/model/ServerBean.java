package com.test.springboot.todo.model;

public class ServerBean {

	private String message;

	public ServerBean(String message) {
		this.setMessage(message);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
}
