package com.fssa.wellnessDiet.model;

public class Dietitian {
	private String DietitianName;
	private String DietitianQualification;
	private String DietitianAddress;
	private int DietitianExperience;
	private int UserID;
	private String DietitianUrl;


	public Dietitian(int UserID,String dietitianName, String ImageURL,String dietitianAddress,
			String dietitianQualification, int dietitianExperience) {
        this.UserID=UserID;
		this.DietitianUrl = ImageURL;
		this.DietitianName = dietitianName;
		this.DietitianQualification = dietitianQualification;
		this.DietitianAddress = dietitianAddress; 
		this.DietitianExperience = dietitianExperience;

	}


	public Dietitian(int userID) {
		this.UserID = userID;
	}
	public Dietitian() {
		
	}

	public Dietitian(String imageUrl, String detitianName, String qualification, String address, int experience) {
		
		this.DietitianUrl = imageUrl; 
		this.DietitianName = detitianName;
		this.DietitianQualification = qualification;
		this.DietitianAddress = address; 
		this.DietitianExperience = experience;
	}
	public String getDietitianUrl() {
		return DietitianUrl;
	}

	public void setDietitianUrl(String dietitianUrl) {
		DietitianUrl = dietitianUrl;
	}


	@Override
	public String toString() {
		return "Dietitian [DietitianName=" + DietitianName + ", DietitianQualification=" + DietitianQualification
				+ ", DietitianExperience=" + DietitianExperience + ", DietitianAddress=" + DietitianAddress
				+ ", userID=" + UserID + ", getUserID()=" + getUserID() + ", getDietitianQualification()="
				+ getDietitianQualification() + ", getDietitianName()=" + getDietitianName() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	public int getUserID() {
		return UserID;
	}

	public void setUserID(int userID) {
		this.UserID = userID;
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