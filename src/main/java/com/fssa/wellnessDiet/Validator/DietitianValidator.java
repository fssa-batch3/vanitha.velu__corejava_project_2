package com.fssa.wellnessDiet.Validator;

import java.util.regex.Pattern;

import com.fssa.wellnessDiet.Validator.exception.InvalidDietitianException;
import com.fssa.wellnessDiet.model.Dietitian;

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
        String regex = "^[A-Za-z0-9\\s]{3,50}$";
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

public static boolean validateExperience(String exp) {
    //  experience validation
    return true; 
}

}
