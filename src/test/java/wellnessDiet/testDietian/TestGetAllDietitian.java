package wellnessDiet.testDietian;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.fssa.wellnessdiet.model.Dietitian;
import com.fssa.wellnessdiet.service.DietitianService;
import com.fssa.wellnessdiet.service.exception.ServiceException;
import com.fssa.wellnessdiet.dao.DietitianDAO;
import com.fssa.wellnessdiet.dao.exception.DAOException;

public class TestGetAllDietitian { 

	@Test
	
	void ValidGetSuccess() { 
		
		DietitianDAO dietitianDAO = new DietitianDAO();
		@SuppressWarnings("unused")
		DietitianService dietitianService = new DietitianService();
		
		try {
					
			List<Dietitian> list = dietitianDAO.ReadDietitian(new Dietitian("vanitha", "imagelink-url", "GEM Hospital,perungudi,chennai", "Dietitian",12)); 
			assertNotNull(list);
			System.out.println(list);
		 
		}
		catch(DAOException e) {
			e.printStackTrace();
			fail();
		}
	}	

}
