package com.sanjeev.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sanjeev.entity.Employee;
import com.sanjeev.service.EmployeeService;

@RestController
public class EmployeeController {

	   @Autowired
	    private EmployeeService employeeService;
	   
	    @GetMapping("/employees")
	    public ResponseEntity<List<Employee>> getAllEmployees() {
	        List<Employee> employees = employeeService.getAllEmployees();
	        return new ResponseEntity<>(employees, HttpStatus.CREATED);
	    }
	    @PostMapping("/employee")
	    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
	        Employee emp = employeeService.addEmployee(employee);
	        return new ResponseEntity<>(emp, HttpStatus.OK);
	    }
	    @PutMapping("/employee/{id}")
	    public ResponseEntity<Employee> updateEmployee(@PathVariable Integer id,  @RequestBody Employee employee) {
	    	employee.setId(id);
	        Employee emp = employeeService.editEmployees(employee);
	        return new ResponseEntity<>(emp, HttpStatus.OK);
	    }
	    @DeleteMapping("/employee/{id}")
	    public ResponseEntity<String> deleteEmployee(@PathVariable Integer id) {
	        employeeService.deleteEmployees(id);
	        return new ResponseEntity<>("Employee with ID :" + id + " deleted successfully", HttpStatus.OK);
	    }
}
