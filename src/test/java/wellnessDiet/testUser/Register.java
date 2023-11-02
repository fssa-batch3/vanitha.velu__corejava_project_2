package wellnessDiet.testUser;
import com.fssa.wellnessdiet.service.exception.ServiceException;

import com.fssa.wellnessdiet.validation.exception.InvalidUserException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.SQLException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.fssa.wellnessdiet.model.User;

import com.fssa.wellnessdiet.service.*;

 
public class Register {
	Throwable exception; 
	@Test
	  void testRegisterSuccess() {  
		User user1 = new User("durga","durgda@gmail.com","vanith@123","dietitian");
		UserService  UserService = new UserService();
		try { 
			assertTrue(UserService.registerUser(user1)); 
		} catch ( ServiceException e) {
			
			e.printStackTrace(); 
			fail(); 
		} 
	} 
	
	
	
	@Test
	
	 void testInvalidPassword() {
		UserService userService = new UserService();
		User user = new User("vanitha","vanitha@gmail.com","vani458","patient");
		
		
		try {
			
			assertFalse(userService.registerUser(user));
			
		} catch (ServiceException e) {
			e.getStackTrace();
			
		}
		
	}
	@Test
	
	
	 void testvalidPassword() {
		UserService userService = new UserService();
		User user = new User("vanitha","vanitha@gmail.com","vanitha@123","patient");
		
		
		try {
			
			assertFalse(userService.registerUser(user));
		} catch (ServiceException e) {
			System.out.println(e.getStackTrace());
			
		}
	}
	@Test
	 void testUserNull() {
		UserService userService = new UserService();
		User user1 = null;
		try {
			userService.registerUser(user1);
			fail();
		} catch (ServiceException e) {
			e.printStackTrace();

		} 
}
	

	
}
