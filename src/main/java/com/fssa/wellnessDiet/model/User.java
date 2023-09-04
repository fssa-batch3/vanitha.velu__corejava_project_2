package com.fssa.wellnessDiet.model;

public class User {
	
	private String username;
	public String email;
	public String password;
	public int UserId;

// public User (String email) {
//		this.email = email;
//	 
// }
 
 public User(String username,String email,String password, int UserId) { 
	 this.username = username;
	 this.password = password;
	 this.email = email;
	 this.UserId = UserId;
 }

	
	public User(String username, String email, String password) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;

	}
	



	public User() {
		// TODO Auto-generated constructor stub
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
	@Override
	public String toString() {
		return "User [username=" + username + ", email=" + email + ", password=" + password +"]";   
	}
	
}
