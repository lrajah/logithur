package com.formation.logithur.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.logithur.dto.CategoryDto;
import com.formation.logithur.exception.InvalidOperationException;
import com.formation.logithur.persistence.entity.Category;
import com.formation.logithur.persistence.repository.CategoryRepository;
import com.formation.logithur.service.ICategoryService;

@Service
public class CategoryService implements ICategoryService {

	@Autowired
	CategoryRepository categoryRepo;
	
	
	@Override
	public CategoryDto createCategory(CategoryDto categoryDto, String category) {
		Category createCategory = new Category();
		
			
		return new CategoryDto(categoryRepo.save(createCategory));
	}
	
	
	
	
	@Override
	public CategoryDto modifyCategory(CategoryDto categoryDto) {
		return categoryDto;
		
	}
	
	@Override
	public CategoryDto shareCategory(CategoryDto categoryDto) {
		return categoryDto;
		
		
	}
	
	@Override
	public void deleteCategory(CategoryDto categoryDto) {
		categoryRepo.deleteById(categoryDto.getId());
		
		
	}
	
	
	@Override
	public Category findByCategory(String category) {
		Optional<Category> Category = categoryRepo.findByCategory(category);
		return Category.get();
			
	}
	
}
