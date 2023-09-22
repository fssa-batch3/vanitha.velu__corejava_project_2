package com.fssa.wellnessDiet.model;

public class Dietitian {
	private String DietitianName;
	private String DietitianQualification;
	private String DietitianAddress;
	private int DietitianExperience;
	private int dietitian_id;
	private String DietitianUrl;
	private int createdUser;

	public Dietitian(int dietitian_id, String dietitianName, String ImageURL, String dietitianAddress,
			String dietitianQualification, int dietitianExperience) {
		this.dietitian_id = dietitian_id;
		this.DietitianUrl = ImageURL;
		this.DietitianName = dietitianName;
		this.DietitianQualification = dietitianQualification;
		this.DietitianAddress = dietitianAddress;
		this.DietitianExperience = dietitianExperience;

	}

	public Dietitian(int dietitian_id) {
		this.dietitian_id = dietitian_id;
	}

	public Dietitian() {

	}

	public Dietitian(String imageUrl, String detitianName, String qualification, String address, int experience,
			int createdUser) {

		this.DietitianUrl = imageUrl;
		this.DietitianName = detitianName;
		this.DietitianQualification = qualification;
		this.DietitianAddress = address;
		this.DietitianExperience = experience;
		this.setCreatedUser(createdUser);
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
				+ ", userID=" + dietitian_id + ", getdietitian_id()=" + getdietitian_id()
				+ ", getDietitianQualification()=" + getDietitianQualification() + ", getDietitianName()="
				+ getDietitianName() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	public int getdietitian_id() {
		return dietitian_id;
	}

	public void setdietitian_id(int dietitian_id) {
		this.dietitian_id = dietitian_id;
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

	public int getCreatedUser() {
		return createdUser;
	}

	public void setCreatedUser(int createdUser) {
		this.createdUser = createdUser;
	}



}