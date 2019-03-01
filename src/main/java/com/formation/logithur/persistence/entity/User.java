package com.formation.logithur.persistence.entity;

import java.util.List;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.formation.logithur.dto.UserDto;
import com.formation.logithur.persistence.repository.UserRepository;

/**
 * Entité Utilisateur <b><b>Class Entité Utilisateur - 
 * Définition de la table et de ses attributs
 * 
 * @author Arzh
 * @version 1.0.0
 */
@Entity
@Table(name="user")
public class User {
	
	// Attribute's Declaration
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "id", unique = true, nullable = false)
	private Long id;
	
	@Column (name = "email", length = 60, unique = true, nullable = false)
	private String email;
	
	@Column (name = "nickname", length = 20, unique = true, nullable = false)
	private String nickname;
	
	@Column (name = "password", length = 20, nullable = false)
	private String password;
	
	@Column (name = "mark")
	private Double mark;
	@OneToMany
	@JoinColumn(name = "idTask", referencedColumnName = "id")
	private List<Task> task;

	// Constructor

	/**
	 * Constructeur User <b><b>Constructeur par défaut
	 * 
	 * @author Arzh
	 */
	public User() {
	}

	/**
	 * Constructeur User <b><b>Constructeur avec un Dto et un Repository d'utilisateur
	 * en paramètre
	 * 
	 * @param user     - Dto Utilisateur
	 * @param userRepo - Repository Utilisateur
	 * @author Arzh
	 */
	public User(UserDto user, UserRepository userRepo) {
		Optional<User> userTmp = userRepo.findById(user.getId());

		this.setEmail(user.getEmail());
		this.setNickname(user.getNickname());
		this.setMark(user.getMark());
		this.setPassword(userTmp.get().getPassword());
	}

	/**
	 * Constructeur User <b><b>Constructeur avec un Dto d'utilisateur en paramètre
	 * 
	 * @param user - Dto Utilisateur
	 * @author Arzh
	 */
	public User(UserDto user) {

		this.setEmail(user.getEmail());
		this.setNickname(user.getNickname());
		this.setMark(user.getMark());
		this.setPassword(user.getPassword());
	}

	// Getters And Setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Double getMark() {
		return mark;
	}

	public void setMark(Double mark) {
		this.mark = mark;
	}

	public List<Task> getTask() {
		return task;
	}

	public void setTask(List<Task> task) {
		this.task = task;
	}

	
}
