package com.emine.governance.service;

import java.util.List;

import com.emine.governance.models.Department;

public interface DepartmentServices {
	
	List<Department> getAllDepartment();
	  
	Department getDepartmentById(long departmentId);
	  
	boolean addDepartment(Department department);
	 
	void updateDepartment(Department department);
	     
	void deleteDepartment(long departmentId);
	    
}
