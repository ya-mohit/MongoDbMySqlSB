package com.mohit.MongoDbMySqlSB.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mohit.MongoDbMySqlSB.repository.UserRepositoryMongoDB;
import com.mohit.MongoDbMySqlSB.repository.UserRepositoryMySql;
import com.mohit.MongoDbMySqlSB.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	
	@Autowired
	UserRepositoryMySql repositoryMySql;
	
	@Autowired
	UserRepositoryMongoDB repositoryMongoDB;
	
	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> findAllUsers(String db) {
		
		if(db.equalsIgnoreCase("sql"))
			return (List<T>) repositoryMySql.findAll();
		else if(db.equalsIgnoreCase("mongo"))
			return (List<T>) repositoryMongoDB.findAll();
		return (List<T>) Arrays.asList(":(");
		
	}

}
