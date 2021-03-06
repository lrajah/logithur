/**
 * 
 */
package com.formation.logithur.persistence.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.formation.logithur.dto.TaskDto;
import com.formation.logithur.exception.InvalidOperationException;
import com.formation.logithur.persistence.repository.UserRepository;

/**
 * @author Dell
 *
 */

@Entity
@Table (name ="task")
public class Task {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "id", unique = true, nullable = false)
	private Long id;
	@Column (name = "label", length = 50, nullable=false)
	private String label;
	
	@Column (name = "priority", length = 10, nullable=false)
	private String priority;
	
	@Column (name = "deadline", nullable=false)
	private Date deadline;
	
	@Column (name = "state", nullable=false)
	private Integer state;
	
	@ManyToOne
	@JoinColumn(name = "idCategory", referencedColumnName = "id", nullable = true)
	private Category category;
	
	@ManyToOne
	@JoinColumn(name = "idUser", referencedColumnName = "id", nullable = false)
	private User users;
	
	
	public Task(TaskDto t, UserRepository userRepo) throws ParseException,InvalidOperationException {
		this.setCategory(new Category(t.getCategory(), userRepo));
		this.setDeadline(deadline);
		
		SimpleDateFormat formatDate=new SimpleDateFormat("dd/MM/yyyy");
		formatDate.setLenient(false);
		
		//TODO exception gérer
		Date horaire=formatDate.parse(t.getDeadline());
		if(new Date().after(horaire)) throw new InvalidOperationException("Deadline must be after today");
		this.setDeadline(horaire);
		this.setId(t.getId());
		this.setLabel(t.getLabel());
		this.setPriority(t.getPriority());
		this.setUsers(new User(t.getUsers(), userRepo));
		this.setState(t.getState());
	}
	public Task() {
		
	}
	
	
	
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
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

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	public User getUsers() {
		return users;
	}
	public void setUsers(User users) {
		this.users = users;
	}	

}


