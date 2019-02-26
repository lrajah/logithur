package com.formation.logithur.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.formation.logithur.persistence.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
