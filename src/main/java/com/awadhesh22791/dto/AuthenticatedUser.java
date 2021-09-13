package com.awadhesh22791.dto;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class AuthenticatedUser implements UserDetails {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6657955273614432606L;
	private String username;
	private Collection<GrantedAuthority> authorities;
	private String password;

	public AuthenticatedUser(String username, String password, Collection<GrantedAuthority> authorities) {
		this.username = username;
		this.authorities = authorities;
		this.password = password;
	}

	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		return this.authorities;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
