package com.fssa.wellnessdiet.service;

import java.util.List;

import com.fssa.wellnessdiet.service.exception.ServiceException;
import com.fssa.wellnessdiet.dao.AppoinmentDAO;
import com.fssa.wellnessdiet.dao.UserDAO; 
import com.fssa.wellnessdiet.dao.exception.DAOException;
import com.fssa.wellnessdiet.model.Appoinment;
import com.fssa.wellnessdiet.model.User;
import com.fssa.wellnessdiet.validation.UserValidator;

public class AppointmentService {

	public boolean addAppointment(Appoinment appointment) throws DAOException {
		AppoinmentDAO appointmentDAO = new AppoinmentDAO();

		return appointmentDAO.addAppointment(appointment.getPatientName(), appointment.getEmail()
				, appointment.getProblem(), appointment.getBranch(), appointment.getDate(),appointment.getStatus());
	}

	public static boolean loginUser(String email, String password) throws ServiceException {
		UserDAO userdao = new UserDAO(); 

		try {
			UserValidator.validateEmail(email);
			UserValidator.validatePassword(password);
			User user = userdao.findUserByEmail(email);
			if (user.getPassword().equals(password)) {

				System.out.println("Login successful");
				return true;
			} else {
				return false;
			}

		} catch (DAOException e) {

			throw new ServiceException(e);
		}
	}

	public static List<Appoinment> getAllAppointment() throws ServiceException {

		AppoinmentDAO appoinmentDAO = new AppoinmentDAO();
		List<Appoinment> appoinment = null;
		try {
			appoinment = appoinmentDAO.getAllAppointment();

		} catch (DAOException e) {

			e.printStackTrace();
		}
		return appoinment;
	}
	
	public static Appoinment getAllAppointmentById(String email) throws ServiceException {

		AppoinmentDAO appoinmentDAO = new AppoinmentDAO();
	Appoinment appoinment = null;
		try {
			appoinment = appoinmentDAO.getAppointmentById(email); 

		} catch (DAOException e) {

			e.printStackTrace();
		}
		return appoinment;
	}

}
