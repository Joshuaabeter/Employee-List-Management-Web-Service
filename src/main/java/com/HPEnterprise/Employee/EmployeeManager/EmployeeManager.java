package com.HPEnterprise.Employee.EmployeeManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.HPEnterprise.Employee.model.Employees;

@Repository
public class EmployeeManager {
	
	private List<Employees> employeeList =new ArrayList<>(Arrays.asList(
			new Employees("HP101", "Joshua", "Peter","Joshuapeter@hotmail.com", "Java Developer"),
			new Employees("HP102", "Jim", "Tom","Jimtom@yahoo.com", "Cloud Engineer"),
			new Employees("HP103", "Karen", "Welsh", "WelshKaren@gmail.com","Data Scientist"),
			new Employees("HP104", "Vicent", "Tim", "Vincentt@yahoo.com", "Data Engineer"),
			new Employees("HP105", "Peter", "Parker","Parkerpeter@gmail.com", "Product Manager")
			
			
			));

	public List<Employees> getEmployeeList() {
		return employeeList;
	}

	public void addEmployee(Employees employee) {
		employeeList.add(employee);
	}
	public  Employees getEmployee(String employee_id) {
		return employeeList.stream().filter(e->e.getEmployee_id()
				.equals(employee_id)).findFirst().get();
	}
	
	public void updateEmployee(String employee_id, Employees employee) {
		for(int i=0; i<employeeList.size();i++) {
			Employees e =employeeList.get(i);
			
			if(e.getEmployee_id().equals(employee_id)) {
				employeeList.set(i, employee);
				
				return;
			
			}
			
		}
	}
	
      public void deletemployee(String employee_id) {
		
    	  employeeList.removeIf(e->e.getEmployee_id().equals(employee_id));
	}
}
