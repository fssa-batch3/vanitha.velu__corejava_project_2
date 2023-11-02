package wellnessDiet.testUser;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.fssa.wellnessdiet.service.exception.ServiceException;
import com.fssa.wellnessdiet.model.User;
import com.fssa.wellnessdiet.service.*;

public class TestGetAllUser {

	@Test
	void ValidGetSuccess() {

		UserService service = new UserService(); 
		try {
			assertTrue(service.registerUser(new User("vanitha", "vanitha.velu@fsaa.freshworks.com",
					"24@vanitha","patient")));
			List<User> list = UserService.getAllUser();
			assertNotNull(list);

			for (User p : list) {
				System.err.println(p.toString());
			}
 
		} catch (ServiceException e) {
			fail();
		}

	}
}
