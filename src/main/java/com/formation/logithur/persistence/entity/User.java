package com.formation.logithur.persistence.entity;

import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.formation.logithur.dto.UserDto;
import com.formation.logithur.persistence.repository.UserRepository;

@Entity
@Table(name="user")
public class User {
	
	// Attribute's Declaration
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "id", unique = true, nullable = false)
	private Long id;
	
	@Column (name = "email", length = 60, unique = true, nullable = false)
	private String email;
	
	@Column (name = "nickname", length = 20, unique = true, nullable = false)
	private String nickname;
	
	@Column (name = "password", length = 20, nullable = false)
	private String password;
	
	@Column (name = "mark")
	private Double mark;
	
	// Constructor
	
		public User() { }
	
		public User(UserDto user, UserRepository userRepo) {
			this.setEmail(user.getEmail());
			this.setNickname(user.getNickname());
			this.setMark(user.getMark());
			Optional<User> userTmp = userRepo.findById(user.getId());
		}
			
	// Getters And Setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
