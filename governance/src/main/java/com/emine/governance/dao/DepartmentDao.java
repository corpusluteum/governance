package com.emine.governance.dao;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.emine.governance.models.Department;

@Transactional
@Repository
public class DepartmentDao implements IDepartmentDao{
	
	private static final AtomicLong counter = new AtomicLong();
	
	   @PersistenceContext	
	    private EntityManager entityManager;
	
	    @Override
	    public Department getDepartmentById(long departmentId) {
			return entityManager.find(Department.class, departmentId);
		}
	    
		@SuppressWarnings("unchecked")
		public List<Department> getAllDepartment() {
			String hql = "FROM Department ORDER BY department_Id";
			return (List<Department>) entityManager.createQuery(hql).getResultList();
		}	
		@Override
		public void addDepartment(Department department) {
			entityManager.persist(department);
		}
		@Override
		public void updateDepartment(Department department) {
			Department dpt = getDepartmentById(department.getDepartmentId());
			dpt.setName(department.getName());
			dpt.setDescription(department.getDescription());
			entityManager.flush();
		}
		@Override
		public void deleteDepartment(long departmentId) {
			entityManager.remove(getDepartmentById(departmentId));
		}
		@Override
		public boolean departmentExists(String name, String description) {
			String hql = "FROM Department as dp WHERE dp.name = ? and dp.description = ?";
			int count = entityManager.createQuery(hql).setParameter(1, name)
			              .setParameter(2, description).getResultList().size();
			return count > 0 ? true : false;
		}
}
