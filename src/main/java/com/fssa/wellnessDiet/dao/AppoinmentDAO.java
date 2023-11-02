package com.fssa.wellnessdiet.dao; 

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fssa.wellnessdiet.dao.exception.DAOException;
import com.fssa.wellnessdiet.model.Appoinment;

public class AppoinmentDAO {

	// connect to database
		public static Connection getConnection() throws DAOException {
			Connection connection = null;

			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/web_project", "root",
						"243@vanitha");
			} catch (SQLException | ClassNotFoundException e) {
			
				e.printStackTrace();
			} 
			return connection; 
		} 
		
public boolean addAppointment(String patientName, String email, String problem, String branch, Date date,String status) throws DAOException {


    String INSERT_APPOINTMENT = "INSERT INTO appointments (patient_name, email, problem, branch, date_time, status) VALUES (?, ?, ?, ?, ?, ?)";
 
    try (Connection connection = getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement(INSERT_APPOINTMENT)) {
        preparedStatement.setString(1, patientName);
        preparedStatement.setString(2, email);
        preparedStatement.setString(3, problem);
        preparedStatement.setString(4, branch);
        preparedStatement.setDate(5, date); 
        preparedStatement.setString(6, status); 

        int rowsAffected = preparedStatement.executeUpdate();
        return rowsAffected > 0; 
    } catch (SQLException e) {
    	throw new DAOException(e);
    }
}


public List<Appoinment> getAllAppointment() throws DAOException {    
	// Create an empty list to store dietitians 
	List<Appoinment> appointmentList = new ArrayList<>();

	final String QUERY = "SELECT patient_name, email, problem, branch, date_time, status , id FROM appointments";
	// Start a try block with a prepared statement for selecting all dietitians
	try (Connection connection = getConnection();
			PreparedStatement pmt = connection.prepareStatement(QUERY);
			) {
		ResultSet rs = pmt.executeQuery();
		// Iterate through the result set and extract dietitian information
		while (rs.next()) {
			String patientName = rs.getString("patient_name");
			String email = rs.getString("email"); 
			String problem = rs.getString("problem");
			String branch = rs.getString("branch");   
			Date  date = rs.getDate("date_time"); 
			String status = rs.getString("status");
			int id = rs.getInt("id");
			appointmentList.add(new Appoinment(patientName,email,problem,branch,date,status,id));     
			System.out.println(appointmentList);  

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


public Appoinment getAppointmentById(String emailId) throws DAOException {
    final String QUERY = "SELECT patient_name, email, problem, branch, date_time, status FROM appointments WHERE email = ?";
    
    try (Connection connection = getConnection();
         PreparedStatement pmt = connection.prepareStatement(QUERY)) {
        
        pmt.setString(1, emailId);
        ResultSet rs = pmt.executeQuery();
         
        if (rs.next()) {
            String patientName = rs.getString("patient_name");
            String email = rs.getString("email"); 
            String problem = rs.getString("problem");
            String branch = rs.getString("branch");   
            Date date = rs.getDate("date_time"); 
            String status = rs.getString("status");
            
            return new Appoinment(patientName, email, problem, branch, date, status);
        }
    } catch (SQLException e) {
        throw new DAOException("Error in getting Appointment by ID");
    }
    
    return null; // If no appointment found with the given ID
}



}
