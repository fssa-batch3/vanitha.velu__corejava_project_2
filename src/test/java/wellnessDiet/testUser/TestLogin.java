package wellnessDiet.testUser;

import com.fssa.wellnessDiet.service.*;
import com.fssa.wellnessDiet.model.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.google.protobuf.ServiceException;

 public class TestLogin {

	 @Test
		
	 void testloginSuccess() {
			try {
				assertTrue(UserService.login("vanitha@gmail.com","vanitha@123"));
			}  	
			 catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				fail();
			}
		
		
	}

@Test

void testInvalidloginSuccess() {
		try {
			assertFalse(UserService.login("mom@gmail.com","vani@123"));
		}  	
		 catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	
	
}
@Test

 void testInvalidPassword() {
	try {
		assertFalse(UserService.login("vanitha@gmail.com","vani#458"));
	}  	
	 catch (ServiceException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}


}

@Test
 void testNullInput() {
   
    try {
		assertFalse(UserService.login(null,null));
	} catch (ServiceException e) {
		
		e.printStackTrace();
	}
}

@Test

 void testInvalidEmail() {
	try {
		assertFalse(UserService.login("vanitha#gmail.com","vanitha@123"));
	}  	
	 catch (ServiceException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}


}

}