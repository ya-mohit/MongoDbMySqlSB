package com.mohit.MongoDbMySqlSB.service;

import java.util.List;


public interface UserService {
	
	<T> List<T> findAllUsers(String db);

}
