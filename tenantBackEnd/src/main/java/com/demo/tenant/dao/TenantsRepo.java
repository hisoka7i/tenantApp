package com.demo.tenant.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.demo.tenant.modal.Tenants;

public interface TenantsRepo extends MongoRepository<Tenants, String>{
	//new function added to find user
//	Tenants findByNamePassword(String name,String password);
	@Query("{'name': ?0}")
	Tenants findByUser(String name,String password);
}
