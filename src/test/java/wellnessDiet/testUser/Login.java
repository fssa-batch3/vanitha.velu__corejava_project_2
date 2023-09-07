package wellnessDiet.testUser;

import com.fssa.wellnessDiet.service.*;
import com.fssa.wellnessDiet.service.exception.ServiceException;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class Login {

	@Test

	void testloginSuccess()  {

		try {
			assertTrue(UserService.loginUser("vanitha@gmail.com", "vanitha@123"));
		} catch (ServiceException e) {
			e.printStackTrace(); 
		}

	}

	@Test

	void testInvalidlogin() {  
		try {
			assertFalse(UserService.loginUser("mom@gmail.com", "vani@123"));
		} catch (ServiceException e) {
			e.printStackTrace(); 

		}

	}

	@Test

	void testInvalidPassword() {
		try {
			assertFalse(UserService.loginUser("vanitha@gmail.com", "vani#458"));
		} catch (ServiceException e) {
		
			e.printStackTrace();
		}

	}

	@Test
	void testNullInput() {

		try {
			assertFalse(UserService.loginUser(null, null));
		} catch (ServiceException e) {

			e.printStackTrace();
		}
	}

	@Test

	void testInvalidEmail() {
		try {
			assertFalse(UserService.loginUser("vanitha#gmail.com", "vanitha@123"));
		} catch (ServiceException e) {
		
			e.printStackTrace();
		}

	}

}