package wellnessDiet.testDietian;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.wellnessDiet.dao.DietitianDAO;
import com.fssa.wellnessDiet.dao.exception.DAOException;
import com.fssa.wellnessDiet.model.Dietitian;
import com.fssa.wellnessDiet.service.DietitianService;
import com.fssa.wellnessDiet.service.exception.ServiceException;


public class TestUpdateDietitian {

	
	 @Test
	    public void testValidUpdate() {
	    	Dietitian dietitianService1 = new Dietitian(2,"vanitha", "imagelink-url", "vanitha123@gmail.com", "GEM Hospital,perungudi,chennai", "Dietitian",12); 
	    	//assertTrue(DietitianDAO.(dietitianService1));
			try {
				assertTrue(DietitianDAO.UpdateDietitian(dietitianService1));
			} catch (DAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }

	 
	 

	    
	    @Test
	    public void testNullValue() {
	        Dietitian dietitianService1 = new Dietitian();
	        try {
	    		assertFalse(DietitianService.updateDietitian(dietitianService1));
	    	}catch(ServiceException e){
	    		e.printStackTrace();
	    		fail();
	    	}
	    }
	    
	    
	    // invalid dietitian name 
	    
	    @Test
	    public void testInavlidQualificationName() { 
	        Dietitian dietitianService1 = new  Dietitian("vanitha", "imagelink-url", "vanitha@gmail.com", "GEM Hospital,perungudi,chennai", "Developer",12);
	        try {
	    		assertFalse(DietitianService.updateDietitian(dietitianService1));
	    	}catch(ServiceException e){
	    		e.printStackTrace();
	    		fail();
	    	}
	    }



}
