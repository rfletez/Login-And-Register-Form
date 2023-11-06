package com.login.UserLogin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.login.UserLogin.dto.EmployeeDTO;
import com.login.UserLogin.service.EmployeeService;


@RestController
@CrossOrigin
@RequestMapping("/api/v1/com/employeePath")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping(path = "/save")
	public String saveEmployee(@RequestBody @Validated EmployeeDTO employeeDTO) {
		String id = employeeService.addEmployee(employeeDTO);
		return id;
	}

}