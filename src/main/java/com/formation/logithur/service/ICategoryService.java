package com.formation.logithur.service;

import java.text.ParseException;
import java.util.List;

import com.formation.logithur.dto.CategoryDto;

/**
 * Services interface - All the methods implements category services
 * 
 * @author Guyom
 *
 */

public interface ICategoryService {

	/**
	 * Method to find a category
	 * 
	 * @param category
	 * @return
	 */
	CategoryDto findByCategory(String category);

	/**
	 * Method to create a new category
	 * 
	 * @param categoryDto
	 * @param category
	 * @return
	 * @throws ParseException
	 */
	CategoryDto createCategory(CategoryDto categoryDto, String category);

	/**
	 * Method to modify a current category
	 * 
	 * @param categoryDto
	 * @return
	 * @throws ParseException
	 */
	CategoryDto modifyCategory(CategoryDto categoryDto);

	/**
	 * Method to share a category with different users
	 * 
	 * @param categoryDto
	 * @return
	 * @throws ParseException
	 */
	CategoryDto shareCategory(CategoryDto categoryDto);

	/**
	 * Method to
	 * 
	 * @param categoryDto
	 * @throws ParseException
	 */
	void deleteCategory(CategoryDto categoryDto);
	
	List<CategoryDto> categoryByUser(String user);

}
