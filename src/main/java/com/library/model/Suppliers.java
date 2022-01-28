package com.library.model;

public class Suppliers {
	
	private String supplierName;
	private String address;
	private long contact;
	
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplier_name) {
		this.supplierName = supplier_name;
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
	public Suppliers(String supplier_name, String address, long contact) {
		super();
		this.supplierName = supplier_name;
		this.address = address;
		this.contact = contact;
	}
	public Suppliers() {
		super();
	}
	public Suppliers(String supplier_name) {
		this.supplierName=supplier_name;
	}
	public Suppliers(String supplier_name, long contact) {
		this.supplierName = supplier_name;
		this.contact = contact;
	}
	
	

}
