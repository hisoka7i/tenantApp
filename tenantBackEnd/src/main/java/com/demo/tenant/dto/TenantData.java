package com.demo.tenant.dto;

public class TenantData {
	private String name;
	private String password;
	private String type = "user";
	private String phone;
	private int rent;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getRent() {
		return rent;
	}
	public void setRent(int rent) {
		this.rent = rent;
	}
	public TenantData(String name, String password, String type, String phone, int rent) {
		super();
		this.name = name;
		this.password = password;
		this.type = type;
		this.phone = phone;
		this.rent = rent;
	}
	public TenantData() {
		super();
	}
	@Override
	public String toString() {
		return "TenantData [name=" + name + ", password=" + password + ", type=" + type + ", phone=" + phone + ", rent="
				+ rent + "]";
	}
	
}
