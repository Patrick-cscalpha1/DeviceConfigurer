package com.cscalpha.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cscalpha.manager.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByUsername(String username);
}
