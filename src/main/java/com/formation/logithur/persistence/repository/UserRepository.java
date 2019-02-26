package com.formation.logithur.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.formation.logithur.persistence.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
