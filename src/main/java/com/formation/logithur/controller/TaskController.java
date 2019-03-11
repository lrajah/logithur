package com.formation.logithur.controller;

import java.text.ParseException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.formation.logithur.dto.TaskDto;
import com.formation.logithur.exception.InvalidOperationException;
import com.formation.logithur.exception.NotIdentifiedException;
import com.formation.logithur.persistence.entity.User;
import com.formation.logithur.secure.utils.AuthChecker;
import com.formation.logithur.service.ITaskService;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/client/task")
public class TaskController {

	@Autowired
	ITaskService taskServ;
	@Autowired
	private AuthChecker authChecker;

	@GetMapping
	@ResponseBody
	List<TaskDto> findByUser() {
		User user=(User) authChecker.isUser();
		if (authChecker.isUser() == null)
			throw new NotIdentifiedException();
		else if(authChecker.isUser().getNickname().compareTo(user.getNickname())!=0) {
			throw new InvalidOperationException("L'utilisateur demandé n'est pas l'utilisateur connecté");
		}

		return taskServ.findByUser(user.getNickname());

	}

	@PostMapping(value = "/add")
	@ResponseBody
	TaskDto createTask(@RequestBody TaskDto taskDto) throws ParseException {
		if (authChecker.isUser() == null)
			throw new NotIdentifiedException();
		else if(authChecker.isUser().getNickname().compareTo(taskDto.getUsers().getNickname())!=0) {
			throw new InvalidOperationException("L'utilisateur demandé n'est pas l'utilisateur connecté");
		}

		return taskServ.createTask(taskDto, taskDto.getUsers().getNickname());

	}

	@PutMapping(value = "/modify")
	@ResponseBody
	TaskDto modifyTask(@RequestBody TaskDto taskDto) throws ParseException {
		if (authChecker.isUser() == null)
			throw new NotIdentifiedException();
		else if(authChecker.isUser().getNickname().compareTo(taskDto.getUsers().getNickname())!=0) {
			throw new InvalidOperationException("L'utilisateur demandé n'est pas l'utilisateur connecté");
		}
		return taskServ.modifyTask(taskDto);

	}

	@PostMapping(value = "/delete")
	@ResponseBody

	void deleteTask(@RequestBody TaskDto taskDto) throws ParseException {
		if (authChecker.isUser() == null)
			throw new NotIdentifiedException();
		else if(authChecker.isUser().getNickname().compareTo(taskDto.getUsers().getNickname())!=0) {
			throw new InvalidOperationException("L'utilisateur demandé n'est pas l'utilisateur connecté");
		}
		taskServ.deleteTask(taskDto);

	}
}
