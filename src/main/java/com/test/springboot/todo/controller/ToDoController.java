package com.test.springboot.todo.controller;

import java.io.IOException;
import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.springboot.todo.model.ToDo;
import com.test.springboot.todo.repository.ToDoRepository;
import com.test.springboot.todo.service.ToDoService;

@RestController
@CrossOrigin("http://localhost:4200")
public class ToDoController {
	
	@Autowired
	private ToDoService todoService;

	@Autowired
	private ToDoRepository repoTodo;

	@GetMapping("users/{username}/todos/test")
	public String testServer() {

		return "Server is Up and Runing Todos";
	}
	
	@GetMapping("users/{username}/todos")
	public List<ToDo> getAllTodos(@PathVariable String username){
		//return todoService.findAll();
		return repoTodo.findByUsername(username);
	}
	
	@GetMapping("users/{username}/todos/{id}")
	public ToDo getToDo(@PathVariable String username, @PathVariable String id){
		//return todoService.findById(Integer.parseInt(id));
		return repoTodo.findById(Long.parseLong(id)).get();
	}
	
	@PostMapping("users/{username}/todos")
	public ResponseEntity<ToDo> addToDo(@PathVariable String username, @RequestBody ToDo todo) throws JsonParseException, JsonMappingException, IOException{
		//ToDo td =  todoService.save(todo);
		todo.setUsername(username);
		ToDo td =  repoTodo.save(todo);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(td.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping("users/{username}/todos/{id}")
	public ResponseEntity<ToDo> updateToDo(@PathVariable String username,@PathVariable String id, @RequestBody ToDo todo) throws JsonParseException, JsonMappingException, IOException{
		//ToDo td =  todoService.save(todo);
		ToDo td =  repoTodo.save(todo);
		return new ResponseEntity<ToDo> (td, HttpStatus.OK);
	}
	
	@DeleteMapping("users/{username}/todos/{id}")
	public ResponseEntity<Void> deleteToDo(@PathVariable String username,@PathVariable String id){
		
		/*ToDo todo =  todoService.deleteTodo(Integer.parseInt(id));
		
		if (todo != null){
			return ResponseEntity.noContent().build();
		}else{
			return ResponseEntity.notFound().build();
		}*/
		
		repoTodo.deleteById(Long.parseLong(id));
		
		return ResponseEntity.noContent().build();
	}
}
