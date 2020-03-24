package com.test.springboot.todo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.springboot.todo.model.ToDo;

public interface ToDoRepository extends JpaRepository<ToDo, Long> {

	public List<ToDo> findByUsername(String username);
}
