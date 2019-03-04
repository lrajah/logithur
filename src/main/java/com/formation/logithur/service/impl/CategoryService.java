package com.formation.logithur.service.impl;

import java.text.ParseException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.formation.logithur.dto.CategoryDto;
import com.formation.logithur.persistence.entity.Category;
import com.formation.logithur.persistence.repository.CategoryRepository;
import com.formation.logithur.service.ICategoryService;

public class CategoryService implements ICategoryService {

	@Autowired
	CategoryRepository categoryRepo;
	
	@Override
	public Optional<Category> findByCategory(String category) {
		return null;
		
	}
	
	@Override
	public CategoryDto createCategory(CategoryDto categoryDto, String category) throws ParseException {
		return categoryDto;
	}
	
	@Override
	public CategoryDto modifyCategory(CategoryDto categoryDto) throws ParseException {
		return categoryDto;
		
	}
	
	@Override
	public CategoryDto shareCategory(CategoryDto categoryDto) throws ParseException {
		return categoryDto;
		
		
	}
	
	@Override
	public void deleteCategory(CategoryDto categoryDto) throws ParseException {
		categoryRepo.deleteById(categoryDto.getId());
		
		
	}
}
