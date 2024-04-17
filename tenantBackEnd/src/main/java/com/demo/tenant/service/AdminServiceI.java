package com.demo.tenant.service;

import java.util.List;

import com.demo.tenant.dto.UserCred;
import com.demo.tenant.modal.Tenants;

public interface AdminServiceI {
	//This is the function to find all the users in the database
	List<Tenants> findAll();
	
	Tenants findbyUserPass(UserCred userCred);
}
