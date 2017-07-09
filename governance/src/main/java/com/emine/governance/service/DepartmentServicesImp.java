package com.emine.governance.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.emine.governance.models.Department;
import com.emine.governance.dao.IDepartmentDao;

@Service("departmentServices")
public class DepartmentServicesImp implements DepartmentServices {
	
	private IDepartmentDao departmentDao;

	@Override
	public List<Department> getAllDepartment() {
		return departmentDao.getAllDepartment();
	}

	@Override
	public Department getDepartmentById(long departmentId) {
		Department obj = departmentDao.getDepartmentById(departmentId);
		return obj;
	}

	@Override
	public synchronized boolean addDepartment(Department department) {
		 if (departmentDao.departmentExists(department.getName(), department.getDescription())) {
	            return false;
         } else {
        	 departmentDao.addDepartment(department);
	            return true;
         }
	}

	@Override
	public void updateDepartment(Department department) {
		departmentDao.updateDepartment(department);
	}

	@Override
	public void deleteDepartment(long departmentId) {
		departmentDao.deleteDepartment(departmentId);
		
	}
}