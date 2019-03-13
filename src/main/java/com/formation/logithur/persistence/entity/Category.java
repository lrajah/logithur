package com.formation.logithur.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.formation.logithur.dto.CategoryDto;
import com.formation.logithur.persistence.repository.UserRepository;

@Entity
@Table(name = "Category")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "category", length = 20, nullable = false)
	private String category;

	@Column(name = "user", nullable = false)
	private String user;

	public Category(CategoryDto categoryDto, UserRepository userRepo) {
		this.setId(categoryDto.getId());
		this.setCategory(categoryDto.getCategory());
		this.setUser(categoryDto.getUser());
		
		
	}
	
	public Category() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public boolean isPresent() {
		return false;
	}

}
