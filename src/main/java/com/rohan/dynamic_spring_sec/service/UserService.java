package com.rohan.dynamic_spring_sec.service;

import java.util.List;

import com.rohan.dynamic_spring_sec.dto.UserDto;
import com.rohan.dynamic_spring_sec.entity.User;

public interface UserService {

	User save(UserDto user);

	List<User> findAll();

	User findOne(String username);

	/*
	 * User findById(int id);
	 * 
	 * UserDto update(UserDto userDto);
	 */
}
