package com.demo.tenant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.tenant.dao.TenantsRepo;
import com.demo.tenant.dto.UserCred;
import com.demo.tenant.modal.Tenants;

@Service
@Transactional
public class UserServiceImpl implements UserServiveI {
	@Autowired
	private TenantsRepo tenantRepo;

	@Override
	public Tenants findByUserPass(UserCred userCred) {
		// TODO Auto-generated method stub
		return tenantRepo.findByUser(userCred.getName(), userCred.getPassword());
	}
	
	
}
