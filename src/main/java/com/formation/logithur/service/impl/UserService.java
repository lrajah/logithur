package com.formation.logithur.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.logithur.dto.UserDto;
import com.formation.logithur.exception.InvalidOperationException;
import com.formation.logithur.exception.NotFoundException;
import com.formation.logithur.persistence.entity.User;
import com.formation.logithur.persistence.repository.UserRepository;
import com.formation.logithur.service.IUserService;

/**
 * Service Utilisateur <b><b>Class Service Utilisateur - Définition des
 * différentes méthodes pour l'utilisateur
 * 
 * @author Arzh
 * @version 1.0.0
 */
@Service
public class UserService implements IUserService {

	@Autowired
	UserRepository userRepo;

	@Override
	public UserDto userNew(UserDto userDto) {

		User userNew = new User(userDto);
		Optional<User> userExistEmail = userRepo.findByEmail(userNew.getEmail());
		Optional<User> userExistNickname = userRepo.findByNickname(userNew.getNickname());

		if (userExistEmail.isPresent()) {

			throw new InvalidOperationException("Email already used !");

		} else if (userExistNickname.isPresent()) {

			throw new InvalidOperationException("Nickname already used !");
		}

		return new UserDto(userRepo.save(userNew));
	};

	@Override
	public UserDto userModify(UserDto userDto) {
		
		User userModify = new User(userDto, userRepo);
		Optional<User> userExist = userRepo.findById(userModify.getId());
		
		if (!(userExist.isPresent())) {
			
			throw new NotFoundException("This user does not exist !");	
					
		} else if (userDto.getEmail() != userExist.get().getEmail()) {
			
			if (userRepo.findByEmail(userExist.get().getEmail()).isPresent()) {
				
				throw new InvalidOperationException("Email already used !");
			}
										
		} else if (userDto.getNickname() != userExist.get().getNickname()) {
			
			throw new InvalidOperationException("The Nickname doesn't to be change !");
		
		} 
		
		return new UserDto(userRepo.save(userModify));	
					
	}
	
	@Override
	public User findByNickname(String nickname, String password) {
		
		Optional<User> user = userRepo.findByNickname(nickname, password);
		
		if (user.isPresent()) {
			
			return user.get();
			
		} else {
			
			throw new NotFoundException("L'Utilisateur n'a pas été trouvé");
		}
		
	}
	
}
