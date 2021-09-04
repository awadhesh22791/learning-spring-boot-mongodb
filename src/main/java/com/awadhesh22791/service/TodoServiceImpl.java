package com.awadhesh22791.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.awadhesh22791.entity.Todo;
import com.awadhesh22791.repository.TodoRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TodoServiceImpl implements TodoService {
	@Autowired
	private TodoRepository todoRepository;

	@Override
	public Flux<Todo> findAll() {
		return todoRepository.findAll();
	}

	@Override
	public Mono<Todo> create(Todo todo) {
		Mono<Todo> savedTodo = todoRepository.save(todo);
		return savedTodo;
	}
}
