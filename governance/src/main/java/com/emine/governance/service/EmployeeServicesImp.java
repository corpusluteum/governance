package com.emine.governance.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.emine.governance.models.Employee;
import com.emine.governance.dao.IEmployeeDao;


@Service("employeeServices")
public class EmployeeServicesImp implements EmployeeServices {
	
	private IEmployeeDao employeeDao;

	@Override
	public Employee getEmployeeById(long employeeId) {
		Employee obj = employeeDao.getEmployeeById(employeeId);
		return obj;
	}

	@Override
	public synchronized boolean addEmployee(Employee employee) {
		 if (employeeDao.employeeExists(employee.getName(), employee.getName())) {
	         return false;
          } else {
     	     employeeDao.addEmployee(employee);
	            return true;
          }
	}

	@Override
	public void updateEmployee(Employee employee) {
		employeeDao.updateEmployee(employee);
		
	}

	@Override
	public void deleteEmployee(long employeeId) {
		employeeDao.deleteEmployee(employeeId);
		
	}

	@Override
	public List<Employee> getAllEmployee() {
		return employeeDao.getAllEmployee();
	}
	
    


}
