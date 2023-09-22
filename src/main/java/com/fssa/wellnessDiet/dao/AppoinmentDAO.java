package com.fssa.wellnessDiet.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fssa.wellnessDiet.dao.exception.DAOException;
import com.fssa.wellnessDiet.model.Appoinment;
import com.fssa.wellnessDiet.model.Dietitian;

public class AppoinmentDAO {

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
		
public boolean addAppointment(String patientName, String email, String address, String problem, String branch, Date date) throws DAOException {


    String INSERT_APPOINTMENT = "INSERT INTO appointments (patient_name, email, address, problem, branch, date_time) VALUES (?, ?, ?, ?, ?, ?)";
 
    try (Connection connection = getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement(INSERT_APPOINTMENT)) {
        preparedStatement.setString(1, patientName);
        preparedStatement.setString(2, email);
        preparedStatement.setString(3, address);
        preparedStatement.setString(4, problem);
        preparedStatement.setString(5, branch);
        preparedStatement.setDate(6, date); 

        int rowsAffected = preparedStatement.executeUpdate();
        return rowsAffected > 0; 
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}


public List<Appoinment> getAllAppointment() throws DAOException {    
	// Create an empty list to store dietitians 
	List<Appoinment> appointmentList = new ArrayList<>();

	final String QUERY = "SELECT patient_name, email, address, problem, branch, date_time FROM appointments";
	// Start a try block with a prepared statement for selecting all dietitians
	try (Connection connection = getConnection();
			PreparedStatement pmt = connection.prepareStatement(QUERY);
			ResultSet rs = pmt.executeQuery()) {
		// Iterate through the result set and extract dietitian information
		while (rs.next()) {
			String patientName = rs.getString("patient_name");
			String email = rs.getString("email"); 
			String address = rs.getString("address");
			String problem = rs.getString("problem");
			String branch = rs.getString("branch");   
			Date  date = rs.getDate("date_time");        
			 

			appointmentList.add(new Appoinment(patientName,email,address,problem,branch,date));     
			System.out.println(appointmentList.toString());  

		}
		// Return the list of dietitians 
		return appointmentList;

	} catch (SQLException e) {
		throw new DAOException("Error in getting All Appointments");
				
	}
}

public List<Appoinment> readAppoinment(Appoinment appoinment) throws DAOException {   
	

	String insertQuery = "SELECT * FROM  appointments WHERE id = ?"; 
	AppoinmentDAO appoinmentDAO = new AppoinmentDAO(); 

	List<Appoinment> Appoinment = new ArrayList<>();

	Connection connection = getConnection(); 
	return Appoinment;

}



}
