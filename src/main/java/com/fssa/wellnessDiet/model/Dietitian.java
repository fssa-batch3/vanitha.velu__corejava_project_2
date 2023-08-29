package com.fssa.wellnessDiet.model;

public class Dietitian {
	private String DietitianName;
	private String DietitianQualification;
	private String DietitianAddress;
	private int DietitianExperience;
	private int UserID;
	private String DietitianUrl;
	private String DietitianEmail;


	public Dietitian(String dietitianName, String ImageURL, String dietitianEmail, String dietitianAddress,
			String dietitianQualification, int dietitianExperience) {

		this.DietitianUrl = ImageURL;
		this.DietitianName = dietitianName;
		this.DietitianQualification = dietitianQualification;
		this.DietitianAddress = dietitianAddress;
		this.DietitianEmail = dietitianEmail;
		this.DietitianExperience = dietitianExperience;

	}

	// delete
	public Dietitian(int userID) {
		this.UserID = userID;
	}

//	public void Dietitian(int userID,String dietitianName , int dietitianExperience,String dietitianQualification,String dietitianAddress) {
//	
//		DietitianUrl = getDietitianUrl();
//	}
	public String getDietitianUrl() {
		return DietitianUrl;
	}

	public void setDietitianUrl(String dietitianUrl) {
		DietitianUrl = dietitianUrl;
	}

//	public Dietitian(String dietitianName ,String dietitianAddress,String dietitianQualification, int dietitianExperience) {
//		super();
//		this.DietitianName = dietitianName;
//		this.DietitianExperience = dietitianExperience;
//		this.DietitianAddress = dietitianAddress;
//		this.DietitianQualification = dietitianQualification;
//	}
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

	public String getDietitianEmail() {

		return DietitianEmail;
	}

}