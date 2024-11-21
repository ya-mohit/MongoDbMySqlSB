package com.mohit.MongoDbMySqlSB.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mohit.MongoDbMySqlSB.service.UserService;

@RestController
@RequestMapping("/users")
public class UsersController {

	@Autowired
	UserService userService;
	
	@RequestMapping("/")
	<T> List<T> getAllUsers(@RequestBody Map<String, String> payLoad) {
		
		System.out.println("db : "+payLoad.get("db"));
		
		return userService.findAllUsers(payLoad.get("db"));
	}
}
