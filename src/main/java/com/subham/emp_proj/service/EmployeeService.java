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

	public Object addEmployee(Employee emp) {
		
		return repo.save(emp);
	}

	public List<Employee> getEmployee() {
		
		return repo.findAll();
	}

	public Employee getEmployeeById(int id) {
		
		return repo.findById(id).orElse(null);
	}

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

	public void deleteEmployee(int id) {
		repo.deleteById(id);
	}


	public List<Employee> searchEmployeeByFirstName(String firstName) {
		
		return repo.findByFirstName(firstName);
	}

	public List<Employee> searchEmployeeByLastName(String lastName) {
		
		return repo.findByLastName(lastName);
	}

	public List<Employee> searchEmployeeByDepartment(String department) {
		
		return repo.findByDepartment(department);
	}

	public List<Employee> searchEmployeeByDateOfBirth(LocalDate dateOfBirth) {
		
		return repo.findByDateOfBirth(dateOfBirth);
	}
	
	

}
