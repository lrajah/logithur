package com.formation.logithur.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.formation.logithur.persistence.entity.User;

/**
 * Repository Utilisateur <b>Interface Repository Utilisateur<b>
 * 
 * @author Arzh
 * @version 1.0.0
 */
public interface UserRepository extends JpaRepository<User, Long> {
	
	@Query(value="SELECT * FROM user WHERE id=?1", nativeQuery = true)
	Optional<User> findById(Long id);
	
	@Query(value="SELECT * FROM user WHERE email=?1", nativeQuery = true)
	Optional<User> findByEmail(String email);
	
	@Query(value="SELECT * FROM user WHERE nickname=?1", nativeQuery = true)
	Optional<User> findByNickname(String nickname);	
	
	@Query(value="SELECT * FROM user WHERE nickname=?1 AND password=?2", nativeQuery = true)
	Optional<User> findByNickname(String nickname, String password);
}
