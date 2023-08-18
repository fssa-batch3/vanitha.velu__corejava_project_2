package com.fssa.wellnessDiet.service;


import java.sql.SQLException;

import com.fssa.wellnessDiet.Validator.DietitianValidator;
import com.fssa.wellnessDiet.Validator.UserValidator;
import com.fssa.wellnessDiet.Validator.exception.InvalidUserException;
import com.fssa.wellnessDiet.model.Dietitian;
import com.fssa.wellnessDiet.model.User;
import com.fssa.wellnessDiet.service.exception.ServiceException;
import com.fssa.wellnessDiet.dao.*;
import com.fssa.wellnessDiet.dao.exception.DAOException;

public class DietitianService {
	public static boolean dietitianUser(String DietitianName, String DietitianAdress, String DietitianQualification, int DietitianExperience) throws ServiceException {
		UserDAO userdao =  new UserDAO(); 
		
		try {
		DietitianValidator.validateName(DietitianName);
		DietitianValidator.validateAddress(DietitianAddress);
		DietitianValidator.validateExperience(DietitianExperience); 
		DietitianValidator.validateQualification(DietitianQualification);
	
		
			if(user.getEmail().equals(email) ){
				if(user.getPassword().equals(password)) {	
					userdao.setLoggedIn(email);
					System.out.println("Login successful");
					return true;
				} else {
					System.out.println("Invalid Password");
					return false;
				}
				
			} else {
				System.out.println("Login not successful"); 
				return false;
			}
		}
		 catch (DAOException | InvalidUserException e) {
			
			throw new ServiceException(e);
		}
	}
		 
}