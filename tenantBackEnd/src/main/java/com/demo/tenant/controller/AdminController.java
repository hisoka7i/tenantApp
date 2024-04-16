package com.demo.tenant.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.tenant.dao.TenantsRepo;
import com.demo.tenant.modal.Tenants;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@CrossOrigin("*")
public class AdminController {
	@Autowired
	TenantsRepo tenants;
	
	@RequestMapping(value="/")
	public void Redirect(HttpServletResponse response) throws IOException {
		System.out.println("This line is wokring!!!");
	}
	
	@GetMapping("/all")
	public List<Tenants> getAllUsers(){
		return tenants.findAll();
	} 
}
