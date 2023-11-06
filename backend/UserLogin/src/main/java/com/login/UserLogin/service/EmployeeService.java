package com.login.UserLogin.service;

import org.springframework.core.log.LogMessage;


import com.login.UserLogin.dto.EmployeeDTO;
import com.login.UserLogin.dto.LoginDTO;

public interface EmployeeService {

	String addEmployee(EmployeeDTO employeeDTO);

	LoginMessage loginEmployee(LoginDTO loginDTO);
	

}