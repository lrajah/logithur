/**
 * 
 */
package com.formation.logithur.dto;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.formation.logithur.persistence.entity.Category;
import com.formation.logithur.persistence.entity.Task;
import com.formation.logithur.persistence.entity.User;

/**
 * @author Dell
 *
 */
public class TaskDto {

	private Long id;

	private String label;

	private String priority;

	private String deadline;

	private Category category;
	
	private boolean state;

	private List<UserDto> users;

	public TaskDto(Task t) {
		
		this.setId(t.getId());
	    Date date = t.getDeadline(); 
	    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");  
	    String strDate = dateFormat.format(date);
		this.setDeadline(strDate);
		this.setLabel(t.getLabel());
		this.setPriority(t.getPriority());
		this.setCategory(t.getCategory());
		
		this.setUsers(t.getUsers().stream().map(c -> new UserDto(c)).collect(Collectors.toList()));
		this.setState(t.getState());
	}
	
	
	public TaskDto() {
		
	}
	
	

	public boolean isState() {
		return state;
	}


	public void setState(boolean state) {
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<UserDto> getUsers() {
		return users;
	}

	public void setUsers(List<UserDto> users) {
		this.users = users;
	}

}
