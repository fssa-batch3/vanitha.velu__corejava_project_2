package com.fssa.wellnessDiet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fssa.wellnessDiet.dao.exception.DAOException;
import com.fssa.wellnessDiet.model.Dietitian;

public class DietitianDAO {

	@SuppressWarnings("unused")
	private static final Object UserId = null;

	// connect to database
	public static Connection getConnection() throws DAOException {
		Connection connection = null;

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/web_project", "root",
					"24@manojkumar");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	

	// add new user to DB - dietitian
	public boolean AddDietitian(Dietitian dietitian) throws DAOException {
		// Get Connection

		// Prepare SQL Statement
		String insertQuery = "INSERT INTO dietitians (DietitianName,image_url,DietitianEmail,DietitianAddress,DietitianQualification,DietitianExperience) VALUES (?,?,?,?,?,?);";
		try (Connection connection = getConnection();
				PreparedStatement pst = connection.prepareStatement(insertQuery);) {

			pst.setString(1, dietitian.getDietitianName());
			pst.setString(2, dietitian.getDietitianUrl());
			pst.setString(3, dietitian.getDietitianEmail());
			pst.setString(4, dietitian.getDietitianQualification());
			pst.setString(5, dietitian.getDietitianAddress());
			pst.setInt(6, dietitian.getDietitianExperience());
			// Execute query
			int rows = pst.executeUpdate();

			// Return Successful or not
			return (rows == 1);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	// Read
	@SuppressWarnings("unused")
	public List<Dietitian> ReadDietitian(Dietitian dietitian2) throws DAOException {
		// Get Connection

		String insertQuery = "SELECT * FROM  dietitians WHERE DietitianEmail = ?";
		UserDAO userDao = new UserDAO();
		
		List<Dietitian> dietitian = new ArrayList<>();
		
		Connection connection = getConnection();
		return dietitian; 
		
		
		
	}
	// update medicine
	public static boolean UpdateDietitian(Dietitian dietitian) throws DAOException {
		// Get Connection

		// Prepare SQL Statement
		String insertQuery = "UPDATE dietitians SET DietitianName=? , DietitianQualification=?,image_url=?,DietitianEmail=? , DietitianExperience=?,DietitianAddress=? WHERE dietitian_id=?;";

		try {
			Connection connection = getConnection();
			PreparedStatement pst = connection.prepareStatement(insertQuery);
			pst.setString(1, dietitian.getDietitianName());
			pst.setString(2, dietitian.getDietitianQualification());
			pst.setString(3, dietitian.getDietitianUrl());
			pst.setString(4, dietitian.getDietitianEmail());
			pst.setInt(5, dietitian.getDietitianExperience());
			pst.setString(6, dietitian.getDietitianAddress());
			pst.setInt(7, dietitian.getUserID());

			// Execute query
			int rows = pst.executeUpdate();

			// Return Successful or not
			return rows > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}

	// delete
	public boolean DeleteDietitian(Dietitian dietitian) throws DAOException {
		// Get Connection
		Connection connection = getConnection();

		// Prepare SQL Statement
		String insertQuery = "Delete from dietitians WHERE dietitian_id=?;";

		try {
			PreparedStatement pst = connection.prepareStatement(insertQuery);
			pst.setInt(1, dietitian.getUserID());
			// Execute query
			int rows = pst.executeUpdate();

			// Return Successful or not
			return (rows == 1);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return false;

	}

}