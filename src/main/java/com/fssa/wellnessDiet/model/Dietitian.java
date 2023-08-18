package com.fssa.wellnessDiet.model;



public class Dietitian {
	private String DietitianName;
	private String DietitianQualification;
	private String DietitianAddress;
	private int DietitianExperience;
	private int userID;
	private String DietitianUrl;

	public Dietitian(String dietitianName ,String dietitianAddress,String dietitianQualification, int dietitianExperience,int userID) {
		this.DietitianName = dietitianName;
		this.DietitianAddress = dietitianAddress;
		this.DietitianQualification = dietitianQualification;
		this.DietitianExperience = dietitianExperience;
		this.userID = userID;
		
	}
	//delete 
	public Dietitian(int userID) {
		this.userID = userID;
	}
	
	public Dietitian(String dietitianUrl) {
		super();
		DietitianUrl = dietitianUrl;
	}
	public String getDietitianUrl() {
		return DietitianUrl;
	}
	public void setDietitianUrl(String dietitianUrl) {
		DietitianUrl = dietitianUrl;
	}
	public Dietitian(String dietitianName ,String dietitianAddress,String dietitianQualification, int dietitianExperience) {
		super();
		this.DietitianName = dietitianName;
		this.DietitianExperience = dietitianExperience;
		this.DietitianAddress = dietitianAddress;
		this.DietitianQualification = dietitianQualification;
	}
	@Override
	public String toString() {
		return "Dietitian [DietitianName=" + DietitianName + ", DietitianQualification=" + DietitianQualification +", DietitianExperience=" + DietitianExperience +", DietitianAddress=" + DietitianAddress+ ", userID=" + userID
				+ ", getUserID()=" + getUserID() + ", getDietitianQualification()=" + getDietitianQualification()
				+ ", getDietitianName()=" + getDietitianName() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getDietitianQualification() {
		return DietitianQualification;
	}
	public void setDietitianQualification(String dietitianQualification) {
		DietitianQualification = dietitianQualification;
	}
	public String getDietitianName() {
		return DietitianName;
	}
	public void setDietitianName(String dietitianName) {
		DietitianName = dietitianName;
	}
	
	public String getDietitianAddress() {
		return DietitianAddress;
	}
	public void setDietitianAddress(String dietitianAddress) {
		DietitianAddress = dietitianAddress;
	}
	
	public int getDietitianExperience() {
		return DietitianExperience;
	}
	public void setDietitianExperience(int dietitianExperience) {
		DietitianExperience = dietitianExperience;
	}
	
}