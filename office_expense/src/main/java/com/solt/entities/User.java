package com.solt.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity

public class User implements Serializable {
	
	public enum userRole{
		Office
	}
	   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String password;
	@Enumerated(EnumType.STRING)
	private userRole role;
	private static final long serialVersionUID = 1L;

	@Embedded
	private Security security;
	
	private String loginId=String.valueOf(this.id);
	@PrePersist
	private void prePersit(){
		security=new Security();
		security.setCreation(new Date());
		security.setModification(new Date());
		security.setUserId(loginId);
		System.out.println(security.getUserId());
	}
	@PreUpdate
	private void preUpdate(){
		if(null==security){
			security=new Security();
			security.setCreation(new Date());
			security.setUserId(loginId);
		}
		security.setModification(new Date());
	}
	
	public User() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public userRole getRole() {
		return role;
	}
	public void setRole(userRole role) {
		this.role = role;
	}
	
   
}
