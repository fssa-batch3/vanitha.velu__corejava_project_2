package com.fssa.wellnessDiet.model;

import java.sql.Date;
import java.time.LocalDate;

public class Appoinment {

    private String patientName;
    private String email;
    private String problem;
    private String branch;
    private Date date;  
    private String status;
    private int id; 

	public Appoinment(String patientName, String email, String problem, String branch, Date date, String status) {
        this.patientName = patientName;
        this.email = email; 
        this.problem = problem;
        this.branch = branch; 
        this.date = date;
        this.status = status;
    }

	public Appoinment(Appoinment appoinment) {
		return;
	}

	public Appoinment(String patientName2, String email2, String address2, String address3, String problem2,
			String branch2, String dateTime) {
		
	} 

	public String getPatientName() { 
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }
    
    public Date getDate() {
		return date;
	}

	public void setDate(Date date) {  
		this.date = date;
	}
	
	public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status; 
    }

    public int getId() {
        return id;
    }

    public void setId(int id) { 
        this.id = id; 
    }


}

