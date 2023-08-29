package com.fssa.wellnessDiet.service;

import java.sql.SQLException;

import com.fssa.wellnessDiet.model.Dietitian;
import com.fssa.wellnessDiet.model.User;
import com.fssa.wellnessDiet.service.exception.ServiceException;
import com.fssa.wellnessDiet.validation.DietitianValidator;
import com.fssa.wellnessDiet.validation.UserValidator;
import com.fssa.wellnessDiet.validation.exception.InvalidUserException;
import com.fssa.wellnessDiet.dao.*;
import com.fssa.wellnessDiet.dao.exception.DAOException;

public class DietitianService {

    public boolean addDietitian(Dietitian dietitian) throws ServiceException, InvalidUserException, SQLException {
        DietitianDAO dietitianDao = new DietitianDAO();
        
        try {
            if(dietitianDao.AddDietitian(dietitian)) {
                return true;
            } else {
                return false;
            }
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}


	
	
