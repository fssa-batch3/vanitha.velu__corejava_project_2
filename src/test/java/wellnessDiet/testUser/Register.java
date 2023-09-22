package wellnessDiet.testUser;
import com.fssa.wellnessDiet.service.exception.ServiceException;
import com.fssa.wellnessDiet.validation.exception.InvalidUserException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.SQLException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.fssa.wellnessDiet.model.User;

import com.fssa.wellnessDiet.service.*;

 
public class Register {
	Throwable exception; 
	@Test
	  void testRegisterSuccess() {  
		User user1 = new User("durga","durga@gmail.com","vanith@123","dietitian", 0);
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
		User user = new User("vanitha","vanitha@gmail.com","vani458","patient", 0);
		
		
		try {
			
			assertFalse(userService.registerUser(user));
			
		} catch (ServiceException e) {
			e.getStackTrace();
			
		}
		
	}
	@Test
	
	
	 void testvalidPassword() {
		UserService userService = new UserService();
		User user = new User("vanitha","vanitha@gmail.com","vanitha@123","patient", 0);
		
		
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
