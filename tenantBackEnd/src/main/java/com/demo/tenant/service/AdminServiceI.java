package com.demo.tenant.service;

import java.util.List;

import org.bson.Document;

import com.demo.tenant.dto.TenantData;
import com.demo.tenant.dto.UserCred;
import com.demo.tenant.modal.Admins;
import com.demo.tenant.modal.Tenants;

public interface AdminServiceI {
	//This is the function to find all the users in the database
	List<Tenants> findAll();
	
	Admins findbyUserPass(UserCred userCred);
	
	boolean deleteUser(String name);
	
	boolean updateUserRent(TenantData tenantData);
	
	boolean addUser(Tenants tenantData);
	
	Document getFullData(String name);
}
