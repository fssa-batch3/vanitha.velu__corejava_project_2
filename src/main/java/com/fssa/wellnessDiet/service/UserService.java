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
	
	public UserService() {
		// Default Parameter
	}
	/**
	 * Registers a new user in the system.
	 *
	 * @param user The User object representing the user to be registered.
	 * @return true if the user is successfully registered, false otherwise.
	 * @throws ServiceException If a service-level error occurs, including email validation and database errors.
	 */
	
	public boolean registerUser(User user) throws ServiceException { 
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
 
	/**
	 * Logs in a user with the provided email and password.
	 *
	 * @param email The email address of the user.
	 * @param password The password of the user.
	 * @return true if the login is successful, false otherwise.
	 * @throws ServiceException If a service-level error occurs, including email and password validation, as well as database errors.
	 */


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
	
	
	
	/**
	 * Retrieves a list of all users from the database.
	 *
	 * @return A List of User objects representing all users in the database.
	 * @throws ServiceException If a service-level error occurs, including database errors.
	 */
	
	public static List<User> getAllUser() throws ServiceException{
		
		UserDAO userDAO = new UserDAO();  
		try {
			
			List<User> user1 = userDAO.getAllUsers();
			return user1;
		} catch(DAOException e) {
			throw new ServiceException(e);
		}
	}
	public static User findingUserByEmail(String email) throws ServiceException {
		try {
	
			User user = new UserDAO().findUserByEmail(email);

			if (user == null)
				throw new ServiceException("user obj is null");

			return user;
		} catch (DAOException e) {
		
			throw new ServiceException("Error in service");
		}
	}

	

}
