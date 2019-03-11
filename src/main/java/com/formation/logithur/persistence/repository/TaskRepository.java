package com.formation.logithur.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.formation.logithur.persistence.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
	@Query(value="SELECT * FROM user WHERE nickname=?1", nativeQuery = true)
	Optional<List<Task>> findByUser(String userName);
	
	@Query(value="SELECT * FROM task WHERE idCategory=?1", nativeQuery = true)
	Optional<List<Task>> findByCategoryId(Long id);
	
	@Query(value="SELECT * FROM task WHERE label=?1 AND deadline=?2 AND idUser=?3", nativeQuery = true)
	Optional<Task> findByLabelAndDate(String label, String deadline, Long idUser);	
}
