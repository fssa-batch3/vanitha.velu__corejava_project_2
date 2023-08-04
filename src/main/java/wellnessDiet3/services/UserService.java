package wellnessDiet3.services;
import java.sql.SQLException;

import com.google.protobuf.ServiceException;

import wellnessDiet.services.exception.serviceException;
import wellnessDiet.validation.UserValidator;
import wellnessDiet3.dao.*;
import wellnessDiet3.model.User;
import wellnessDiet3.services.*;
import wellnessDiet3.validation.exception.InvalidUserException;

public class UserService {

	public static boolean registerUser(User user) throws ServiceException {
		UserDAO userDAO = new UserDAO();
		try {
		if(UserValidator.ValidateUser(user)) { 
			if(userDAO.register(user)) {
				System.out.println(user.getUsername() + " Successfully Registered!");
				return true;
			} else {
				System.out.println("Registration not successful!");
				return false;
			}
		} else {
			return false;
		}
		} catch ( SQLException | InvalidUserException e) {
			throw new ServiceException(e);
		}
	}
	
	
	public static boolean LoginUser(User user) throws ServiceException {
		UserDAO userDAO = new UserDAO();
		try {
			if(userDAO.login(user)) {
				System.out.println("\n" + user.email + " Login Successful!");
				return true;
			} else {
				System.out.println("\n" + " Login Not Successful! ReCheck Your Credentials");
				return false;
			}
		} catch (SQLException e) {
			throw new ServiceException(e);
		}
	}
}
