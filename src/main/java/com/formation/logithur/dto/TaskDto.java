/**
 * 
 */
package com.formation.logithur.dto;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.formation.logithur.persistence.entity.Category;
import com.formation.logithur.persistence.entity.Task;

/**
 * @author Dell
 *
 */
public class TaskDto {

	private Long id;

	private String label;

	private String priority;

	private String deadline;

	private CategoryDto category;
	
	private Integer state;

	private UserDto users;

	public TaskDto(Task t) {
		
		this.setId(t.getId());
	    Date date = t.getDeadline(); 
	    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");  
	    String strDate = dateFormat.format(date);
		this.setDeadline(strDate);
		this.setLabel(t.getLabel());
		this.setPriority(t.getPriority());
		this.setCategory(new CategoryDto(t.getCategory()));
		this.setUsers(new UserDto(t.getUsers()));
		this.setState(t.getState());
		
	}
	
	public TaskDto() {
		
	}
	
	
	

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getDeadline() {
		return deadline;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}

	

	public CategoryDto getCategory() {
		return category;
	}

	public void setCategory(CategoryDto category) {
		this.category = category;
	}

	public UserDto getUsers() {
		return users;
	}

	public void setUsers(UserDto users) {
		this.users = users;
	}

}
