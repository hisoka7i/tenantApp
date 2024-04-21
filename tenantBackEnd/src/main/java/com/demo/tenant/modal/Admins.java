package com.demo.tenant.modal;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "adminData")
public class Admins {
	private String name;
	private String type;
	private String password;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Admins(String name, String type, String password) {
		super();
		this.name = name;
		this.type = type;
		this.password = password;
	}
	public Admins() {
		super();
	}
	@Override
	public String toString() {
		return "Admins [name=" + name + ", type=" + type + ", password=" + password + "]";
	}
}
