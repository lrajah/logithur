package com.formation.logithur.service.impl;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.logithur.dto.TaskDto;
import com.formation.logithur.exception.NotFoundException;
import com.formation.logithur.persistence.entity.Task;
import com.formation.logithur.persistence.entity.User;
import com.formation.logithur.persistence.repository.CategoryRepository;
import com.formation.logithur.persistence.repository.TaskRepository;
import com.formation.logithur.persistence.repository.UserRepository;
import com.formation.logithur.service.ITaskService;
@Service
@Transactional
public class TaskService implements ITaskService {
	
	@Autowired
	private TaskRepository taskRepo;
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private CategoryRepository categoryRepo;

	@Override
	public List<Task> findByUser(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TaskDto findById(Long id) {
		Optional<Task> task= taskRepo.findById(id);
		if(!task.isPresent()) throw new NotFoundException("La tache demandée n'existe pas");
		return new TaskDto(task.get());
	}

	@Override
	public TaskDto createTask(TaskDto taskDto) throws ParseException {
		
		return new TaskDto(taskRepo.save(new Task(taskDto, userRepo))) ;
	}

	@Override
	public TaskDto modifyTask(TaskDto taskDto, Long oldTaskId) throws ParseException {
		
		
		Optional<Task> task= taskRepo.findById(oldTaskId);
		// TODO check if task exist in db
		if(!task.isPresent()) throw new NotFoundException("La tache demandée n'existe pas");
		return new TaskDto(taskRepo.save(new Task(taskDto, userRepo))) ;
		
		
	}

	

}
