package com.HPEnterprise.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.HPEnterprise.Employee.EmployeeManager.EmployeeManager;
import com.HPEnterprise.Employee.controller.EmployeeController;
import com.HPEnterprise.Employee.model.Employees;
import com.HPEnterprise.Employee.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Collections;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class EmployeeControlTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private EmployeeController employeeController;
    
    @Mock
	private EmployeeManager employeeManager;

	// Helper function to get the number of current employees
	int getEmployeeCount(EmployeeManager manager)
	{
		return manager.getEmployeeList().size();
	}

	@Test
	// Ensure that employee list is populated on initialization
	void createEmployeeManager() {
		EmployeeManager newEmployeeManager = new EmployeeManager();
		assert(getEmployeeCount(newEmployeeManager) != 0);
	}

	@Test
	// Ensure that adding an employee increases the employee count by 1
	void addEmployees() {
		EmployeeManager employeeManager = new EmployeeManager();
		int employeeCount = getEmployeeCount(employeeManager);
		Employees employee = new Employees("HP101", "John", "Webb", "Johnweb@gmail.com", "Software developer");
		employeeManager.addEmployee(employee);
		assert(employeeCount + 1 == getEmployeeCount(employeeManager));
	}

	@ExtendWith(MockitoExtension.class)
    @BeforeEach void setUp()
    {
		this.employeeManager = new EmployeeManager();
		Employees newEmployee = new Employees("HP101", "John", "Webb", "Johnweb@gmail.com", "Software developer");
		this.employeeManager.addEmployee(newEmployee);
    }

	@Test
	// Check whether added employee ID is found in ID field
	void employeeIdInList() {
		List<Employees> employees = this.employeeManager.getEmployeeList();
		for (int i=0; i<employees.size(); i++)
		{
			Employees employee = employees.get(i);
			if (employee.getEmployee_id() == "HP101")
			{
				return;
			}
		}
		assert(false);
	}

	@Test
	// Check whether added employee first name is found in first name field
	void employeeFirstNameInList() {
		List<Employees> employees = this.employeeManager.getEmployeeList();
		for (int i=0; i<employees.size(); i++)
		{
			Employees employee = employees.get(i);
			if (employee.getFirst_name() == "John")
			{
				return;
			}
		}
		assert(false);
	}

	@Test
	// Check whether added employee last name is found in last name field
	void employeeLastNameInList() {
		List<Employees> employees = this.employeeManager.getEmployeeList();
		for (int i=0; i<employees.size(); i++)
		{
			Employees employee = employees.get(i);
			if (employee.getLast_name() == "Webb")
			{
				return;
			}
		}
		assert(false);
	}

	@Test
	// Check whether added employee email is found in email field
	void employeeEmailInList() {
		List<Employees> employees = this.employeeManager.getEmployeeList();
		for (int i=0; i<employees.size(); i++)
		{
			Employees employee = employees.get(i);
			if (employee.getEmail() == "Johnweb@gmail.com")
			{
				return;
			}
		}
		assert(false);
	}

	@Test
	// Check whether added employee title is found in title field
	void employeeTitleInList() {
		List<Employees> employees = this.employeeManager.getEmployeeList();
		for (int i=0; i<employees.size(); i++)
		{
			Employees employee = employees.get(i);
			if (employee.getTitle() == "Software developer")
			{
				return;
			}
		}
		assert(false);
	}

    @Test
    void getAllEmployees() throws Exception {
        given(employeeService.getAllEmployees()).willReturn(Collections.emptyList());

        mockMvc.perform(MockMvcRequestBuilders.get("/employees"))
               .andExpect(status().isOk())
               .andExpect(content().contentType(MediaType.APPLICATION_JSON))
               .andExpect(jsonPath("$").isArray())
               .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    void addEmployee() throws Exception {
        Employees newEmployee = new Employees("HP101", "John", "Webb", "Johnweb@gmail.com", "Developer");

        mockMvc.perform(MockMvcRequestBuilders.post("/employees")
               .contentType(MediaType.APPLICATION_JSON)
               .content(asJsonString(newEmployee)))
               .andExpect(status().isOk());

    }

    private String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}