package com.test.springboot.todo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ToDo {

	@Id
	@GeneratedValue
	private Long id;
	
	private String username;
	private String task;
	private Date deadline;
	private boolean status;
	
	public ToDo() {}

	public ToDo(Long id, String username, String task, Date deadline, boolean status) {
		super();
		this.id = id;
		this.username = username;
		this.task = task;
		this.setDeadline(deadline);
		this.status = status;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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

	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}	
	
}
