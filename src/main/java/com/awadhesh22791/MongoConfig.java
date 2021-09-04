package com.awadhesh22791;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.ReactiveMongoDatabaseFactory;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;

@Configuration
@EnableReactiveMongoRepositories(basePackages = "com.awadhesh22791.repository")
public class MongoConfig extends AbstractReactiveMongoConfiguration {

	@Value("${port}")
	private String port;

	@Value("${dbname}")
	private String dbName;

	@Override
	public MongoClient reactiveMongoClient() {
		return MongoClients.create();
	}

	@Override
	public ReactiveMongoTemplate reactiveMongoTemplate(ReactiveMongoDatabaseFactory databaseFactory,
			MappingMongoConverter mongoConverter) {
		return new ReactiveMongoTemplate(reactiveMongoClient(), getDatabaseName());
	}

	@Override
	protected String getDatabaseName() {
		return dbName;
	}

}
