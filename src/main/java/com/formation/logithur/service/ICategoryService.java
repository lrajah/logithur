package com.formation.logithur.service;

import java.text.ParseException;
import java.util.Optional;

import com.formation.logithur.dto.CategoryDto;
import com.formation.logithur.persistence.entity.Category;


	/**
	 * Services interface - All the methods implements category services
	 * @author Guyom
	 *
	 */

public interface ICategoryService {
	
	/**
	 * Method to find a category
	 * @param category
	 * @return
	 */
	//Optional<Category> findByCategory(String category);	
	
	/**
	 * Method to create a new category
	 * @param categoryDto
	 * @param category
	 * @return
	 * @throws ParseException
	 */
	CategoryDto createCategory(CategoryDto categoryDto, String category);
	
	/**
	 * Method to modify a current category
	 * @param categoryDto
	 * @return
	 * @throws ParseException
	 */
	CategoryDto modifyCategory(CategoryDto categoryDto);
	
	/**
	 * Method to share a category with different users
	 * @param categoryDto
	 * @return
	 * @throws ParseException
	 */
	CategoryDto shareCategory(CategoryDto categoryDto);
	
	/**
	 * Method to 
	 * @param categoryDto
	 * @throws ParseException
	 */
	void deleteCategory(CategoryDto categoryDto);

}
