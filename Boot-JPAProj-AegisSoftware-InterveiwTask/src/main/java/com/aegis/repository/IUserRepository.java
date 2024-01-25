package com.aegis.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

import com.aegis.document.User;

public interface IUserRepository extends MongoRepository<User, Integer>, CrudRepository<User, Integer>{
	public User findByEmailId(String email);

}
