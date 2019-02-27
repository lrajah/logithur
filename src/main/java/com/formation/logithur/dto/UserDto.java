package com.formation.logithur.dto;

import com.formation.logithur.persistence.entity.User;

public class UserDto {
	
	// Attribute's Declaration
	
	private String email;
	
	private String nickname;
	
	private Double mark;
		
	// Constructor
	
	public UserDto() { } 
	
	public UserDto(User user) {
		this.setEmail(user.getEmail());
		this.setNickname(user.getNickname());
		this.setMark(user.getMark());
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
	
}
