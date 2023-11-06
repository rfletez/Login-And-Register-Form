package com.login.UserLogin.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Employee")
public class Employee {
	
	@Id
	@Column(name = "employee_id", length = 50)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long employeeID;
	
	@Column(name = "employee_name", length = 250)
	private String employeeName;
	
	@Column(name = "employee_email", length = 250)
	private String email;
	
	@Column(name = "employee_password", length = 250)
	private String password;
	
	public Employee() {
		
	}

	public Employee(long employeeID, String employeeName, String email, String password) {
		super();
		this.employeeID = employeeID;
		this.employeeName = employeeName;
		this.email = email;
		this.password = password;
	}

	public long getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(long employeeID) {
		this.employeeID = employeeID;
	}

	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Employee [employeeID=" + employeeID + ", employeeName=" + employeeName + ", email=" + email
				+ ", password=" + password + "]";
	}
	
}