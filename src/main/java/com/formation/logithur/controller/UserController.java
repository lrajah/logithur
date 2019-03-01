package com.formation.logithur.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.formation.logithur.dto.UserDto;
import com.formation.logithur.persistence.repository.UserRepository;
import com.formation.logithur.service.IUserService;

/**
 * Controller Utilisateur - 
 * <b><b>Déclaration des requètes HTTP à destination du service utilisateur
 * 
 * @author Arzh
 * @version 1.0.0
 */
@RestController
@RequestMapping(value="/api/client/user")
public class UserController {
		
		@Autowired
		IUserService userServ;
		
		@PostMapping(value="/new")
		@ResponseBody
		public UserDto userNew(@RequestBody UserDto userNewDto) {
			return userServ.userNew(userNewDto);
		}
		
		@PutMapping(value="/modify")
		@ResponseBody
		public UserDto userModify(@RequestBody UserDto userModifyDto, @RequestBody UserRepository userModifyRepo) {
			return userServ.userModify(userModifyDto, userModifyRepo);
		}
		
	}

