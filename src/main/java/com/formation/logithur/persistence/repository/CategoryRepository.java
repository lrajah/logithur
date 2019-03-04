package com.formation.logithur.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.formation.logithur.persistence.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

	
	
}
