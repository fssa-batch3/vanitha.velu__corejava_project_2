package wellnessDiet.testDietian;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;
import com.fssa.wellnessDiet.service.*;
import com.fssa.wellnessDiet.model.*;
import com.fssa.wellnessDiet.service.exception.ServiceException;
import com.fssa.wellnessDiet.validation.exception.InvalidUserException;

public class TestCreateDietitian {
	@Test
	
	//valid test case
	public void testCreateProduct() throws InvalidUserException, SQLException {
		DietitianService DietitianService = new DietitianService();
		Dietitian Dietitian = new Dietitian( "Vanitha","image-Url","vanitha@gmail.com" ,"Gem Hospital,perungudi", "Dietitian", 12);
		
		try {
			assertTrue(DietitianService.addDietitian(Dietitian));
		}catch(ServiceException e){
			e.printStackTrace();
			fail();
		}
	}

	
	//invalid name
	
	public void testInvalidName() throws InvalidUserException, SQLException {
		DietitianService DietitianService = new DietitianService();
		Dietitian Dietitian = new Dietitian( "Vanitaa","image-Url","vanitha@gmail.com" ,"Gem", "Dietitian", 12);
		
		try {
			assertTrue(DietitianService.addDietitian(Dietitian));
		}catch(ServiceException e){
			e.printStackTrace();
			fail();
		}
	}
	
	
	//invalid URL
	
	
	public void testInvalidURL() throws InvalidUserException, SQLException {
		DietitianService DietitianService = new DietitianService();
		Dietitian Dietitian = new Dietitian( "Vanitha","sdfghjkl@","vanitha@gmail.com" ,"Gem", "Dietitian", 12);
		
		try {
			assertTrue(DietitianService.addDietitian(Dietitian));
		}catch(ServiceException e){
			e.printStackTrace();
			fail();
		}
	}
	
	
	//invalid email
	
	public void testInvalidEmail() throws InvalidUserException, SQLException {
		DietitianService DietitianService = new DietitianService();
		Dietitian Dietitian = new Dietitian( "Vanitha","image-Url","vani#mail.com" ,"Gem", "Dietitian", 12);
		
		try {
			assertTrue(DietitianService.addDietitian(Dietitian));
		}catch(ServiceException e){
			e.printStackTrace();
			fail();
		}
	}
	
	
	//Invalid address
	
	public void testInvalidAddress() throws InvalidUserException, SQLException {
		DietitianService DietitianService = new DietitianService();
		Dietitian Dietitian = new Dietitian( "Vanitha","image-Url","vanitha@gmail.com" ,"Gem", "Dietitian", 12);
		
		try {
			assertTrue(DietitianService.addDietitian(Dietitian));
		}catch(ServiceException e){
			e.printStackTrace();
			fail();
		}
	}
	
	
	//Invalid Qualification
	
	public void testInvalidExperience() throws InvalidUserException, SQLException {
		DietitianService DietitianService = new DietitianService();
		Dietitian Dietitian = new Dietitian( "Vanitha","image-Url","vanitha@gmail.com" ,"Gem", "Dietitian", 0);
		
		try {
			assertTrue(DietitianService.addDietitian(Dietitian));
		}catch(ServiceException e){
			e.printStackTrace();
			fail();
		}
	}
	
}
