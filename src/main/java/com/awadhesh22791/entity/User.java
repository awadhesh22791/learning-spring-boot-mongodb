package com.awadhesh22791.entity;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.awadhesh22791.dto.AuthenticatedUser;

import lombok.Data;
import lombok.ToString;

@Scope(scopeName = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Document
@Data
@ToString
public class User {
	@Id
	private String id;
	private String username;
	private String password;
	
	public AuthenticatedUser toAuthUser() {
		AuthenticatedUser user=new AuthenticatedUser(this.username, this.password, null);
		return user;
    }
}
