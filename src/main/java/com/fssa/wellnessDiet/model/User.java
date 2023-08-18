package com.fssa.wellnessDiet.model;

public class User {
	
	private String username;
	public String email;
	public String password;
	
 public User (String email) {
		this.email = email;
	 
 }
 
 public User(String email,String password) {
	 this.password = password;
	 this.email = email;
 }
 
 public User() {
	 
	 
 }
	
	
	public User(String username, String email, String password) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
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
	
	@Override
	public String toString() {
		return "User [username=" + username + ", email=" + email + ", password=" + password + "]";
	}
	
}
