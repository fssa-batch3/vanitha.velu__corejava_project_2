package wellnessDiet.testDietian;

import static org.junit.jupiter.api.Assertions.assertFalse;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.wellnessdiet.model.Dietitian;
import com.fssa.wellnessdiet.service.DietitianService;
import com.fssa.wellnessdiet.service.exception.*;

public class TestDeleteDietitian {
	
	@SuppressWarnings("static-access") 
	@Test
	
	void deleteDietitianSuccess() {
		DietitianService dietitianService =new DietitianService();     
		
		try {
			assertTrue(dietitianService.deleteDietitian(new Dietitian(14)));  
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
			assertFalse(dietitianService.deleteDietitian(new Dietitian( )));
		}
		catch(ServiceException e) {
			System.err.println(e.getMessage()); 
		}
	}
}
