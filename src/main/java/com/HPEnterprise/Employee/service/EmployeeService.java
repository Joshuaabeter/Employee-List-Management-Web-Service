package com.HPEnterprise.Employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HPEnterprise.Employee.EmployeeManager.EmployeeManager;
import com.HPEnterprise.Employee.model.Employees;

@Service
public class EmployeeService {
	
	@Autowired
	private  EmployeeManager employeeManager;
	
	public  List<Employees> getAllEmployees(){
		return employeeManager.getEmployeeList();		
	}
	
	public Employees getEmployee(String employee_id) {
		return employeeManager.getEmployee(employee_id);
	}
	
	public  void addEmployees(Employees employee) {
		employeeManager.addEmployee(employee);
	}
	public void updateEmployee(String employee_id, Employees employee) {
		employeeManager.updateEmployee(employee_id, employee);
	}
	
	public void deleteEmployee(String employee_id) {
		employeeManager.deletemployee(employee_id);
	}

}
