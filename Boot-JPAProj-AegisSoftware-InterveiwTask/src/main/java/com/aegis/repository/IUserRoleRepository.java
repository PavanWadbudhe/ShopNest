package com.aegis.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

import com.aegis.document.UserRole;

public interface IUserRoleRepository extends MongoRepository<UserRole, Integer>, CrudRepository<UserRole, Integer> {

}
