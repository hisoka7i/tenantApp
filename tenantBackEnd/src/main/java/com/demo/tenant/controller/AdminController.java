package com.demo.tenant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.tenant.dto.UserCred;
import com.demo.tenant.dto.UsernameRequest;
import com.demo.tenant.service.AdminServiceI;
import com.demo.tenant.service.UserServiveI;

@RestController
@CrossOrigin("*")
public class AdminController {
	@Autowired
	private AdminServiceI adminSer;
	@Autowired
	private UserServiveI userSer;
	
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
		//This is for admin login
		Object dtoSendAdmin = adminSer.findbyUserPass(usercred);
		//This is for user login
		Object dtoSendUser = userSer.findByUserPass(usercred);
		if(dtoSendAdmin!=null) {
			return ResponseEntity.ok(dtoSendAdmin);
		}
		if(dtoSendUser!=null) {
			return ResponseEntity.ok(dtoSendUser);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	@PostMapping("/delete")
	public ResponseEntity<?> deleteUser(@RequestBody UsernameRequest userName){
		boolean status = adminSer.deleteUser(userName.getName());
		if(status) {
			return ResponseEntity.status(HttpStatus.OK).build();
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
}
