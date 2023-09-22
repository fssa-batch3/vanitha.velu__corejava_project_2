package com.fssa.wellnessDiet.service;

import java.util.List;

import com.fssa.wellnessDiet.dao.DietitianDAO;
import com.fssa.wellnessDiet.dao.exception.DAOException;
import com.fssa.wellnessDiet.model.Dietitian;
import com.fssa.wellnessDiet.validation.DietitianValidator;
import com.fssa.wellnessDiet.validation.exception.InvalidDietitianException;
import com.fssa.wellnessDiet.service.exception.ServiceException;

public class DietitianService {

	/**
	 * Adds a new dietitian to the database.
	 *
	 * @param dietitian The Dietitian object to be added.
	 * @return true if the dietitian is successfully added, false otherwise.
	 * @throws ServiceException If a service-level error occurs.
	 */
	
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

	
	
	/**
	 * Updates an existing dietitian's information in the database.
	 *
	 * @param dietitian The Dietitian object with updated information.
	 * @return true if the dietitian is successfully updated, false otherwise.
	 * @throws ServiceException If a service-level error occurs.
	 */
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

	
	/**
	 * Deletes a dietitian from the database.
	 *
	 * @param dietitian The Dietitian object to be deleted.
	 * @return true if the dietitian is successfully deleted, false otherwise.
	 * @throws ServiceException If a service-level error occurs.
	 */
	
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


	/**
	 * Reads dietitian information from the database based on the provided Dietitian object.
	 *
	 * @param dietitian The Dietitian object with criteria for reading.
	 * @return A List of Dietitian objects that match the criteria.
	 * @throws ServiceException If a service-level error occurs, including validation failures.
	 */
	
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
	
	
	
	/**
	 * Retrieves a list of all dietitians from the database.
	 *
	 * @return A List of Dietitian objects representing all dietitians in the database.
	 * @throws ServiceException If a service-level error occurs.
	 */
	
	public List<Dietitian> getAllDietitian() throws ServiceException {

		DietitianDAO dietitianDAO = new DietitianDAO();
		List<Dietitian> dietitian = null;
		try {
			dietitian = dietitianDAO.getAllDietitians();
			
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dietitian; 
	}



	public Dietitian findDietitianById(int dietitian_id) throws ServiceException {
	    try {
	    	DietitianDAO DietitianDAO = new DietitianDAO();
	    	Dietitian Dietitian = DietitianDAO.findDietitianById(dietitian_id);  

	        if (Dietitian != null) {  
	            return Dietitian;
	        } else { 
	            System.err.println("Dietitian not found");
	            return null;
	        }
	    } catch (DAOException e) {
	        throw new ServiceException(e);
	    }
	}
	
	
	public Dietitian findDietitianByUserId(int userId) throws ServiceException {
	    try {
	    	DietitianDAO DietitianDAO = new DietitianDAO();
	    	Dietitian Dietitian = DietitianDAO.findDietitianByUserId(userId);  

	        if (Dietitian != null) {  
	            return Dietitian;
	        } else { 
	            System.err.println("Dietitian not found");
	            return null;
	        }
	    } catch (DAOException e) {
	        throw new ServiceException(e);
	    }
	}


}
