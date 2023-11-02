package com.fssa.wellnessdiet.model;

import java.io.Serializable;

public class User implements Serializable {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	public String email;
	public String password;
	public int UserId;
	private String type;


 
 public User(String username,String email,String password,String type) { 
	 this.username = username;
	 this.password = password;
	 this.email = email;
	 this.type = type;
	  
 }

	

	public User() {
	
}



	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int UserId) {
		this.UserId = UserId;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {  
		this.type = type;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", email=" + email + ", password=" + password + "type" + type + "]";   
	}




	
}
