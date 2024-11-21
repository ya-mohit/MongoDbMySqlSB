package com.mohit.MongoDbMySqlSB.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mohit.MongoDbMySqlSB.entity.UserDoc;

@Repository
public interface UserRepositoryMongoDB extends MongoRepository<UserDoc, String>{

}
