package com.codebuffer.registration.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codebuffer.registration.entity.User;
import com.codebuffer.registration.service.RegistrationService;

@RestController
@RequestMapping("/registration")
public class RegistrationController {
	
	 private static final Logger log = LoggerFactory.getLogger(RegistrationController.class);
	 
	 @Autowired
	 RegistrationService registrationService;
	 
	 @PostMapping("/register")
	 public User registerUser(@RequestBody @Valid User user) {
		log.info("Inside registerUser of Register Controller");
		return registrationService.saveUser(user);
	 }

}
