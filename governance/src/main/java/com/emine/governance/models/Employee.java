package com.emine.governance.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="employee")
public class Employee implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id	
	@Column(name="employee_id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;  
	
	@Column(name="employee_name")
    private String employeeName;
	
	@Column(name="employee_surname")	
	private String employeesSurname;
	
	@Column(name="employee_salary")
	private Double employeesSalary;

	@Column(name="department_id")
	private Integer departmentId;
		
	public Employee(){
		employeeId=null;
	}
	
	public Employee(Long id, String name, String surname, double salary){
		this.employeeId = id;
		this.employeeName = name;
		this.employeesSurname = surname;
		this.employeesSalary = salary;
	}
	
	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long l) {
		this.employeeId = l;
	}

	public String getName() {
		return employeeName;
	}

	public void setName(String name) {
		this.employeeName = name;
	}
	
	public String getSurname() {
		return employeesSurname;
	}

	public void setSurname(String surname) {
		this.employeesSurname = surname;
	}

	public double getSalary() {
		return employeesSalary;
	}

	public void setSalary(double salary) {
		this.employeesSalary = salary;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((departmentId == null) ? 0 : departmentId.hashCode());
		result = prime * result + ((employeeId == null) ? 0 : employeeId.hashCode());
		result = prime * result + ((employeeName == null) ? 0 : employeeName.hashCode());
		result = prime * result + ((employeesSalary == null) ? 0 : employeesSalary.hashCode());
		result = prime * result + ((employeesSurname == null) ? 0 : employeesSurname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (departmentId == null) {
			if (other.departmentId != null)
				return false;
		} else if (!departmentId.equals(other.departmentId))
			return false;
		if (employeeId == null) {
			if (other.employeeId != null)
				return false;
		} else if (!employeeId.equals(other.employeeId))
			return false;
		if (employeeName == null) {
			if (other.employeeName != null)
				return false;
		} else if (!employeeName.equals(other.employeeName))
			return false;
		if (employeesSalary == null) {
			if (other.employeesSalary != null)
				return false;
		} else if (!employeesSalary.equals(other.employeesSalary))
			return false;
		if (employeesSurname == null) {
			if (other.employeesSurname != null)
				return false;
		} else if (!employeesSurname.equals(other.employeesSurname))
			return false;
		return true;
	}


}
