package com.subham.emp_proj.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
//import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import com.subham.emp_proj.model.Employee;
import com.subham.emp_proj.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	private EmployeeService service;
	
	public EmployeeController(EmployeeService service)
	{
		this.service = service;
	}
	
	//Method to Create
	@PostMapping("/employee")
	public ResponseEntity<?> addEmployee(@RequestBody Employee emp)
	{
		try
		{
			Employee emp1 = (Employee) service.addEmployee(emp);
			return new ResponseEntity<>(emp1, HttpStatus.CREATED);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//Method to ReadAll
	@GetMapping("/employee")
	public ResponseEntity<List<Employee>> getEmployee()
	{
		return new ResponseEntity<>(service.getEmployee(), HttpStatus.OK);
	}
	
	//Method to read
	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable int id)
	{
		Employee emp = service.getEmployeeById(id);
		
		if(emp != null)
			return new ResponseEntity<>(emp, HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	//Method to update
	@PutMapping("/employee/{id}")
	public ResponseEntity<?> updateEmployee(@PathVariable int id, @RequestBody Employee emp)
	{
		Employee emp1 = service.updateEmployee(id, emp);
		
		if(emp1 != null)
		{
			return new ResponseEntity<>("Employee details updated successfully", HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>("Failed to update employee details", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//Method to delete
	@DeleteMapping("/employee/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable int id)
	{
		Employee emp = service.getEmployeeById(id);
		if(emp != null)
			{
				service.deleteEmployee(id);
				return new ResponseEntity<>("Employee deleted", HttpStatus.OK);
			}
		else
		{
			return new ResponseEntity<>("Employee not found", HttpStatus.NOT_FOUND);
		}
		
	}
	
	//Search employee by First Name
	@GetMapping("/employee/search/firstName")
	public ResponseEntity<List<Employee>> searchEmployeeByFirstName(@RequestParam String firstName)
	{
		List<Employee> emp = service.searchEmployeeByFirstName(firstName);
		
		return new ResponseEntity<>(emp, HttpStatus.OK);
	}
	
	//Search employee by Last Name
	@GetMapping("/employee/search/lastName")
	public ResponseEntity<List<Employee>> searchEmployeeByLastName(@RequestParam String lastName)
	{
		List<Employee> emp = service.searchEmployeeByLastName(lastName);

		return new ResponseEntity<>(emp, HttpStatus.OK);
	}
	
	//Search employee by Department
	@GetMapping("/employee/search/department")
	public ResponseEntity<List<Employee>> searchEmployeeByDepartment(@RequestParam String department)
	{
		List<Employee> emp = service.searchEmployeeByDepartment(department);

		return new ResponseEntity<>(emp, HttpStatus.OK);
	}
	
	//Search employee by Department
	@GetMapping("/employee/search/dateOfBirth")
	public ResponseEntity<List<Employee>> searchEmployeeByDateOfBirth(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate dateOfBirth) //This annotation ensures that the date format passed as a query parameter is in ISO format (YYYY-MM-DD).
	{
		List<Employee> emp = service.searchEmployeeByDateOfBirth(dateOfBirth);

		return new ResponseEntity<>(emp, HttpStatus.OK);
	}
}
