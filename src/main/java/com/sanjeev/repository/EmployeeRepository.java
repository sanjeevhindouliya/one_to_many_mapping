package com.sanjeev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sanjeev.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	

}
