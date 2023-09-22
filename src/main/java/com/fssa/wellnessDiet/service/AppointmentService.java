package com.fssa.wellnessDiet.service;

import com.fssa.wellnessDiet.*;

import java.util.List;
import java.util.function.BooleanSupplier;
import com.fssa.wellnessDiet.dao.*;
import com.fssa.wellnessDiet.dao.exception.DAOException;
import com.fssa.wellnessDiet.service.*;
import com.fssa.wellnessDiet.service.exception.ServiceException;
import com.fssa.wellnessDiet.model.*;
import com.fssa.wellnessDiet.validation.*;
import com.fssa.wellnessDiet.validation.exception.InvalidDietitianException;

public class AppointmentService {

	public boolean addAppointment(Appoinment appointment) throws DAOException {
		AppoinmentDAO appointmentDAO = new AppoinmentDAO();

		return appointmentDAO.addAppointment(appointment.getPatientName(), appointment.getEmail(),
				appointment.getAddress(), appointment.getProblem(), appointment.getBranch(), appointment.getDate());
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

}
