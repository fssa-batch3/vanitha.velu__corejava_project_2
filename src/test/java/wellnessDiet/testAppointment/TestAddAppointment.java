package wellnessDiet.testAppointment;	
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Date;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.fssa.wellnessDiet.dao.AppoinmentDAO;
import com.fssa.wellnessDiet.model.Appoinment;
import com.fssa.wellnessDiet.service.AppointmentService;
import com.fssa.wellnessDiet.service.exception.ServiceException; 

class TestAddAppointment {

@Test 
	 
void testCreateAppointment() {  
    try {
        AppoinmentDAO appointmentDAO = new AppoinmentDAO(); // Create a valid instance of AppoinmentDAO
        AppointmentService appointmentService = new AppointmentService();

        LocalDate localDate = LocalDate.of(2023, 9, 21);  
        Date sqlDate = Date.valueOf(localDate);

        Appoinment appointment = new Appoinment("Nithya", "nithi@gmail.com", 
                 "weightloss", "OMR", sqlDate,"confirmed");
        
        boolean result = appointmentService.addAppointment(appointment); 
         
        assertTrue(result, "Appointment Booked successfully");
    } catch (Exception e) {
        fail(e.getMessage());
    }
}


@Test


void testInvalidEmailandPassword() { 
	try {
		assertFalse(AppointmentService.loginUser("vanitha#gmail.com", "vanitha@123"));
	} catch (ServiceException e) {
	
		e.printStackTrace();
	}

}

@Test 
void testInvalidName() { 
    try {
    	AppoinmentDAO appointmentDAO = new AppoinmentDAO(); // Create a valid instance of AppoinmentDAO
        AppointmentService appointmentService = new AppointmentService();        
        LocalDate localDate = LocalDate.of(2023, 9, 21);
        Date sqlDate = Date.valueOf(localDate);


       
        Appoinment appointment = new Appoinment("yt", "vani@gmail.com", 
               "weightGain", "OMR", sqlDate , "cancel");
        
        boolean result = appointmentService.addAppointment(appointment);
        
        assertFalse(result, "User name is invalid");
    } catch (Exception e) {
        fail(e.getMessage());
    }
}

//void testInvalidAddress() { 
//    try {
//    	AppoinmentDAO appointmentDAO = new AppoinmentDAO(); // Create a valid instance of AppoinmentDAO
//        AppointmentService appointmentService = new AppointmentService();
//        
//        LocalDate localDate = LocalDate.of(2023, 9, 21);
//        Date sqlDate = Date.valueOf(localDate);
//
//        Appoinment appointment = new Appoinment("vanitha", "vani@gmail.com", 
//                "", "weightGain", "OMR", sqlDate);
//        
//        boolean result = appointmentService.addAppointment(appointment);
//        
//        assertFalse(result, "invalid address");
//    } catch (Exception e) {
//        fail(e.getMessage());
//    }
//}


@Test 
void testInvalidDate() { 
    try {
    	AppoinmentDAO appointmentDAO = new AppoinmentDAO(); // Create a valid instance of AppoinmentDAO
        AppointmentService appointmentService = new AppointmentService();
        
        LocalDate localDate = LocalDate.of(2023, 9, 21);
        Date sqlDate = Date.valueOf(localDate);

        Appoinment appointment = new Appoinment("vanitha", "vani@gmail.com", 
                 "weightGain", "OMR", sqlDate,"cancel");
        
        boolean result = appointmentService.addAppointment(appointment);
        
        assertFalse(result, "invalid date");
    } catch (Exception e) {
        fail(e.getMessage());
    }
}

}

