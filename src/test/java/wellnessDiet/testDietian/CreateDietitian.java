package wellnessDiet.testDietian;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;
import com.fssa.wellnessDiet.service.*;
import com.fssa.wellnessDiet.model.*;
import com.fssa.wellnessDiet.service.exception.ServiceException;
import com.fssa.wellnessDiet.validation.exception.InvalidUserException;

public class CreateDietitian {
	@Test
	public void testCreateProduct() throws InvalidUserException, SQLException {
		DietitianService DietitianService = new DietitianService();
		Dietitian Dietitian = new Dietitian( "Vanitha","image-Url","vanitha@gmail.com" ,"Gem", "Dietitian", 12);
		
		try {
			assertTrue(DietitianService.addDietitian(Dietitian));
		}catch(ServiceException e){
			e.printStackTrace();
			fail();
		}
	}

}
