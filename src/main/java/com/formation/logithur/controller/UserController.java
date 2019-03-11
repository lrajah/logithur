package com.formation.logithur.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.formation.logithur.dto.UserDto;
import com.formation.logithur.exception.NotIdentifiedException;
import com.formation.logithur.persistence.entity.User;
import com.formation.logithur.secure.utils.AuthChecker;
import com.formation.logithur.exception.InvalidOperationException;
import com.formation.logithur.exception.NotIdentifiedException;
import com.formation.logithur.secure.utils.AuthChecker;
import com.formation.logithur.service.IUserService;

/**
 * Controller Utilisateur - 
 * <b><b>Déclaration des requètes HTTP à destination du service utilisateur
 * 
 * @author Arzh
 * @version 1.0.0
 */
@CrossOrigin
@RestController
@RequestMapping(value="/api/client")
public class UserController {
		
		@Autowired
		IUserService userServ;
		@Autowired
		private AuthChecker authChecker;
		
		@PostMapping(value="/new")
		@ResponseBody
		public UserDto userNew(@RequestBody UserDto userNewDto) {
			return userServ.userNew(userNewDto);
		}
		
		@PutMapping(value="/modify")
		@ResponseBody
		public UserDto userModify(@RequestBody UserDto userModifyDto) throws ParseException {
			if (authChecker.isUser() == null)
				throw new NotIdentifiedException();
			else if(authChecker.isUser().getId().compareTo(userModifyDto.getId())!=0) {
				throw new InvalidOperationException("This user requested is not the user logged");
			}
			
			return userServ.userModify(userModifyDto);
		}
		
		@GetMapping
		@ResponseBody
		public UserDto getThisUser() {
			User user= authChecker.isUser();
			if (user == null) {
				throw new NotIdentifiedException();
			}
			return new UserDto(user);
		}
		
}
