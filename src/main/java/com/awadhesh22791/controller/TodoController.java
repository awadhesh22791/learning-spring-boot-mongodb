package com.awadhesh22791.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.awadhesh22791.entity.Todo;
import com.awadhesh22791.service.TodoService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1/api/todo")
public class TodoController {

	@Autowired
	private TodoService todoService;

	@GetMapping
	public Flux<Todo> getTodos() {
		return todoService.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Mono<Todo> create(@RequestBody Todo todo) {
		return todoService.create(todo);
	}
	
	@PutMapping
	public Mono<ResponseEntity<Todo>> update(@RequestBody Todo todo) {
		return todoService.update(todo)
				.map(ResponseEntity::ok)
				.defaultIfEmpty(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/{id}")
	public Mono<ResponseEntity<Todo>>findById(@PathVariable("id")String id){
		return todoService.findById(id)
				.map(ResponseEntity::ok)
				.defaultIfEmpty(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/toggleStatus/{id}")
	public Mono<ResponseEntity<Todo>>toggleStatus(@PathVariable("id")String id){
		return todoService.toggleStatus(id)
				.map(ResponseEntity::ok)
				.defaultIfEmpty(ResponseEntity.notFound().build());
	}
}
