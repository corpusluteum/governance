package com.emine.governance.dao;

import java.util.List;

import com.emine.governance.models.Department;

public interface IDepartmentDao {

	Department getDepartmentById(long departmentId);
	
	void updateDepartment(Department department);

	List<Department> getAllDepartment();

	void addDepartment(Department department);

	void deleteDepartment(long departmentId);

	boolean departmentExists(String name, String description);
}
