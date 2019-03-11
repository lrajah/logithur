/**
 * 
 */
package com.formation.logithur.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.formation.logithur.dto.CategoryDto;
import com.formation.logithur.service.ICategoryService;

/**
 * @author Guyom
 *
 */

@RestController
@RequestMapping(value = "/api/client/category")
public class CategoryController {

	@Autowired
	ICategoryService categoryServ;
	
	@PostMapping(value = "/add")
	@ResponseBody
	CategoryDto createCategory(@RequestBody CategoryDto categoryDto) {
		return categoryServ.createCategory(categoryDto, categoryDto.getCategory());
	}

	@PutMapping(value = "/modify")
	@ResponseBody
	CategoryDto modifyCategory(@RequestBody CategoryDto categoryDto) {
		return categoryServ.modifyCategory(categoryDto);
	}

	@PostMapping(value = "/share")
	@ResponseBody
	CategoryDto shareCategory(@RequestBody CategoryDto categoryDto) {
		return categoryServ.shareCategory(categoryDto);
	}

	@DeleteMapping(value = "/delete")
	@ResponseBody
	void deleteCategory(@RequestBody CategoryDto categoryDto) {
		categoryServ.deleteCategory(categoryDto);
	}

}
