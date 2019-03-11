package com.formation.logithur.service.impl;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.logithur.dto.TaskDto;
import com.formation.logithur.exception.InvalidOperationException;
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
		Optional<User> user = userRepo.findByNickname(userName);
		if (!user.isPresent())
			throw new NotFoundException("This User does not exist !");
		return user.get().getTask().stream().map(c -> new TaskDto(c)).collect(Collectors.toList());
	}

	@Override
	public TaskDto findById(Long id) {
		Optional<Task> task = taskRepo.findById(id);
		if (!task.isPresent())
			throw new NotFoundException("La tache demandée n'existe pas");
		return new TaskDto(task.get());
	}
	
	@Override
	public TaskDto checkIfTaskAlreadyExist(TaskDto taskDto) {
		Optional<Task> taskAlreadyExist = taskRepo.findByLabelAndDate(taskDto.getLabel(), taskDto.getDeadline(), taskDto.getUsers().getId());
		if (taskAlreadyExist.isPresent()) {
			throw new InvalidOperationException("This Task already exist for this date");			
		} else {
			return taskDto;
		}
	}

	@Override
	public TaskDto createTask(TaskDto taskDto, String userName) throws ParseException {

		Optional<User> user = userRepo.findByNickname(userName);

		if ((taskDto.getLabel()) == null || (taskDto.getPriority()) == null || (taskDto.getDeadline()) == null) {

			throw new InvalidOperationException("One or several fields are empty !");
		}
		
			taskDto = checkIfTaskAlreadyExist(taskDto);
			taskDto = checkCategoryIfPresent(taskDto);

			Task task = new Task(taskDto, userRepo);
			user.get().getTask().add(task);
			task.setUsers(user.get());
			task = taskRepo.save(task);
			user.get().getTask().add(task);
			userRepo.save(user.get());

			return new TaskDto(task);
	}

	@Override
	public TaskDto modifyTask(TaskDto taskDto) throws ParseException {

		Optional<Task> task = taskRepo.findById(taskDto.getId());

		if ((taskDto.getLabel()) == null || (taskDto.getPriority()) == null || (taskDto.getDeadline()) == null) {

			throw new InvalidOperationException("One or several fields are empty !");
		}

		taskDto = checkIfTaskAlreadyExist(taskDto);
		taskDto = checkCategoryIfPresent(taskDto);
		TaskDto taskDtoTmp = new TaskDto(task.get());
		// TODO check if task exist in db
		if (!task.isPresent())
			throw new NotFoundException("La tache demandée n'existe pas");

		TaskDto tmp = new TaskDto(taskRepo.save(new Task(taskDto, userRepo)));
		checkIfCategoryEmpty(taskDtoTmp);
		return tmp;
	}

	private TaskDto checkCategoryIfPresent(TaskDto taskDto) {
		if (taskDto.getCategory() != null) {
			Optional<Category> cat = categoryRepo.findByCategory(taskDto.getCategory().getCategory());
			if (!cat.isPresent()) {
				taskDto.setCategory(categoryRepo.save(taskDto.getCategory()));
				return taskDto;
			} else {
				taskDto.setCategory(cat.get());
				return taskDto;
			}
		}
		return taskDto;
	}

	@Override
	public void deleteTask(TaskDto taskDto) throws ParseException {
		// TODO Auto-generated method stub
		taskRepo.deleteById(taskDto.getId());
		checkIfCategoryEmpty(taskDto);
	}

	private void checkIfCategoryEmpty(TaskDto taskDto) {
		Optional<List<Task>> tasks = taskRepo.findByCategoryId(taskDto.getCategory().getId());

		if (!tasks.isPresent()) {
			categoryRepo.deleteById(taskDto.getCategory().getId());
		}
	}

}
