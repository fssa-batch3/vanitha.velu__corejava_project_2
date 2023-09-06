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
import com.fssa.wellnessDiet.model.User;
import com.fssa.wellnessDiet.service.exception.ServiceException;

public class DietitianDAO {

	


	// connect to database
	public static Connection getConnection() throws DAOException {
		Connection connection = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/web_project", "root",
					"24@manojkumar");
		} catch (SQLException | ClassNotFoundException e) {
		
			e.printStackTrace();
		} 
		return connection;
	}

	// add new user to DB - dietitian
	public boolean AddDietitian(Dietitian dietitian) throws DAOException {
		// Get Connection

		// Prepare SQL Statement
		String insertQuery = "INSERT INTO dietitians (DietitianName,image_url,DietitianAddress,DietitianQualification,DietitianExperience) VALUES (?,?,?,?,?);";
		try (Connection connection = getConnection();
				PreparedStatement pst = connection.prepareStatement(insertQuery);) {
			System.out.print(dietitian.getDietitianName());
			pst.setString(1, dietitian.getDietitianName());
			pst.setString(2, dietitian.getDietitianUrl());
			pst.setString(3, dietitian.getDietitianAddress());
			pst.setString(4, dietitian.getDietitianQualification());
			pst.setInt(5, dietitian.getDietitianExperience());
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


	public static boolean UpdateDietitian(Dietitian dietitian) throws DAOException {
		// Get Connection

		// Prepare SQL Statement
		String insertQuery = "UPDATE dietitians SET DietitianName=? ,image_url=?,DietitianAddress=?, DietitianQualification=?, DietitianExperience=? WHERE dietitian_id=?;";

		try {
			Connection connection = getConnection();
			PreparedStatement pst = connection.prepareStatement(insertQuery);

			pst.setInt(1, dietitian.getUserID());
			pst.setString(2, dietitian.getDietitianName()); 
			pst.setString(3, dietitian.getDietitianUrl());
			pst.setString(4, dietitian.getDietitianAddress());
			pst.setString(5, dietitian.getDietitianQualification());
			pst.setInt(6, dietitian.getDietitianExperience());

	
		

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

	

	public List<Dietitian> getAllDietitians() throws DAOException {  
		// Create an empty list to store products
		List<Dietitian> dietitianList = new ArrayList<>();

		final String QUERY = "SELECT dietitian_id, DietitianName,image_url,DietitianAddress, DietitianQualification,DietitianExperience FROM dietitians";
		// Start a try block with a prepared statement for selecting all products
		try (Connection connection = getConnection();
				PreparedStatement pmt = connection.prepareStatement(QUERY);
				ResultSet rs = pmt.executeQuery()) {
			// Iterate through the result set and extract product information
			while (rs.next()) {
				String DietitianName = rs.getString("DietitianName");
				String image_url = rs.getString("image_url"); 
				String DietitianAddress = rs.getString("DietitianAddress");
				String DietitianQualification = rs.getString("DietitianQualification"); 
				int  Experience = rs.getInt("DietitianExperience");  
				
		
//				Dietitian dietitian = new Dietitian(); 

				dietitianList.add(new Dietitian(image_url,DietitianName,DietitianQualification,DietitianAddress,Experience));   
				System.out.println(dietitianList.toString());

			}
			// Return the list of products
			return dietitianList;

		} catch (SQLException e) {
			throw new DAOException("Error in getting All dietitians");
					
		}

	}

}