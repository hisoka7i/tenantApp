package com.demo.tenant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.tenant.dto.UserCred;
import com.demo.tenant.modal.Tenants;
import com.demo.tenant.service.AdminServiceI;

@RestController
@CrossOrigin("*")
public class AdminController {
	@Autowired
	private AdminServiceI adminSer;
	
//	@RequestMapping(value="/")
//	public void Redirect(@RequestBody  response) throws IOException {
//		System.out.println("This line is working!!!");
//	}
	
	//responseEntity is spring class that represents spring represents http response
	@GetMapping("/all")
	public ResponseEntity<?> getAllUsers(){
//		return adminSer.findAll();
		return ResponseEntity.ok(adminSer.findAll());
	}
	
	//I need to write a function for user login
	//from the request body we will receive the json object and it 
	@PostMapping("/login")
	public ResponseEntity<?> adminLogin(@RequestBody UserCred usercred){
		Tenants dtoSend = adminSer.findbyUserPass(usercred);
		if(dtoSend!=null) {
			return ResponseEntity.ok(dtoSend);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
}
