package com.formation.logithur.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.formation.logithur.dto.UserDto;
import com.formation.logithur.service.IUserService;

@CrossOrigin
@RestController
@RequestMapping(value="/api/client/")
public class UserController {
	@Autowired
	IUserService userServ;
	
	@PostMapping
	@ResponseBody
	UserDto createUser(@RequestBody UserDto userDto) {
		return userServ.userNew(userDto);
	}
}
