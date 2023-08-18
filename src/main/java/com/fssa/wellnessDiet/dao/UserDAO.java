package com.fssa.wellnessDiet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.fssa.wellnessDiet.dao.exception.DAOException;
import com.fssa.wellnessDiet.model.User;
import com.fssa.wellnessDiet.validation.exception.InvalidUserException; 


public class UserDAO {
	
	public Connection getConnection() throws SQLException{
		Connection connect = null ;
        String url = "jdbc:mysql://localhost/project";
        String userName = "root";
        String passWord = "24@manojkumar";
        try {
            connect = DriverManager.getConnection(url,userName, passWord); 
        } catch (Exception e) {
            e.printStackTrace();
            throw new SQLException("Unable to connect to the database");
        }
        return  connect ;
	}
	 
	
	
	public boolean insertUser(User user) throws DAOException {
		String insertQuery = "INSERT INTO user (username , email , password) VALUES (?,?,?)";
		try (
		Connection connection = getConnection();
		PreparedStatement pst = connection.prepareStatement(insertQuery);
				){
		pst.setString(1, user.getUsername()); 
		pst.setString(2, user.getEmail());
		pst.setString(3, user.getPassword());
		int rows = pst.executeUpdate();
		return (rows == 1); }
		catch (SQLException e ) {
			throw new DAOException("Invalid details for register");
		}
	}
	
	
	public  User findUserByEmail(String email) throws  DAOException {
		User user = new User();
		String insertQuery = "SELECT * FROM user WHERE email=?";
		try (
			
		Connection connection = getConnection();
		PreparedStatement pst = connection.prepareStatement(insertQuery)){
		pst.setString(1, email);
		ResultSet rs = pst.executeQuery();
		if(rs.next()){
            user.setEmail(rs.getString("email"));
            user.setPassword(rs.getString("password"));
         
                   }
        return user;
		} catch (SQLException e) {
			throw new DAOException("Cannot find email by user");
			
		}
	}
	
	
	public  boolean emailAlreadyExists(String email) throws  InvalidUserException {
		String insertQuery = "SELECT * FROM user WHERE email=?";
		try (
		Connection connection = getConnection();
		PreparedStatement pst = connection.prepareStatement(insertQuery)){
		pst.setString(1, email);
		ResultSet rs = pst.executeQuery();
		 return  rs.next();
		} catch (SQLException e) {
			throw new InvalidUserException("Invalid in Email Already Exists");
			
		}
	}
	
	public  boolean setLoggedIn(String email) throws InvalidUserException {
		
		String insertQuery = "UPDATE user SET logged_in ='1' WHERE email=?";
		try (
		Connection connection = getConnection();
		PreparedStatement pst = connection.prepareStatement(insertQuery)){
		pst.setString(1, email);
		int count  = pst.executeUpdate();
		 return (count==1);
		} catch (SQLException e) {
			throw new InvalidUserException("Invalid in logging In");
		}
		
	}

}








