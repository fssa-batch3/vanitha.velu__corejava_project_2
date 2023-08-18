package com.fssa.wellnessDiet.service;

import java.sql.SQLException;

import com.fssa.wellnessDiet.Validator.UserValidator;
import com.fssa.wellnessDiet.Validator.exception.InvalidUserException;
import com.fssa.wellnessDiet.model.User;
import com.fssa.wellnessDiet.service.exception.ServiceException;
import com.fssa.wellnessDiet.dao.*;
import com.fssa.wellnessDiet.dao.exception.DAOException;

public class UserService {

	public static boolean loginUser(String email, String password) throws ServiceException {
		UserDAO userdao =  new UserDAO();
		
		try {
		UserValidator.validateEmail(email);
		UserValidator.validatePassword(password);
		 User  user = userdao.findUserByEmail(email);
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
