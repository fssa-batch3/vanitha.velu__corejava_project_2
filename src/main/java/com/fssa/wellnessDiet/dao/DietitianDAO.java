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
					"243@Vanitha");
		} catch (SQLException | ClassNotFoundException e) {
		
			e.printStackTrace();
		} 
		return connection; 
	}


	/**
     * Adds a new dietitian to the database.
     *
     * @param dietitian The Dietitian object to be added to the database.
     * @return true if the dietitian is successfully added, false otherwise.
     * @throws DAOException If a database error occurs.
     */
	
	public boolean AddDietitian(Dietitian dietitian) throws DAOException { 
		

		// Prepare SQL Statement
		String insertQuery = "INSERT INTO dietitians (DietitianName,image_url,DietitianAddress,DietitianQualification,DietitianExperience,user_id) VALUES (?,?,?,?,?,?);";
		// Get Connection
		try (Connection connection = getConnection();
				
		    PreparedStatement pst = connection.prepareStatement(insertQuery);) { 
			pst.setString(1, dietitian.getDietitianName());
			pst.setString(2, dietitian.getDietitianUrl());
			pst.setString(3, dietitian.getDietitianAddress()); 
			pst.setString(4, dietitian.getDietitianQualification());
			pst.setInt(5, dietitian.getDietitianExperience());
			pst.setInt(6, dietitian.getCreatedUser());
			// Execute update
			int rows = pst.executeUpdate();

			// Return Successful or not
			return (rows == 1); 
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	
	
	/**
     * Reads dietitian information from the database based on the provided Dietitian object.
     *
     * @param dietitian2 The Dietitian object with criteria for reading.
     * @return A List of Dietitian objects that match the criteria.
     * @throws DAOException If a database error occurs.
     */
	@SuppressWarnings("unused")
	public List<Dietitian> ReadDietitian(Dietitian dietitian2) throws DAOException {
	

		String insertQuery = "SELECT * FROM  dietitians WHERE DietitianEmail = ?";
		UserDAO userDao = new UserDAO();

		List<Dietitian> dietitian = new ArrayList<>();

		Connection connection = getConnection();
		return dietitian;

	}


	/**
     * Updates an existing dietitian's information in the database.
     *
     * @param dietitian The Dietitian object with updated information.
     * @return true if the dietitian is successfully updated, false otherwise.
     * @throws DAOException If a database error occurs.
     */
	
	public static boolean UpdateDietitian(Dietitian dietitian) throws DAOException {
	
		// Prepare SQL Statement
		String insertQuery = "UPDATE dietitians SET DietitianName=? ,image_url=?,DietitianAddress=?, DietitianQualification=?, DietitianExperience=? WHERE dietitian_id=?;";

		try {
			Connection connection = getConnection();
			PreparedStatement pst = connection.prepareStatement(insertQuery);
 
			
			pst.setString(1, dietitian.getDietitianName()); 
			pst.setString(2, dietitian.getDietitianUrl());
			pst.setString(3, dietitian.getDietitianAddress());
			pst.setString(4, dietitian.getDietitianQualification());
			pst.setInt(5, dietitian.getDietitianExperience());
			pst.setInt(6, dietitian.getdietitian_id());
	
		

			// Execute query
			int rows = pst.executeUpdate(); 

			// Return Successful or not
			return rows > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}

	
	/**
     * Deletes a dietitian from the database.
     *
     * @param dietitian The Dietitian object to be deleted.
     * @return true if the dietitian is successfully deleted, false otherwise.
     * @throws DAOException If a database error occurs.
     */
	
	public boolean DeleteDietitian(Dietitian dietitian) throws DAOException {
		// Get Connection
		Connection connection = getConnection();

		// Prepare SQL Statement
		String insertQuery = "Delete from dietitians WHERE dietitian_id=?;";

		try {
			PreparedStatement pst = connection.prepareStatement(insertQuery);
			pst.setInt(1, dietitian.getdietitian_id());
			// Execute query
			int rows = pst.executeUpdate();

			// Return Successful or not
			return (rows == 1);
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return false;

	}

	
	
	/**
     * Retrieves a list of all dietitians from the database.
     *
     * @return A List of Dietitian objects representing all dietitians in the database.
     * @throws DAOException If a database error occurs.
     */

	public List<Dietitian> getAllDietitians() throws DAOException {  
		// Create an empty list to store dietitians
		List<Dietitian> dietitianList = new ArrayList<>();

		final String QUERY = "SELECT dietitian_id, DietitianName,image_url,DietitianAddress, DietitianQualification,DietitianExperience FROM dietitians";
		// Start a try block with a prepared statement for selecting all dietitians
		try (Connection connection = getConnection();
				PreparedStatement pmt = connection.prepareStatement(QUERY);
				ResultSet rs = pmt.executeQuery()) {
			// Iterate through the result set and extract dietitian information
			while (rs.next()) {
				String DietitianName = rs.getString("DietitianName");
				String image_url = rs.getString("image_url"); 
				String DietitianAddress = rs.getString("DietitianAddress");
				String DietitianQualification = rs.getString("DietitianQualification");  
				int  Experience = rs.getInt("DietitianExperience");  
				

				dietitianList.add(new Dietitian(image_url,DietitianName,DietitianQualification,DietitianAddress,Experience));   
				System.out.println(dietitianList.toString());

			}
			// Return the list of dietitians
			return dietitianList;

		} catch (SQLException e) {
			throw new DAOException("Error in getting All dietitians");
					
		}
	}
		
		public static Dietitian findDietitianById(int dietitian_id) throws DAOException { 
			Dietitian dietitian = new Dietitian(); 
			String insertQuery = "SELECT * FROM dietitian WHERE dietitian_id=?"; 
			try (

					Connection connection = getConnection();
					PreparedStatement pst = connection.prepareStatement(insertQuery)) {
				 pst.setInt(1, dietitian_id);  
				ResultSet rs = pst.executeQuery();   
				if (rs.next()) {
					dietitian.setDietitianUrl(rs.getString("imageUrl")); 
					dietitian.setdietitian_id(rs.getInt("dietitian_id"));
					dietitian.setDietitianName(rs.getString("DietitianName"));
					dietitian.setDietitianAddress(rs.getString("DietitianAddress"));
					dietitian.setDietitianQualification(rs.getString("DietitianQualification"));
					dietitian.setDietitianExperience(rs.getInt("DietitianExperience"));
 
				}
				return dietitian; 
			} catch (SQLException e) {
				throw new DAOException("Cannot find dietitian by ID");

			}
		

	}
		
		public static Dietitian findDietitianByUserId(int userId) throws DAOException { 
			Dietitian dietitian = new Dietitian(); 
			String insertQuery = "SELECT * FROM dietitians WHERE user_id=?"; 
			try (

					Connection connection = getConnection();
					PreparedStatement pst = connection.prepareStatement(insertQuery)) {
				 pst.setInt(1, userId);  
				ResultSet rs = pst.executeQuery();   
				if (rs.next()) {
					dietitian.setDietitianUrl(rs.getString("image_url")); 
					dietitian.setdietitian_id(rs.getInt("dietitian_id"));
					dietitian.setDietitianName(rs.getString("DietitianName"));
					dietitian.setDietitianAddress(rs.getString("DietitianAddress"));
					dietitian.setDietitianQualification(rs.getString("DietitianQualification"));
					dietitian.setDietitianExperience(rs.getInt("DietitianExperience"));
 
				}
				return dietitian; 
			} catch (SQLException e) {
				throw new DAOException("Cannot find dietitian by ID");

			}
		

	}

}