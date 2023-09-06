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
	    	Dietitian dietitianService1 = new Dietitian(5,"DtKishore", "test",  "Thiruvengadam Nagar Perungudi Chennai Tamil Nadu 600096", "Dietitian",12); 
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
	        Dietitian dietitianService1 = new  Dietitian("Dt.Kishore", "https://images.unsplash.com/photo-1612349317150-e413f6a5b16d?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NXx8ZG9jdG9yfGVufDB8fDB8fHww&auto=format&fit=crop&w=600&q=60",  "Thiruvengadam Nagar, Perungudi, Chennai, Tamil Nadu 600096", "Dietitian",12);
	        try {
	    		assertFalse(DietitianService.updateDietitian(dietitianService1));
	    	}catch(ServiceException e){
	    		e.printStackTrace();
	    		fail();
	    	}
	    }



}
