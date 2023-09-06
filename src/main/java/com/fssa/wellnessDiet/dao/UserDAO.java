package com.fssa.wellnessDiet.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import com.fssa.wellnessDiet.dao.*;
import com.fssa.wellnessDiet.model.User;
import com.fssa.wellnessDiet.validation.exception.InvalidUserException;
import com.fssa.wellnessDiet.dao.exception.*;

public class UserDAO {

	public Connection getConnection() throws SQLException {

		String dbUrl;
		String dbUser;
		String dbPassword;

//		dbUrl = System.getenv("DB_URL");
//		dbUser = System.getenv("DB_USER");
//		dbPassword = System.getenv("DB_PASSWORD");

		dbUrl = "jdbc:mysql://localhost:3306/web_project";
		dbUser = "root";
		dbPassword = "24@manojkumar";

		Connection connect = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connect = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
		} catch (Exception e) {
			e.printStackTrace();
			throw new SQLException("Unable to connect to the database"); 
		}
		return connect;
	}

	public boolean insertUser(User user) throws DAOException {
		String insertQuery = "INSERT INTO user (username , email , password) VALUES (?,?,?)";
		try (Connection connection = getConnection();
				PreparedStatement pst = connection.prepareStatement(insertQuery);) {
			pst.setString(1, user.getUsername());
			pst.setString(2, user.getEmail());
			pst.setString(3, user.getPassword());
			int rows = pst.executeUpdate();
			return (rows >= 1);
		} catch (SQLException e) {
			throw new DAOException("Invalid details for register");
		}
	}



	public User findUserByEmail(String email) throws DAOException {
		User user = new User();
		String insertQuery = "SELECT * FROM user WHERE email=?";
		try (

				Connection connection = getConnection();
				PreparedStatement pst = connection.prepareStatement(insertQuery)) {
			pst.setString(1, email);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));

			}
			return user;
		} catch (SQLException e) {
			throw new DAOException("Cannot find email by user");

		}
	}

	public boolean emailAlreadyExists(String email) throws InvalidUserException {
		String insertQuery = "SELECT * FROM user WHERE email=?";
		try (Connection connection = getConnection();
				PreparedStatement pst = connection.prepareStatement(insertQuery)) {
			pst.setString(1, email);
			ResultSet rs = pst.executeQuery();
			return rs.next();
		} catch (SQLException e) {
			throw new InvalidUserException("Invalid in Email Already Exists");

		}
	}

	public boolean setLoggedIn(String email) throws InvalidUserException {

		String insertQuery = "UPDATE user SET logged_in ='1' WHERE email=?";
		try (Connection connection = getConnection();
				PreparedStatement pst = connection.prepareStatement(insertQuery)) {
			pst.setString(1, email);
			int count = pst.executeUpdate();
			return (count == 1);
		} catch (SQLException e) {
			throw new InvalidUserException("Invalid in logging In");
		}

	}


		
		
		public List<User> getAllUsers() throws DAOException { 
			// Create an empty list to store products
			List<User> user = new ArrayList<>();

			final String QUERY = "SELECT user_id, username,email, password FROM user";
			// Start a try block with a prepared statement for selecting all products
			try (Connection connection = getConnection();
					PreparedStatement pmt = connection.prepareStatement(QUERY);
					ResultSet rs = pmt.executeQuery()) {
				// Iterate through the result set and extract product information
				while (rs.next()) {
					int userId = rs.getInt("user_id");
					String username = rs.getString("username");
					String email = rs.getString("email");
					String password = rs.getString("password"); 
			
					User user1 = new User();
					user1.setUserId(userId);

					user.add(new User(username, email, password,userId));  

				}
				// Return the list of products
				return user;

			} catch (SQLException e) {
				throw new DAOException("Error in getting All Users");
						
			}

		}
	}


