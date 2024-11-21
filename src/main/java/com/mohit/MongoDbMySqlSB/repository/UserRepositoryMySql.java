package com.mohit.MongoDbMySqlSB.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mohit.MongoDbMySqlSB.entity.UserEntity;

@Repository
public interface UserRepositoryMySql extends JpaRepository<UserEntity, String>{

}
