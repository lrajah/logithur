package com.formation.logithur.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.formation.logithur.dto.TaskDto;
import com.formation.logithur.service.ITaskService;

@CrossOrigin
@RestController
@RequestMapping(value="/api/client/task")
public class TaskController {
	
	@Autowired
	ITaskService taskServ;
	
	@GetMapping(value="/{userName}")
	@ResponseBody
	List<TaskDto> findByUser(@PathVariable String userName){
		
		return taskServ.findByUser(userName);
		
	}
	
	@PostMapping(value="/add")
	@ResponseBody
	TaskDto createTask(@RequestBody TaskDto taskDto) throws ParseException{
		
		return taskServ.createTask(taskDto, taskDto.getUsers().get(0).getNickname() );
		
	}
}
