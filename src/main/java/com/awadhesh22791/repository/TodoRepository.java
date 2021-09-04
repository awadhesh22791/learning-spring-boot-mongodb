package com.awadhesh22791.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.awadhesh22791.entity.Todo;

@Repository
public interface TodoRepository extends ReactiveMongoRepository<Todo, String> {

}
