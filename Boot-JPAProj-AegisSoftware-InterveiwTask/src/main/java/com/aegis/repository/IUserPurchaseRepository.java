package com.aegis.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

import com.aegis.entity.UserPurchase;

public interface IUserPurchaseRepository extends MongoRepository<UserPurchase, Integer>, CrudRepository<UserPurchase, Integer> {

}
