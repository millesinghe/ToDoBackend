package com.test.springboot.todo.model;

import java.util.Date;

public class ToDo {

	private int id;
	private String username;
	private String task;
	private Date date;
	private boolean status;
	
	
	
	public ToDo() {}

	public ToDo(int id, String username, String task, Date date, boolean status) {
		super();
		this.id = id;
		this.username = username;
		this.task = task;
		this.date = date;
		this.status = status;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
}
