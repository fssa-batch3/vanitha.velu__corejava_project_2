package wellnessDiet.testDietian;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.wellnessDiet.service.exception.ServiceException;

public class TestUpdateDietitian {

	 @Test
	    public void testValidUpdate() {
	    	DietitianService dietitianService = new DietitianService();
	    	Dietitian dietitianService = new Dietitian(30, "you", "imagelink-url", "pdf-link-url", "TRILLER");
	    	try {
	    		assertTrue(DietitianService.DietitianUpdate(dietitianService));
	    	}catch(ServiceException e){
	    		e.printStackTrace();
	    		fail();
	    	}
	    }

	 
	 
	    
	    @Test
	    public void testInValidUpdate() {
	        DietitianService readbooksService = new DietitianService();
	        Dietitian dietitianService = new Dietitian(40, "dump", "imagelink-url", "pdf-link-url", "TRILLER");
	        try {
	    		assertTrue(dietitianService.ReadbooksUpdate(dietitianService));
	    	}catch(ServiceException e){
	    		e.printStackTrace();
	    		fail();
	    	}
	    }

	    //null value
	    
	    @Test
	    public void testNullValue() {
	        DietitianService readbooksService = new DietitianService();
	        dietitian dietitianService = new Dietitian();
	        try {
	    		assertTrue(dietitianService.DietitianUpdate(dietitianService));
	    	}catch(ServiceException e){
	    		e.printStackTrace();
	    		fail();
	    	}
	    }
	    
	    
	    // invalid book name 
	    
	    @Test
	    public void testInavlidBookName() {
	        DietitianService readbooksService = new DietitianService();
	        dietitian readbooks = new  Dietitian(40, "dum@hh", "imagelink-url", "pdf-link-url", "TRILLER");
	        try {
	    		assertTrue(dietitianService.ReadbooksUpdate(dietitianService));
	    	}catch(ServiceException e){
	    		e.printStackTrace();
	    		fail();
	    	}
	    }








}
