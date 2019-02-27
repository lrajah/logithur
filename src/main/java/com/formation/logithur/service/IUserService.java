package com.formation.logithur.service;

import com.formation.logithur.dto.UserDto;

public interface IUserService {
	
	UserDto userNew(UserDto user);	
	
	UserDto userModify();	

}
