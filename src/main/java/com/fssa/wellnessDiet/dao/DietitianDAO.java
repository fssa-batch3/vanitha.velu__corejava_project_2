package com.fssa.wellnessDiet.dao;

import com.fssa.wellnessDiet.model.*;
import com.fssa.wellnessDiet.dao.*;
import com.fssa.wellnessDiet.dao.exception.DAOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.*;

import com.fssa.wellnessDiet.model.Dietitian;

public class DietitianDAO {
	
	 private static final Object UserId = null;

	//connect to database
		public Connection getConnection() throws SQLException {
		 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/backend", "root","24@manojkumar");
		 return connection;
		}
		
		//add new user to DB - dietitian
		public boolean AddDietitian(Dietitian dietitian) throws SQLException { 
			//Get Connection
			Connection connection = getConnection();
			
			// Prepare SQL Statement
			String insertQuery = "INSERT INTO dietitian (DietitianName,DietitianQualification,DietitianAddress,DietitianExperience) VALUES (?,?,?,?);";
			PreparedStatement pst = connection.prepareStatement(insertQuery); 
			
			pst.setString(1, dietitian.getDietitianName());
			pst.setString(2, dietitian.getDietitianQualification());
			pst.setString(3, dietitian.getDietitianAddress());
			pst.setString(4, dietitian.getDietitianExperience());
			//Execute query
			int rows = pst.executeUpdate();
			
			//Return Successful or not
			return (rows == 1);
		}
		
		//Read
		public boolean ReadDietitian(Dietitian dietitian) throws DAOException {
			//Get Connection


			String insertQuery = "SELECT * FROM  dietitianuser WHERE id = ?";
			UserDAO  userDao = new UserDAO();
			try (
					
				Connection connection = userDao.getConnection();
				PreparedStatement pst = connection.prepareStatement(insertQuery)){
				pst.setInt(1, dietitian.getUserID()); 
				StringBuilder str = new StringBuilder(); 
				ResultSet rs = pst.executeQuery();
				while (rs.next()) {
					  String DietitianName = rs.getString("name");
					  String DietitianQualification = rs.getString("specialist");
					  int DietitianExperience = rs.getInt("experience");
					  String DietitianAddress = rs.getString("address");
			          
			          
			          str.append("Name: ").append(DietitianName).append(", User ID: ").append(UserId).append(",DietitianQualification  ").append(DietitianQualification).append(", DietitianExperience ").append(DietitianExperience).append(", DietitianAddress ").append(DietitianAddress);
						
			          System.out.println(str);
			 
				}
				return true;
			} catch (SQLException e) {
				throw new DAOException(e); 
			}
		}	
		
		
		
		//update medicine 
		public boolean UpdateMedicine(Dietitian dietitian) throws SQLException {
			//Get Connection
			Connection connection = getConnection();
			
			// Prepare SQL Statement
			String insertQuery = "Update Dietitian SET Dietitian_name=? , Dietitian_qualification=? , Dietitian_experience=?, Dietitian_address=? WHERE id=?;";
			PreparedStatement pst = connection.prepareStatement(insertQuery);
			
 	        pst.setString(1, dietitian.getDietitianName());
			pst.setString(2, dietitian.getDietitianQualification());
			pst.setString(3, dietitian.getDietitianAddress());
			pst.setString(4, dietitian.getDietitianExperience());
			//Execute query
			int rows = pst.executeUpdate();
			
			//Return Successful or not
			return (rows == 1);
		}
		
		//delete 
		public boolean DeleteDietitian(Dietitian dietitian) throws SQLException { 
			//Get Connection
			Connection connection = getConnection();
			
			// Prepare SQL Statement
			String insertQuery = "Delete from Dietitian WHERE id=?;";
			PreparedStatement pst = connection.prepareStatement(insertQuery);

			pst.setInt(1, dietitian.getUserID());
			//Execute query
			int rows = pst.executeUpdate();
			
			//Return Successful or not
			return (rows == 1);
		}

		public boolean UpdateDietitian(Dietitian dietitian) {
			// TODO Auto-generated method stub
			return false;
		}
}