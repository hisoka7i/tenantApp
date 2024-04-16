package com.demo.tenant.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.demo.tenant.modal.Tenants;

public interface TenantsRepo extends MongoRepository<Tenants, String>{

}
