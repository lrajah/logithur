package com.formation.logithur.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

	@ManyToOne
	@JoinColumn(name = "idUser", referencedColumnName = "id", unique = true, nullable = false)
	private User users;

	public Category(CategoryDto category, UserRepository userRepo) {
		this.setId(category.getId());
		this.setCategory(category.getCategory());
		this.setUsers(new User());
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

	public User getUsers() {
		return users;
	}

	public void setUsers(User users) {
		this.users = users;
	}

	public boolean isPresent() {
		return false;
	}

}
