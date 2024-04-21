package com.demo.tenant.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.tenant.dao.AdminRepo;
import com.demo.tenant.dto.UserCred;
import com.demo.tenant.modal.Admins;

@Service
@Transactional
public class UserServiceImpl implements UserServiveI {

	@Override
	public Admins findByUserPass(UserCred userCred) {
		// TODO Auto-generated method stub
		return AdminRepo.findBy(userCred.getName(),userCred.getPassword());
	}
	
}
