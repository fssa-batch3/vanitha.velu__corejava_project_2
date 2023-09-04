package com.fssa.wellnessDiet.service;

import java.util.List;

import com.fssa.wellnessDiet.dao.DietitianDAO;
import com.fssa.wellnessDiet.dao.exception.DAOException;
import com.fssa.wellnessDiet.model.Dietitian;
import com.fssa.wellnessDiet.validation.DietitianValidator;
import com.fssa.wellnessDiet.validation.exception.InvalidDietitianException;
import com.fssa.wellnessDiet.service.exception.ServiceException;

public class DietitianService {

	public boolean addDietitian(Dietitian dietitian) throws ServiceException {
		DietitianDAO dietitianDao = new DietitianDAO();

		try {
			if (dietitianDao.AddDietitian(dietitian)) {
				return true;
			} else {
				return false;
			}
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	
	@SuppressWarnings("static-access")
	public static boolean updateDietitian(Dietitian dietitian) throws ServiceException {
		DietitianDAO dietitianDAO = new DietitianDAO();

		try {
			if (dietitianDAO.UpdateDietitian(dietitian)) {
				System.out.println("Successfully updated");
				return true;
			} else {
				return false;
			}
		} catch (DAOException e) {
			throw new ServiceException(e);
		}

	}

	// delete Dietitian
	public static boolean deleteDietitian(Dietitian dietitian) throws ServiceException {
		DietitianDAO dietitianDAO = new DietitianDAO();

		try {
			if (dietitianDAO.DeleteDietitian(dietitian)) {
				System.out.println("Successfully deleted");
				return true;
			} else {
				return false;
			}
		} catch (DAOException e) {
			throw new ServiceException(e);
		}

	}

//read Dietitian
	
	@SuppressWarnings("static-access")
	public static List<Dietitian>  readDietitian(Dietitian dietitian) throws ServiceException {
		List<Dietitian> dietitians = null;
		try {
			DietitianDAO dietitianDAO = new DietitianDAO();
			dietitians = dietitianDAO.ReadDietitian(dietitian);
			DietitianValidator validate = new DietitianValidator();
			for (Dietitian diet : dietitians) {
				if (!(validate.ValidateDietitian(diet))) {
					throw new ServiceException("Failed to get Dieitian");
				}
			}
			
		} catch (DAOException | InvalidDietitianException e) {
			throw new ServiceException(e);
		}
		return dietitians;
	}

}
