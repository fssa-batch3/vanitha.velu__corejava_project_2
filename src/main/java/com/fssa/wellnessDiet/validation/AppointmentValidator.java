package com.fssa.wellnessDiet.validation;
import com.fssa.wellnessDiet.model.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.regex.Pattern;

import com.fssa.wellnessDiet.dao.AppoinmentDAO;
import com.fssa.wellnessDiet.dao.exception.DAOException;
import com.fssa.wellnessDiet.model.Appoinment;

public class AppointmentValidator {
	
	public void validateAppointment(Appoinment appointment) throws DAOException {          
	    String patientName = appointment.getPatientName();
	    String email = appointment.getEmail();
	    String address = appointment.getAddress();
	    String problem = appointment.getProblem();
	    String branch = appointment.getBranch();
	    Date date = appointment.getDate();   
	    
	}  
	    
	    public static boolean validatePatientName(String patientName) {
	        boolean match = false;
	        try {
	            String regex = "^[A-Za-z\\s]{2,50}$"; // Allow letters and spaces, 2 to 50 characters
	            match = Pattern.matches(regex, patientName);
	            if (match) {
	                System.out.println("The patient name is valid.");
	            } else {
	                System.out.println("Patient name is not valid");
	            }
	        } catch (Exception e) {
	     
	        }
	        return match;

	}    
	    
	    public static boolean validateEmail(String email) {
	        boolean match = false;
	        try {
	            String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
	            match = Pattern.matches(regex, email);
	            if (match) {
	                System.out.println("The email is valid.");
	            } else {
	                System.out.println("Email is not valid");
	            }
	        } catch (Exception e) {

	        }
	        return match;
	    }

	    
	    public static boolean validateAddress(String address) {
	        boolean match = false;
	        try {
	            String regex = "^[A-Za-z0-9\\s,.-]{5,100}$"; // Allow letters, digits, spaces, commas, dots, hyphens, 5 to 100 characters
	            match = Pattern.matches(regex, address);
	            if (match) {
	                System.out.println("The address is valid.");
	            } else {
	                System.out.println("Address is not valid");
	            }
	        } catch (Exception e) {
	
	        }
	        return match;
	    }

	    
	    public static boolean validateProblem(String problem) {
	        boolean match = false;
	        try {
	            String regex = "^[A-Za-z\\s]{5,50}$"; // Allow letters and spaces, 5 to 50 characters
	            match = Pattern.matches(regex, problem);
	            if (match) {
	                System.out.println("The problem description is valid.");
	            } else {
	                System.out.println("Problem description is not valid");
	            }
	        } catch (Exception e) {
	         
	        }
	        return match;
	    }

	    
	    public static boolean validateBranch(String branch) {
	        boolean match = false;
	        try {
	            String regex = "^[A-Za-z\\s,.-]{2,50}$"; // Allow letters, spaces, commas, dots, hyphens, 2 to 50 characters
	            match = Pattern.matches(regex, branch);
	            if (match) {
	                System.out.println("The branch is valid.");
	            } else {
	                System.out.println("Branch is not valid");
	            }
	        } catch (Exception e) {
	          
	        }
	        return match;
	    }

	    
	    public static boolean validateDateTime(String date) {
	        boolean match = false;
	        try {
	            String regex = "^\\d{4}-\\d{2}-\\d{2}\\s\\d{2}:\\d{2}:\\d{2}$"; // Date-time format (YYYY-MM-DD HH:MM:SS)
	            match = Pattern.matches(regex, date);
	            if (match) {
	                System.out.println("The date-time is valid.");
	            } else {
	                System.out.println("Date-time is not valid");
	            }
	        } catch (Exception e) {
	          
	        }
	        return match;
	    }

}
