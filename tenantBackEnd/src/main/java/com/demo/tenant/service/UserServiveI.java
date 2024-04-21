package com.demo.tenant.service;

import com.demo.tenant.dto.UserCred;
import com.demo.tenant.modal.Admins;

public interface UserServiveI {
	Admins findByUserPass(UserCred userCred);
}
