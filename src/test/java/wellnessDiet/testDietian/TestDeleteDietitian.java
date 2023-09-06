package wellnessDiet.testDietian;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.wellnessDiet.model.Dietitian;
import com.fssa.wellnessDiet.service.DietitianService;
import com.fssa.wellnessDiet.service.exception.*;

public class TestDeleteDietitian {
	
	@SuppressWarnings("static-access")
	@Test
	
	void deleteDietitianSuccess() {
		DietitianService dietitianService =new DietitianService();  
		
		try {
			assertTrue(dietitianService.deleteDietitian(new Dietitian(3,"Utchikannan Test", "https://images.unsplash.com/photo-1612349317150-e413f6a5b16d?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NXx8ZG9jdG9yfGVufDB8fDB8fHww&auto=format&fit=crop&w=600&q=60","vanitha@gmail.com", "Thiruvengadam Nagar, Perungudi, Chennai, Tamil Nadu 600096", "Dietitian",8)));  
		}
		catch(ServiceException e) {
			System.err.println(e.getMessage());
		}
	}

	@SuppressWarnings("static-access")
	@Test
	
	void deleteDietitianFail() {
		DietitianService dietitianService =new DietitianService();
		
		try {
			assertFalse(dietitianService.deleteDietitian(new Dietitian(96,"vanitha", "imagelink-url", "vanitha@gmail.com", "GEM Hospital,perungudi,chennai", "Dietitian",56)));
		}
		catch(ServiceException e) {
			System.err.println(e.getMessage());
		}
	}
}
