package com.library.model;

public class Suppliers {
	
	private String supplierName;
	private String address;
	private long contact;
	
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getContact() {
		return contact;
	}
	public void setContact(long contact) {
		this.contact = contact;
	}
	public Suppliers(String supplierName, String address, long contact) {
		super();
		this.supplierName = supplierName;
		this.address = address;
		this.contact = contact;
	}
	public Suppliers() {
		super();
	}
	public Suppliers(String supplierName) {
		this.supplierName=supplierName;
	}
	public Suppliers(String supplierName, long contact) {
		this.supplierName = supplierName;
		this.contact = contact;
	}
	
	

}
