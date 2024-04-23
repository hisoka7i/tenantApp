package com.demo.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.tenant.dao.AdminRepo;
import com.demo.tenant.dao.TenantsRepo;
import com.demo.tenant.dto.TenantData;
import com.demo.tenant.dto.UserCred;
import com.demo.tenant.modal.Admins;
import com.demo.tenant.modal.Tenants;

@Service
@Transactional
public class AdminServiceImpl implements AdminServiceI {
	@Autowired
	private TenantsRepo tenantRepo;
	@Autowired
	private AdminRepo adminRepo;

	@Override
	public List<Tenants> findAll() {
		// TODO Auto-generated method stub
		return tenantRepo.findAll();
	}

	@Override
	public Admins findbyUserPass(UserCred userCred) {
//		System.out.println(userCred.getName());
		// TODO Auto-generated method stub
		return adminRepo.findByAdmin(userCred.getName(),userCred.getPassword());
//		return tenantRepo.findByNamePassword(userCred.getUname(), userCred.getPassword());
	}

	@Override
	public boolean deleteUser(String name) {
		// TODO Auto-generated method stub
		Tenants tenant = tenantRepo.findByName(name);
		if(tenant!=null) {
			tenantRepo.delete(tenantRepo.findByName(name));
			return true;
		}
		return false;
	}

	@Override
	public boolean updateUser(TenantData tenantData) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addUser(TenantData tenantData) {
		// TODO Auto-generated method stub
		return false;
	}

}
