package com.test.springboot.todo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.test.springboot.todo.model.ToDo;

@Service
public class ToDoService {

	private static List<ToDo> todos = new ArrayList<ToDo>();
	private static long id = 0;

	static {
		todos.add(new ToDo(++id, "admin", "wedding", new Date(), false));
		todos.add(new ToDo(++id, "admin", "Full Stack Couse", new Date(), false));
		todos.add(new ToDo(++id, "admin", "Visit Singapore", new Date(), false));
		todos.add(new ToDo(++id, "admin", "Find a Job", new Date(), false));
	}

	public List<ToDo> findAll() {
		return todos;
	}

	public ToDo deleteTodo(long id) {
		ToDo todo = this.findById((int) id);
		if (todo == null) {
			return null;
		}
		if (todos.remove(todo)) {
			return todo;
		}
		return null;

	}

	public ToDo save(ToDo todo) {

		if (todo.getId() == 0) {
			todo.setId(++id);
			todos.add(todo);
		} else {
			this.deleteTodo(todo.getId());
			todos.add(todo);
		}
		return todo;

	}

	public ToDo findById(int id) {

		for (ToDo todo : todos) {
			if (todo.getId() == id) {
				return todo;
			}
		}
		return null;
	}
}
