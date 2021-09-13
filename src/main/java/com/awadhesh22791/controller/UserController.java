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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.awadhesh22791.entity.User;
import com.awadhesh22791.service.UserService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1/api/user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping
	public Flux<User> getTodos(@RequestParam(name = "username",required = false)String username) {
		return userService.findAll(username);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Mono<User> create(@RequestBody User user) {
		return userService.create(user);
	}

	@PutMapping
	public Mono<ResponseEntity<User>> update(@RequestBody User user) {
		return userService.update(user).map(ResponseEntity::ok).defaultIfEmpty(ResponseEntity.notFound().build());
	}

	@GetMapping("/{id}")
	public Mono<ResponseEntity<User>> findById(@PathVariable("id") String id) {
		return userService.findById(id).map(ResponseEntity::ok).defaultIfEmpty(ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{id}")
	public Mono<ResponseEntity<Void>> delete(@PathVariable("id") String id) {
		return userService.delete(id)
				.flatMap(status->{
					if(status) {
						return Mono.just(ResponseEntity.ok().<Void>build());
					} else {
						return Mono.just(ResponseEntity.badRequest().<Void>build());
					}
				})
				.defaultIfEmpty(ResponseEntity.notFound().<Void>build());
	}
}
