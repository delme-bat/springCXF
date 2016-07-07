package com.bush76.core.entity;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "User")
public class User implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1068806964641093433L;

	@XmlElement(name = "_id")
	private String id;
	
	@XmlElement(name = "_name")
	private String name;
	
	@XmlElement(name = "_password")
	private String password;

	public User(){
		
	}
	
	public User(String id,String name,String password){
		this.id = id;
		this.name = name;
		this.password = password;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String toString() {
		return "id : " + id + " \nname : " + name + "\npassword : " + password;
	}
	
}