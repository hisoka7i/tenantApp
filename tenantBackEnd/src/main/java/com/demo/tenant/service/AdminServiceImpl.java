package com.demo.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.tenant.dao.TenantsRepo;
import com.demo.tenant.dto.UserCred;
import com.demo.tenant.modal.Tenants;

@Service
@Transactional
public class AdminServiceImpl implements AdminServiceI {
	@Autowired
	private TenantsRepo tenantRepo;

	@Override
	public List<Tenants> findAll() {
		// TODO Auto-generated method stub
		return tenantRepo.findAll();
	}

	@Override
	public Tenants findbyUserPass(UserCred userCred) {
//		System.out.println(userCred.getName());
		// TODO Auto-generated method stub
		return tenantRepo.findByUser(userCred.getName(),userCred.getPassword());
//		return tenantRepo.findByNamePassword(userCred.getUname(), userCred.getPassword());
	}

}
