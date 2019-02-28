package com.formation.logithur.service;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import com.formation.logithur.dto.TaskDto;
import com.formation.logithur.persistence.entity.Task;

public interface ITaskService {
	
	List<TaskDto> findByUser(String userName);
	TaskDto findById(Long id);
	TaskDto createTask(TaskDto taskDto) throws ParseException;
	TaskDto modifyTask(TaskDto taskDto, Long oldTaskId) throws ParseException;
}
