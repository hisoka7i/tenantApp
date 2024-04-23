package com.demo.tenant.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.tenant.dto.TenantData;

import jakarta.annotation.PostConstruct;

@RestController
@CrossOrigin("*")
public class UserController {
	@PostMapping("/register")
	public ResponseEntity<?> registerTenant(@RequestBody TenantData tenantData){
		return null;
	}
}
