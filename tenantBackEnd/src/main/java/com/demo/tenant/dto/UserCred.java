package com.demo.tenant.dto;

public class UserCred {
	private String name;
	private String password;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserCred(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}
	public UserCred() {
		super();
	}
	@Override
	public String toString() {
		return "UserCred [name=" + name + ", password=" + password + "]";
	}
}
