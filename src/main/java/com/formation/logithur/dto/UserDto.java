package com.formation.logithur.dto;

import com.formation.logithur.persistence.entity.User;

/**
 * DTO Utilisateur <b>Class DTO Utilisateur<b>
 * 
 * @author Arzh
 * @version 1.0.0
 */
public class UserDto {

	// Attribute's Declaration

	/**
	 * ID <b>ID de l'utilisateur<b>
	 * 
	 * @author Arzh
	 */
	private Long id;

	/**
	 * Email <b>Email de l'utilisateur<b>
	 * 
	 * @author Arzh
	 */
	private String email;

	/**
	 * Pseudo <b>Pseudo de l'utilisateur<b>
	 * 
	 * @author Arzh
	 */
	private String nickname;

	/**
	 * Mot de passe <b>Mot de passe de l'utilisateur<b>
	 * 
	 * @author Arzh
	 */
	private String password;

	/**
	 * Indice de performance <b>Indice de performance de l'utilisateur<b>
	 * 
	 * @author Arzh
	 */
	private Double mark;

	// Constructor

	/**
	 * Constructeur DTO User <b>Constructeur par défaut<b>
	 * 
	 * @author Arzh
	 */
	public UserDto() { }

	/**
	 * Constructeur DTO User <b>Constructeur avec un utilisateur en paramètre<b>
	 * 
	 * @param user - Objet Utilisateur
	 * @author Arzh
	 */
	public UserDto(User user) {
		this.setEmail(user.getEmail());
		this.setNickname(user.getNickname());
		this.setMark(user.getMark());
		this.setPassword(null);
	}

	// Getters and Setters

	// ID
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	// Email
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	// Nickname
	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	// Password
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	// Mark
	public Double getMark() {
		return mark;
	}

	public void setMark(Double mark) {
		this.mark = mark;
	}
}
