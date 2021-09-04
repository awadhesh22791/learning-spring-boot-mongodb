package com.awadhesh22791.service;

import com.awadhesh22791.entity.Todo;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TodoService {
	public Flux<Todo> findAll();

	public Mono<Todo> create(Todo todo);
}