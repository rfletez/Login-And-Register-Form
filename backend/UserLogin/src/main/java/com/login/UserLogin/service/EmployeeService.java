package com.login.UserLogin.service;


import com.login.UserLogin.dto.EmployeeDTO;
import com.login.UserLogin.dto.LoginDTO;
import com.login.UserLogin.response.LoginMessage;

public interface EmployeeService {

	String addEmployee(EmployeeDTO employeeDTO);

	LoginMessage loginEmployee(LoginDTO loginDTO);
	
}