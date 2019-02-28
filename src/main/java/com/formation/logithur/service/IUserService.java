package com.formation.logithur.service;

import com.formation.logithur.dto.UserDto;
import com.formation.logithur.persistence.repository.UserRepository;

public interface IUserService {
	
	UserDto userNew(UserDto user);	
	
	UserDto userModify(UserDto userDto, UserRepository userRepo);	

}
