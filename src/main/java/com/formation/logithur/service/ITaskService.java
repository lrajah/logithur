package com.formation.logithur.service;

import java.text.ParseException;
import java.util.List;

import com.formation.logithur.dto.TaskDto;

public interface ITaskService {
	
	List<TaskDto> findByUser(String userName);
	TaskDto findById(Long id);
	TaskDto createTask(TaskDto taskDto, String userName) throws ParseException;
	TaskDto modifyTask(TaskDto taskDto) throws ParseException;
	void deleteTask(TaskDto taskDto) throws ParseException;
	
}
