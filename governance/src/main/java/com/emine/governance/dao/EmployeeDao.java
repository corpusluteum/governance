package com.emine.governance.dao;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.emine.governance.models.Employee;

@Transactional
@Repository
public class EmployeeDao implements IEmployeeDao {

	
private static final AtomicLong counter = new AtomicLong();
	

    @PersistenceContext	
    private EntityManager entityManager;


    @Override
    public Employee getEmployeeById(long employeeId) {
 	    return entityManager.find(Employee.class, employeeId);
    }

@SuppressWarnings("unchecked")
public List<Employee> getAllEmployee() {
	String hql = "FROM Employee ORDER BY employee_Id";
	return (List<Employee>) entityManager.createQuery(hql).getResultList();
}	
@Override
public void addEmployee(Employee employee) {
	entityManager.persist(employee);
}
@Override
public void updateEmployee(Employee employee) {
	Employee dpt = getEmployeeById(employee.getEmployeeId());
	dpt.setName(employee.getName());
	dpt.setSurname(employee.getSurname());
	dpt.setSalary(employee.getSalary());
	entityManager.flush();
}
@Override
public void deleteEmployee(long employeeId) {
	entityManager.remove(getEmployeeById(employeeId));
}
@Override
public boolean employeeExists(String name, String description) {
	String hql = "FROM Employee as dp WHERE dp.name = ? and dp.surname = ?";
	int count = entityManager.createQuery(hql).setParameter(1, name)
	              .setParameter(2, description).getResultList().size();
	return count > 0 ? true : false;
}
}
