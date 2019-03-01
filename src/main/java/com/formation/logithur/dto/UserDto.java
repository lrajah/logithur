package com.formation.logithur.dto;

import com.formation.logithur.persistence.entity.User;

public class UserDto {
	
	// Attribute's Declaration
	
	private Long id;
	
	private String email;
	
	private String nickname;
	
	private String password;
	
	private Double mark;
	
		
	// Constructor
	
	public UserDto() { } 
	
	public UserDto(User user) {
		this.setId(user.getId());
		this.setEmail(user.getEmail());
		this.setNickname(user.getNickname());
		this.setMark(user.getMark());
		this.setPassword(null);
	}
	
	// Getters and Setters

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Double getMark() {
		return mark;
	}

	public void setMark(Double mark) {
		this.mark = mark;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
