package com.rohan.dynamic_spring_sec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rohan.dynamic_spring_sec.dto.UserDto;
import com.rohan.dynamic_spring_sec.entity.User;
import com.rohan.dynamic_spring_sec.security.JwtTokenUtil;
import com.rohan.dynamic_spring_sec.service.UserService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/token")
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/generate-token", method = RequestMethod.POST)
	public ResponseEntity<String> generateToken(@RequestBody User loginUser) throws AuthenticationException {

		final Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginUser.getUsername(), loginUser.getPassword()));
		User user = new User();
		user.setUsername(authentication.getName());
		final String token = jwtTokenUtil.generateToken(user);
		return new ResponseEntity<String>(token, HttpStatus.OK);
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public ResponseEntity<UserDto> signUp(@RequestBody User signUpUser) throws AuthenticationException {
		UserDto user = new UserDto();
		user.setUsername(signUpUser.getUsername());
		user.setPassword(signUpUser.getPassword());
		userService.save(user);

		return new ResponseEntity<UserDto>(user,HttpStatus.OK);
	}

}
