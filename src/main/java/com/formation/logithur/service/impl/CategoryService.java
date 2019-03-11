package com.formation.logithur.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.logithur.dto.CategoryDto;
import com.formation.logithur.exception.NotFoundException;
import com.formation.logithur.persistence.entity.Category;
import com.formation.logithur.persistence.repository.CategoryRepository;
import com.formation.logithur.persistence.repository.UserRepository;
import com.formation.logithur.service.ICategoryService;

@Service
public class CategoryService implements ICategoryService {

	@Autowired
	CategoryRepository categoryRepo;
	@Autowired
	UserRepository userRepo;

	@Override
	public CategoryDto findByCategory(String category) {

		Optional<Category> categoryFound = categoryRepo.findByCategory(category);

		if (!(categoryFound.isPresent())) {

			throw new NotFoundException("This category doesn't exist !");

		} else {

			return new CategoryDto(categoryFound.get());
		}
	}

	@Override
	public CategoryDto createCategory(CategoryDto categoryDto, String category) {
		
		Category createCategory = new Category(categoryDto, userRepo);

		return new CategoryDto(categoryRepo.save(createCategory));
	}

	@Override
	public CategoryDto modifyCategory(CategoryDto categoryDto) {
		
		Category modifyCategory = new Category(categoryDto, userRepo);

		if (!(modifyCategory.isPresent())) {

			throw new NotFoundException("This category doesn't exist !");

		} else {

			return new CategoryDto(categoryRepo.save(modifyCategory));
		}
	}

	@Override
	public CategoryDto shareCategory(CategoryDto categoryDto) {
		
		return categoryDto;
	}

	@Override
	public void deleteCategory(CategoryDto categoryDto) {
	
		categoryRepo.deleteById(categoryDto.getId());
	}

}
