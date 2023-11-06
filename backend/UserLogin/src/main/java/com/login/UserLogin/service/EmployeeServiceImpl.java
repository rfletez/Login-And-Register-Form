package com.login.UserLogin.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.login.UserLogin.dto.EmployeeDTO;
import com.login.UserLogin.dto.LoginDTO;
import com.login.UserLogin.entity.Employee;
import com.login.UserLogin.repository.EmployeeRepository;
import com.login.UserLogin.response.LoginMessage;


@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	
	public String addEmployee(EmployeeDTO employeeDTO) {
		Employee employee = new Employee(
				employeeDTO.getEmployeeID(),
				employeeDTO.getEmployeeName(),
				employeeDTO.getEmail(),
				
				this.passwordEncoder.encode(employeeDTO.getPassword())
		);
		
		employeeRepo.save(employee);
		
		return employee.getEmployeeName();
	}


	public LoginMessage loginEmployee(LoginDTO loginDTO) {
		
		String msg = "";
		Employee employee1 = employeeRepo.findByEmail(loginDTO.getEmail());
		
		if(employee1 != null) {
			String password = loginDTO.getPassword();
			String encodedPassword = employee1.getPassword();
			
			Boolean correctPassword = passwordEncoder.matches(password, encodedPassword);
			
			if(correctPassword) {
				Optional<Employee> emp = employeeRepo.findOneByEmailAndPassword(loginDTO.getEmail(), loginDTO.getPassword());
				
				if(emp.isPresent()) {
					return new LoginMessage("Login successful", true);
				}
				else {
					return new LoginMessage("Login failed", false);
				}
			}
			else {
				return new LoginMessage("Password does not match", false);
			}
		}
		else {
			return new LoginMessage("Email does not exist", false);
		}
	}

}