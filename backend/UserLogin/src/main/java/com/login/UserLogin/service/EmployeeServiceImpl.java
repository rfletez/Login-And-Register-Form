package com.login.UserLogin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.login.UserLogin.dto.EmployeeDTO;
import com.login.UserLogin.entity.Employee;
import com.login.UserLogin.repository.EmployeeRepository;


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

}
