package com.awadhesh22791.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	public Mono<Todo> create(@RequestBody Todo todo) {
		return todoService.create(todo);
	}
	
}
