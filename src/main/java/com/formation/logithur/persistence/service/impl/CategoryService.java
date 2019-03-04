package com.formation.logithur.persistence.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.logithur.persistence.entity.Category;
import com.formation.logithur.persistence.repository.CategoryRepository;
import com.formation.logithur.persistence.service.ICategoryInterface;



@Service
@Transactional
public class CategoryService implements ICategoryInterface {
	
	@Autowired
	CategoryRepository categoryRepository;
	
	
	public static void createCategory(String category) {

	}
	
	public static void deleteCategory() {
		
	}
	
	public static void modifyCategory() {
		
	}
	
	public static void shareCategory() {
		
	}
}
