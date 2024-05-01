package com.demo.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.tenant.dao.AdminRepo;
import com.demo.tenant.dao.TenantsRepo;
import com.demo.tenant.dto.TenantData;
import com.demo.tenant.dto.UserCred;
import com.demo.tenant.modal.Admins;
import com.demo.tenant.modal.Tenants;

@Component
@Service("AdminServiceI")
public class AdminServiceImpl implements AdminServiceI {
	@Autowired(required = true)
	private TenantsRepo tenantRepo;
	@Autowired(required = true)
	private AdminRepo adminRepo;
	@Autowired(required = true)
	private MongoTemplate mongoTemplate;

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
	public boolean updateUserRent(TenantData tenantData) {
		// TODO Auto-generated method stub
		Tenants tenant = tenantRepo.findByName(tenantData.getName());
		if(tenant==null)
			return false;
		tenant.setRent(tenantData.getRent());
		tenantRepo.save(tenant);
		return true;
	}

	@Override
	public boolean addUser(Tenants tenantData) {
		// TODO Auto-generated method stub
		if(tenantData!=null)
			return false;
		tenantRepo.save(tenantData);
		return true;
	}

	@Override
	public org.bson.Document getFullData(String name) {
		// TODO Auto-generated method stub
		//This function is to get all data in that row. 
		Tenants tenant = tenantRepo.findByName(name);
		org.bson.Document document = mongoTemplate.findById(tenant.getId(), org.bson.Document.class, "tenants");
		if(document!=null) {
			return document;
		}
		return null;
	}

}
