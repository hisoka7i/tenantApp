package com.demo.tenant.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.demo.tenant.modal.Admins;

@Component
@Repository
public interface AdminRepo extends MongoRepository<Admins, String>{
	@Query("{'name': ?0, 'password': ?1}")
	Admins findByAdmin(String name,String password);
}
