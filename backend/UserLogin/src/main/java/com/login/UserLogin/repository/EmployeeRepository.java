package com.login.UserLogin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.login.UserLogin.entity.Employee;


@EnableJpaRepositories
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
}