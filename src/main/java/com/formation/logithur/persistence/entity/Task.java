/**
 * 
 */
package com.formation.logithur.persistence.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
	
	@ManyToOne
	@JoinColumn(name = "idCategory", referencedColumnName = "id")
	private Category category;
	@ManyToMany
	@JoinColumn(name = "idUser", referencedColumnName = "id")
	private User user;
	
	
	

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
	
	

}


