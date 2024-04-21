package com.demo.tenant.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.demo.tenant.modal.Admins;

public interface AdminRepo extends MongoRepository<Admins, String>{
	@Query("{'name': ?0, 'password': ?1}")
	Admins findBy(String name,String password);
}
