package com.fssa.wellnessDiet.service;

import java.sql.SQLException;

import com.fssa.wellnessDiet.model.Dietitian;
import com.fssa.wellnessDiet.model.User;
import com.fssa.wellnessDiet.service.exception.ServiceException;
import com.fssa.wellnessDiet.validation.DietitianValidator;
import com.fssa.wellnessDiet.validation.UserValidator;
import com.fssa.wellnessDiet.validation.exception.InvalidUserException;
import com.fssa.wellnessDiet.dao.*;
import com.fssa.wellnessDiet.dao.exception.DAOException;

public class DietitianService {

	public static boolean dietitianUser(String DietitianName, String DietitianAdress, String DietitianQualification,
			String DietitianExperience) throws ServiceException {

		UserDAO userdao = new UserDAO();

		DietitianValidator.validateName(DietitianName);
		DietitianValidator.validateAddress(DietitianAdress);
		DietitianValidator.validateExperience(DietitianExperience);
		DietitianValidator.validateQualification(DietitianQualification);
		 
		
		
		
		 return true;

	}

}