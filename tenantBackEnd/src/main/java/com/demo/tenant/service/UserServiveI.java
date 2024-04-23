package com.demo.tenant.service;

import com.demo.tenant.dto.UserCred;
import com.demo.tenant.modal.Tenants;

public interface UserServiveI {
	Tenants findByUserPass(UserCred userCred);
}
