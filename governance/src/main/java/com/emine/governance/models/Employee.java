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
    private Long employee_id;  
	
	@Column(name="employee_name")
    private String employee_name;
	
	@Column(name="employee_surname")	
	private String employee_surname;
	
	@Column(name="employee_salary")
	private Double employee_salary;

	@Column(name="department_id")
	private Integer departmentId;
		
	public Employee(){
		employee_id=null;
	}
	
	public Employee(Long id, String name, String surname, double salary){
		this.employee_id = id;
		this.employee_name = name;
		this.employee_surname = surname;
		this.employee_salary = salary;
	}
	
	public long getEmployeeId() {
		return employee_id;
	}

	public void setEmployeeId(long l) {
		this.employee_id = l;
	}

	public String getName() {
		return employee_name;
	}

	public void setName(String name) {
		this.employee_name = name;
	}
	
	public String getSurname() {
		return employee_surname;
	}

	public void setSurname(String surname) {
		this.employee_surname = surname;
	}

	public double getSalary() {
		return employee_salary;
	}

	public void setSalary(double salary) {
		this.employee_salary = salary;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((departmentId == null) ? 0 : departmentId.hashCode());
		result = prime * result + ((employee_id == null) ? 0 : employee_id.hashCode());
		result = prime * result + ((employee_name == null) ? 0 : employee_name.hashCode());
		result = prime * result + ((employee_salary == null) ? 0 : employee_salary.hashCode());
		result = prime * result + ((employee_surname == null) ? 0 : employee_surname.hashCode());
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
		if (employee_id == null) {
			if (other.employee_id != null)
				return false;
		} else if (!employee_id.equals(other.employee_id))
			return false;
		if (employee_name == null) {
			if (other.employee_name != null)
				return false;
		} else if (!employee_name.equals(other.employee_name))
			return false;
		if (employee_salary == null) {
			if (other.employee_salary != null)
				return false;
		} else if (!employee_salary.equals(other.employee_salary))
			return false;
		if (employee_surname == null) {
			if (other.employee_surname != null)
				return false;
		} else if (!employee_surname.equals(other.employee_surname))
			return false;
		return true;
	}


}
