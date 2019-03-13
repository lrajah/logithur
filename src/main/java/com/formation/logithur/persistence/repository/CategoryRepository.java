package com.formation.logithur.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.formation.logithur.persistence.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

	@Query(value = "SELECT * FROM Category WHERE category=?1", nativeQuery = true)
	Optional<Category> findByCategory(String category);
	@Query(value = "SELECT * FROM Category WHERE user=?1", nativeQuery = true)
	Optional<List<Category>> findByUser(String user);

}
