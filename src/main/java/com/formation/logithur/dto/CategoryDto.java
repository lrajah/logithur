package com.formation.logithur.dto;

import com.formation.logithur.persistence.entity.Category;

/**
 * Category's Dto
 * 
 * @author Guyom
 *
 */

public class CategoryDto {

	/**
	 * Attribute's declaration
	 */

	private Long id;

	private String category;
	
	private UserDto users;
	

	
	/**
	 * Dto Category Constructor with user
	 * 
	 * @return
	 */

	public CategoryDto(Category category) {
		this.setId(category.getId());
		this.setCategory(category.getCategory());
		this.setUsers(new UserDto(category.getUsers()));
	}
	
	
	/**
	 * Dto Category Constructor (default)
	 */
	
	public CategoryDto() {
	}

	
	public boolean isPresent() {
		return false;
	}


	// Getters and Setters

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

	public UserDto getUsers() {
		return users;
	}

	public void setUsers(UserDto users) {
		this.users = users;
	}

}
