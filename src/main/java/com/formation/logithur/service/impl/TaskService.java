package com.formation.logithur.service.impl;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.logithur.dto.TaskDto;
import com.formation.logithur.exception.NotFoundException;
import com.formation.logithur.persistence.entity.Category;
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
	public List<TaskDto> findByUser(String userName) {
		// TODO 
		Optional<User> user=userRepo.findByNickname(userName);
		if(!user.isPresent()) throw new NotFoundException("L'utilisateur demandé n'existe pas");		
		return user.get().getTask().stream().map(c -> new TaskDto(c)).collect(Collectors.toList());
	}

	@Override
	public TaskDto findById(Long id) {
		Optional<Task> task= taskRepo.findById(id);
		if(!task.isPresent()) throw new NotFoundException("La tache demandée n'existe pas");
		return new TaskDto(task.get());
	}

	
	
	@Override
	public TaskDto createTask(TaskDto taskDto, String userName) throws ParseException {
		
		Optional<User> user = userRepo.findByNickname(userName);
		Optional<Category> cat=categoryRepo.findByCategory(taskDto.getCategory().getCategory());
		if(!cat.isPresent()) taskDto.setCategory(categoryRepo.save(taskDto.getCategory()));
		Task task =new Task(taskDto, userRepo) ;
		task=taskRepo.save(task);
		user.get().getTask().add(task);
		userRepo.save(user.get());
		
		return new TaskDto(task) ;
		
	}

	@Override
	public TaskDto modifyTask(TaskDto taskDto, Long oldTaskId) throws ParseException {
		
		
		Optional<Task> task= taskRepo.findById(oldTaskId);
		
		// TODO check if task exist in db
		if(!task.isPresent()) throw new NotFoundException("La tache demandée n'existe pas");
		
		return new TaskDto(taskRepo.save(new Task(taskDto, userRepo))) ;
		
		
	}

	

}
