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
	
	private String user;
	

	
	/**
	 * Dto Category Constructor with user
	 * 
	 * @return
	 */

	public CategoryDto(Category category) {
		this.setId(category.getId());
		this.setCategory(category.getCategory());
		this.setUser(category.getUser());
	
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


	public String getUser() {
		return user;
	}


	public void setUser(String user) {
		this.user = user;
	}

	

}
