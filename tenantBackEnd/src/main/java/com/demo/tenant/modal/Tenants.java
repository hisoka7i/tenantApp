package com.demo.tenant.modal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="tenants")
public class Tenants {
	@Id
	private String id;
	@Field("name")
	private String name;
	@Field("gender")
	private String gender;
	@Field("type")
	private String type;
	@Field("phone")
	private String phone;
	@Field("rent")
	private int rent;
	@Field("password")
	private String password;
	@Field("address")
	private String address;
	@Field("doa")
	private String doa;
	@Field("paymentStatus")
	private String paymentStatus;
	
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	public String getDoa() {
		return doa;
	}
	public void setDoa(String doa) {
		this.doa = doa;
	}
	
	
	@Override
	public String toString() {
		return "Tenants [id=" + id + ", name=" + name + ", gender=" + gender + ", type=" + type + ", phone=" + phone
				+ ", rent=" + rent + ", password=" + password + ", address=" + address + ", doa=" + doa
				+ ", paymentStatus=" + paymentStatus + "]";
	}
	public Tenants() {
		super();
	}
	
}
