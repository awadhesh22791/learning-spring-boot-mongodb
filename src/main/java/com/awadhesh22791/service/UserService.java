package com.awadhesh22791.service;

import com.awadhesh22791.entity.User;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {

	Flux<User> findAll(String username);

	Mono<User> create(User user);

	Mono<User> update(User user);

	Mono<User> findById(String id);

	Mono<Boolean> delete(String id);

	Mono<Long> countUsers();

}
