package wellnessDiet3.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import wellnessDiet3.model.User;

public class UserDAO {

	
	 //connect to database
	public Connection getConnection() throws SQLException {
	 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root","24@manojkumar");
	 return connection;
	}
	
	boolean match = false;
//	Get user from DB - Login
   public boolean login(User user) throws SQLException {
		
	   
	   Connection connection = getConnection();
	   
	   String selectQuery = "SELECT * FROM user WHERE email = ?";
	   PreparedStatement pst = connection.prepareStatement(selectQuery);
	   pst.setString(1, user.email);
	   ResultSet resultSet = pst.executeQuery();
	   
	   while (resultSet.next()) {
		   String emailID = resultSet.getString("email");
		   String Password = resultSet.getString("password");
		   
		   System.out.println("Email: " + emailID + " Password: " + Password);
		   
		   if(user.getEmail().equals(emailID) && user.getPassword().equals(Password)) {
			   match = true;
		   }
	   }
	   return match;
	}
	
	//add new user to DB - Register
	public boolean register(User user) throws SQLException {
		//Get Connection
		Connection connection = getConnection();
		
		// Prepare SQL Statement
		String insertQuery = "INSERT INTO user (username,email,password) VALUES (?,?,?);";
		PreparedStatement pst = connection.prepareStatement(insertQuery);
		pst.setString(1, user.getUsername());
		pst.setString(2, user.getEmail());
		pst.setString(3, user.getPassword());
		//Execute query
		int rows = pst.executeUpdate();
		
		//Return Successful or not
		return (rows == 1);
	}
}
