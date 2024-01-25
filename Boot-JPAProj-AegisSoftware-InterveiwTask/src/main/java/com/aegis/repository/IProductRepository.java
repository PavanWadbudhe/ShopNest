package com.aegis.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

import com.aegis.document.Product;

public interface IProductRepository extends MongoRepository<Product, Integer>, CrudRepository<Product, Integer> {

}
