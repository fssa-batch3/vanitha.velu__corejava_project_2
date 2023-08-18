package wellnessDiet.testDietian;



public class TestDietitian {


@Test 

public void testRegistrationSuccess() {
	UserService userService = new UserService();
	
	try {
		assertTrue(UserService.registerUser(user1));
	} catch (ServiceException e) {
		e.printStackTrace();
		fail();
	}

}
