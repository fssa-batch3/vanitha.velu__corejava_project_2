package TestRegisterFeature;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.google.protobuf.ServiceException;

import wellnessDiet3.model.User;
import wellnessDiet3.services.UserService;

public class TestValidatePassword {

	@Test 
	public void testValidPassword() {
		
		UserService userService = new UserService();
		
		User user = new User("Username_784", "vanitha@gmail.com","vani@123");
		
		try {
			assertTrue(userService.registerUser(user));
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	@Test 
	public void testInvalidPasswordWithoutSpecialCharacters() {
		
		UserService userService = new UserService();
		
		User user = new User("Username_784", "vanitha@gmail.com","vani123");
		
		try {
			assertFalse(userService.registerUser(user));
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
	
	
	@Test 
	public void testInvalidPasswordWithoutNumbers() {
		
		UserService userService = new UserService();
		
		User user = new User("Username_784","vanitha@gmail.com","vani@@@@@");
		
		try {
			assertFalse(userService.registerUser(user));
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
	
	@Test 
	public void testInvalidPasswordWithoutSpecialAlphabets() throws ServiceException {
		
		UserService userService = new UserService();
		
		User user = new User("Username_784", "vanitha@gmail.com","@1234567");
		
		try {
			assertFalse(userService.registerUser(user));
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
	
	@Test 
	public void testInvalidPasswordLengthlessThan8() {
		
		UserService userService = new UserService();
		
		User user = new User("Username_784","vanitha@gmail.com","vani@1");
		
		try {
			assertFalse(userService.registerUser(user));
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
	
	@Test 
	public void testInvalidPasswordWithoutUppercase() {
		
		UserService userService = new UserService();
		
		User user = new User("Username_784","vanitha@gmail.com","vani@1234");
		
		try {
			assertFalse(userService.registerUser(user));
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
}

