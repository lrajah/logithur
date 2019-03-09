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
import com.formation.logithur.tools.DataVerification;

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

		if (!(DataVerification.checkEmail(userNew.getEmail()))) {

			throw new InvalidOperationException("This Email is invalid");

		} else if (!(DataVerification.checkPassword(userNew.getPassword()))) {

			throw new InvalidOperationException("This Password is invalid");

		} else if (!(DataVerification.checkNickname(userNew.getNickname()))) {

			throw new InvalidOperationException("This Nickname is invalid");

		} else if (userExistEmail.isPresent()) {

			throw new InvalidOperationException("Email already used !");

		} else if (userExistNickname.isPresent()) {

			throw new InvalidOperationException("Nickname already used !");
		
		} else { 

		return new UserDto(userRepo.save(userNew));
		}
	};

	@Override
	public UserDto userModify(UserDto userDto) {

		User userModify = new User(userDto, userRepo);
		Optional<User> userExist = userRepo.findById(userModify.getId());

		if (!(userExist.isPresent())) {

			throw new NotFoundException("This User does not exist !");

		} else if (!(DataVerification.checkEmail(userModify.getEmail()))) {

			throw new InvalidOperationException("This Email is invalid");

		} else if (!(DataVerification.checkPassword(userModify.getPassword()))) {

			throw new InvalidOperationException("This Password is invalid");

		} else if (!(DataVerification.checkNickname(userModify.getNickname()))) {

			throw new InvalidOperationException("This Nickname is invalid");

		} else if (userDto.getEmail().compareTo(userExist.get().getEmail()) != 0) {

			if (userRepo.findByEmail(userModify.getEmail()).isPresent()) {

				throw new InvalidOperationException("Email already used !");
			}

		} else if (userDto.getNickname().compareTo(userExist.get().getNickname()) != 0) {

			throw new InvalidOperationException("The Nickname doesn't to be change !");

		} else if (userDto.getPassword().compareTo(userModify.getPassword()) != 0) {

			userModify.setPassword(userDto.getPassword());
		}

		return new UserDto(userRepo.save(userModify));
	}

	@Override
	public User findByNickname(String nickname, String password) {

		Optional<User> user = userRepo.findByNickname(nickname, password);

		if (!(user.isPresent())) {

			throw new NotFoundException("This User was not found");

		} else {

			return user.get();
		}
	}
}
