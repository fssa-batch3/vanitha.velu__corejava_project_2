package wellnessDiet.testDietian;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.fssa.wellnessDiet.dao.DietitianDAO;
import com.fssa.wellnessDiet.dao.exception.DAOException;
import com.fssa.wellnessDiet.model.Dietitian;
import com.fssa.wellnessDiet.service.DietitianService;
import com.fssa.wellnessDiet.service.exception.ServiceException;

public class TestGetAllDietitian {

	@Test
	
	void ValidGetSuccess() {
		
		DietitianDAO dietitianDAO = new DietitianDAO();
		@SuppressWarnings("unused")
		DietitianService dietitianService = new DietitianService();
		
		try {
					
			List<Dietitian> list = dietitianDAO.ReadDietitian(new Dietitian("vanitha", "imagelink-url", "vanitha@gmail.com", "GEM Hospital,perungudi,chennai", "Developer",12)); 
			assertNotNull(list);
			
			for(Dietitian d : list) {
				System.out.println(d.toString());
			}
			System.out.println("Successfully Listed");
		}
		catch(DAOException e) {
			e.printStackTrace();
			fail();
		}
	}
	

}
