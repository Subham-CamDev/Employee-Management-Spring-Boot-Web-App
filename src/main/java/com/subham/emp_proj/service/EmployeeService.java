package com.subham.emp_proj.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.subham.emp_proj.model.Employee;
import com.subham.emp_proj.repository.EmployeeRepo;

@Service
public class EmployeeService {
	
	private EmployeeRepo repo;
	
	public EmployeeService(EmployeeRepo repo)
	{
		this.repo = repo;
	}
	
	//for addition
	public Object addEmployee(Employee emp) {
		
		return repo.save(emp);
	}
	
	//for fetching all data
	public List<Employee> getEmployee() {
		
		return repo.findAll();
	}
	
	//for fetching one single data
	public Employee getEmployeeById(int id) {
		
		return repo.findById(id).orElse(null);
	}
	
	//for updating data
	public Employee updateEmployee(int id, Employee emp) {
		
		Optional<Employee> emp1 = repo.findById(id);
		
		if(emp1.isPresent())
		{
			Employee updatedEmp = emp1.get();
			updatedEmp.setFirstName(emp.getFirstName());
			updatedEmp.setLastName(emp.getLastName());
			updatedEmp.setDateOfBirth(emp.getDateOfBirth());
			updatedEmp.setDepartment(emp.getDepartment());
			
			return repo.save(updatedEmp);
		}
		
		return null;
	}
	
	//for deleting data
	public void deleteEmployee(int id) {
		repo.deleteById(id);
	}

	//for searching by first name
	public List<Employee> searchEmployeeByFirstName(String firstName) {
		
		return repo.findByFirstName(firstName);
	}

	//for searching by last name
	public List<Employee> searchEmployeeByLastName(String lastName) {
		
		return repo.findByLastName(lastName);
	}

	//for searching by department
	public List<Employee> searchEmployeeByDepartment(String department) {
		
		return repo.findByDepartment(department);
	}

	//for searching by date of birth
	public List<Employee> searchEmployeeByDateOfBirth(LocalDate dateOfBirth) {
		
		return repo.findByDateOfBirth(dateOfBirth);
	}
	
	

}
