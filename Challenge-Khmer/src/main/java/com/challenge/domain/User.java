package com.challenge.domain;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

public class User {
	
	@Id
	@Column(name = "email")
	private String email;
	
	@Column(name = "name")
    private String name;
	
	@Column(name = "enabled")
    private String enabled;
	
	@Column(name = "password")
    private String password;
 
    @Enumerated(EnumType.STRING)
    @Column(name = "user_role")
    private Role role;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	

}
