package com.tiangou.entity;

import java.util.Date;

public class Indent {
 private String id;
 private 	String name;
 private String address;
 private Date createDate;
 private int price;
 private IndentContact indentContact;
 
public IndentContact getIndentContact() {
	return indentContact;
}
public void setIndentContact(IndentContact indentContact) {
	this.indentContact = indentContact;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public Date getCreateDate() {
	return createDate;
}
public void setCreateDate(Date createDate) {
	this.createDate = createDate;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}

}
