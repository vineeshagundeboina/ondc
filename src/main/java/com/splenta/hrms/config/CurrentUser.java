package com.splenta.hrms.config;

import java.util.Collection;
import java.util.UUID;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;


import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CurrentUser extends User {
	public CurrentUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}
	private static final long serialVersionUID = 1L;
	private UUID id;
	private String userName;
}
