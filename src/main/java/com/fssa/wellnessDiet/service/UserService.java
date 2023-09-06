package com.fssa.wellnessDiet.service;

import java.util.List;

import com.fssa.wellnessDiet.dao.*;
import com.fssa.wellnessDiet.model.*;
import com.fssa.wellnessDiet.dao.UserDAO;
import com.fssa.wellnessDiet.dao.exception.DAOException;
import com.fssa.wellnessDiet.model.User;
import com.fssa.wellnessDiet.service.exception.ServiceException;
import com.fssa.wellnessDiet.validation.UserValidator;
import com.fssa.wellnessDiet.validation.exception.InvalidUserException;

public class UserService {
	
	public boolean registerUser(User user) throws ServiceException { ///
		UserDAO userdao =  new UserDAO();   
		
		try {
		
		if(userdao.emailAlreadyExists(user.getEmail())==false) {
			if( userdao.insertUser(user)){
				System.out.println(user.getEmail() + " successful");
				return true;
			} else {
				System.out.println("registration not successful");
				return false;
			}
		} else {
			System.out.println("Email Already Exists");
			return false;
		}
		}
		 catch (DAOException | InvalidUserException e) {
			
			throw new ServiceException(e);
		}
	}
 



	public static boolean loginUser(String email, String password) throws ServiceException {
		UserDAO userdao =  new UserDAO();
		
		try {
		UserValidator.validateEmail(email);
		UserValidator.validatePassword(password);
		 User  user = userdao.findUserByEmail(email);
		 if(user.getPassword().equals(password)) {	

			 System.out.println("Login successful");
			 return true;
		 } else {
			 System.out.println("Invalid Password");
			 return false;
		 }
			
		}
		 catch (DAOException e) {
			
			throw new ServiceException(e);
		}
	}
	
	
	public static List<User> getAllUser1() throws ServiceException{
		
		UserDAO userDAO = new UserDAO();  
		try {
			
			List<User> user1 = userDAO.getAllUsers();
			return user1;
		} catch(DAOException e) {
			throw new ServiceException(e);
		}
	}







	

}
