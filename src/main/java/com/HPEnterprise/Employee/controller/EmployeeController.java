package com.HPEnterprise.Employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.HPEnterprise.Employee.model.Employees;
import com.HPEnterprise.Employee.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employees")
	public List<Employees> getAllEmployees(){
		
		return employeeService.getAllEmployees();
	}
	
	@GetMapping("/employees/{eId}")
	public Employees getEmployee(@PathVariable("eId") String employee_id) {
		return employeeService.getEmployee(employee_id);
	}
	
	
	@PostMapping("/employees")
	public void addEmployee(@RequestBody Employees employee) {
		employeeService.addEmployees(employee);
	}
	
	@PutMapping("/employees/{eId}")
	public void updateEmployee(@RequestBody Employees employee,
			@PathVariable("eId") String employee_id) {
		employeeService.updateEmployee(employee_id, employee);
	}
	
	@DeleteMapping("/employees/{eId}")
	public void deleteEmployee(@PathVariable("eId") String employee_id) {
		employeeService.deleteEmployee(employee_id);
	}

		

}
