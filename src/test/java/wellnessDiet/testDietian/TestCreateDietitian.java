package wellnessDiet.testDietian;
import org.junit.jupiter.api.Test;


import com.fssa.wellnessdiet.model.Dietitian;
import com.fssa.wellnessdiet.service.DietitianService;
import com.fssa.wellnessdiet.service.exception.ServiceException;

public class TestCreateDietitian {

	
	/*
	 * Define a test method for create Dietitian
	 */
	@Test 
	
	void testCreateDietitianSuccess() {
		
		DietitianService dietitianService =new DietitianService();
		Dietitian dietitian1 = new Dietitian("vanitha", "imagelink-url",  "GEM Hospital,perungudi,chennai", "Dietitian",12);
		
		try {
			dietitianService.addDietitian(dietitian1);
			System.out.println("Dietitian Successfully Created");
		}
		catch(ServiceException e) {
			System.out.println(e.getMessage()); 
		} 
	}
	
	/*
	 * Define a test method for fail to create Dietitian
	 */
	@Test
	
	void testCreateDietitianFail() { 
		

		DietitianService dietitianService =new DietitianService();
		Dietitian dietitian2 = new Dietitian("imageUrl","Vanitha","Chennai","Bsc",6);
		
		try {
			dietitianService.addDietitian(dietitian2);
			System.out.println("Failed to Create Dietitian");
		}
		catch(ServiceException e) {
			System.out.println(e.getMessage());
		}
	
	}
}
