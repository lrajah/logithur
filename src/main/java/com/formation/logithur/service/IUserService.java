package com.formation.logithur.service;

import com.formation.logithur.dto.UserDto;
import com.formation.logithur.persistence.repository.UserRepository;

/**
 * Interface Service - <b><b>Déclaration des méthodes à implémenter obligatoirement
 * au service utilisateur
 * 
 * @author Arzh
 * @version 1.0.0
 */
public interface IUserService {
	
	/**
	 * Method to create a new User
	 * 
	 * @param userDto - Dto Utilisateur
	 * @return UserDto - Dto Utilisateur
	 */
	UserDto userNew(UserDto userDto);	
	
	/**
	 * Method to modify a current user
	 * 
	 * @param userDto - Dto Utilisateur
	 * @param userRepo - Repository Utilisateur
	 * @return UserDto - Dto Utilisateur
	 */
	UserDto userModify(UserDto userDto, UserRepository userRepo);	

}
