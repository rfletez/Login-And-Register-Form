package com.login.UserLogin.dto;


public class EmployeeDTO {
	
	private long employeeID;
	private String employeeName;
	private String email;
	private String password;
	
	public EmployeeDTO() {
		
	}

	public EmployeeDTO(long employeeID, String employeeName, String email, String password) {
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
		return "EmployeeDTO [employeeID=" + employeeID + ", employeeName=" + employeeName + ", email=" + email
				+ ", password=" + password + "]";
	}

}