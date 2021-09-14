package com.awadhesh22791;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.reactive.config.EnableWebFlux;

import com.awadhesh22791.entity.User;
import com.awadhesh22791.service.UserService;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@EnableWebFlux
@Slf4j
public class LearningSpringBootMongoApplication implements CommandLineRunner{
	
	@Autowired
	private UserService userService;
	public static void main(String[] args) {
		SpringApplication.run(LearningSpringBootMongoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		userService.countUsers().subscribe(count->{
			if(count==0) {
				User newUser = new User();
				newUser.setUsername("demo");
				newUser.setPassword("demo");
				userService.create(newUser).subscribe(newUserDetail->{
					log.info("User created with details {}.",newUserDetail);
				});
			}
		});
	}

}
