package com.emine.governance.dao;

import java.util.List;

import com.emine.governance.models.Employee;

public interface IEmployeeDao {
	
	Employee getEmployeeById(long employeeId);

	void addEmployee(Employee employee);

	void updateEmployee(Employee employee);

	void deleteEmployee(long employeeId);

	boolean employeeExists(String name, String surname);

	List<Employee> getAllEmployee();

}
