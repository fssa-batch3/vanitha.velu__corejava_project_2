package com.fssa.wellnessdiet.validation;

import java.util.regex.Pattern;

import com.fssa.wellnessdiet.model.Dietitian;
import com.fssa.wellnessdiet.validation.exception.InvalidDietitianException;

public class DietitianValidator {
	
	  
	

public static boolean ValidateDietitian(Dietitian dietitian) throws InvalidDietitianException {
    if (dietitian != null && validateName(dietitian.getDietitianName())
            && validateQualification(dietitian.getDietitianQualification())
            && validateAddress(dietitian.getDietitianAddress())
            && validateExperience(dietitian.getDietitianExperience())) {
        return true;
    } else {
        throw new InvalidDietitianException("Dietitian details not valid");
    }
}

public static boolean validateName(String name) {
    boolean match = false;
    try {
        String regex = "^[A-Za-z\\s]{3,50}$";
        match = Pattern.matches(regex, name);
        if (match) {
            System.out.println("The name is valid.");
        } else {
            System.out.println("Name is not valid");
        }
    } catch (Exception e) {
        System.out.println("Name is not valid");
    }
    return match;
}

public static boolean validateQualification(String qualification) {
    boolean match = false;
    try {
        String regex = "^[A-Za-z0-9\\s]{8,50}$";
        match = Pattern.matches(regex, qualification);
        if (match) {
            System.out.println("The qualification is valid.");
        } else {
            System.out.println("Qualification is not valid");
        }
    } catch (Exception e) {
        System.out.println("Qualification is not valid");
    }
    return match;
}

public static boolean validateAddress(String address) {
    boolean match = false;
    try {
        // address validation
        String regex = "^[A-Za-z0-9\\s,.-]{5,100}$";
        match = Pattern.matches(regex, address);
        if (match) {
            System.out.println("The address is valid.");
        } else {
            System.out.println("Address is not valid");
        }
    } catch (Exception e) {
        System.out.println("Address is not valid");
    }
    return match;
}

public static boolean validateExperience(int dietitianExperience) {
    //  experience validation
 
	if (dietitianExperience >= 0 && dietitianExperience <= 100) {
        System.out.println("Dietitian experience is valid."); 
        return true;
    } else { 
        System.out.println("Dietitian experience is not valid.");
        return false;
    }    

}
}


