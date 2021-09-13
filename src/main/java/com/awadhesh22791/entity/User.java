package com.awadhesh22791.entity;

import java.util.Date;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.domain.Persistable;
import org.springframework.data.mongodb.core.mapping.Document;

import com.awadhesh22791.dto.AuthenticatedUser;

import lombok.Data;
import lombok.ToString;

@Scope(scopeName = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Document
@Data
@ToString
public class User implements Persistable<String>{
	@Id
	private String id;
	private String username;
	private String password;
	@CreatedDate
	private Date createdDate;
	@LastModifiedDate
	private Date lastModifiedDate;
	@Version
	private Integer version;
	
	public AuthenticatedUser toAuthUser() {
		AuthenticatedUser user=new AuthenticatedUser(this.username, this.password, null);
		return user;
    }

	@Override
	public boolean isNew() {
		return version == null;
	}
}
