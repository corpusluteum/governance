package com.emine.governance.service;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.emine.governance.models.Employee;


public interface EmployeeServices {

	Employee getEmployeeById(long employeeId);

	boolean addEmployee(Employee employee);

	void updateEmployee(Employee employee);

	void deleteEmployee(long employeeId);

	List<Employee> getAllEmployee();
	

}
