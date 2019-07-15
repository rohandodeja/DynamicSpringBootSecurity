package com.rohan.dynamic_spring_sec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rohan.dynamic_spring_sec.entity.User;

@Repository
public interface UserDao extends JpaRepository<User, String> {

	User findByUsername(String username);
}
