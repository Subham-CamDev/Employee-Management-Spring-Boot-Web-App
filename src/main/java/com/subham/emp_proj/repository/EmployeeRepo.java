package com.subham.emp_proj.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.subham.emp_proj.model.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer>{
	
	// Search by firstName (case insensitive)
    List<Employee> findByFirstName(String firstName);
    
    // Search by lastName (case insensitive)
    List<Employee> findByLastName(String lastName);
    
    // Search by dateOfBirth (exact date)
    @Query("SELECT e FROM Employee e WHERE e.dateOfBirth = :dateOfBirth")
    List<Employee> findByDateOfBirth(LocalDate dateOfBirth);
    
    // Search by department
    List<Employee> findByDepartment(String department);

}
