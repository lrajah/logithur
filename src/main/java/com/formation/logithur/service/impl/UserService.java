package com.formation.logithur.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.logithur.dto.UserDto;
import com.formation.logithur.persistence.entity.User;
import com.formation.logithur.persistence.repository.UserRepository;
import com.formation.logithur.service.IUserService;

@Service
public class UserService implements IUserService {
	
	@Autowired 
	UserRepository userRepo;
	
	// Method for create user
	
	@Override
	public UserDto userNew(UserDto userDto) {
				
		User userNew= new User(userDto);
		Optional<User> userNoExistEmail = userRepo.findByEmail(userNew.getEmail()); 
		Optional<User> userNoExistNickname = userRepo.findByNickname(userNew.getNickname());
		
		if (userNoExistEmail.isPresent() ) {
			
			// TODO Exception email
			
		} else if(userNoExistNickname.isPresent()) {
			
			//TODO Exception surnom
		}
		
		return new UserDto(userRepo.save(userNew));
				
	};	
	
	// Method for modify user
	
	@Override
	public UserDto userModify(UserDto userDto, UserRepository userRepo) {
		
		User userChange= new User(userDto, userRepo);
		Optional<User> userExist = userRepo.findById(userChange.getId());
		
		if (userExist.isPresent()) {
			
			return new UserDto(userRepo.save(userChange));			
			
		} else {	
			
			// TODO Gérer les exceptions
			System.out.println("L'utilisateur n'existe pas");
			return userDto;
			
		}
		
		
	};

}
	
	