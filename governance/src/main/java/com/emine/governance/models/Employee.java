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
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	@Column(name="employee_id")
    private long employee_id;  
	
	@Column(name="employee_name")
    private String employee_name;
	
	@Column(name="employee_surname")	
	private String employee_surname;
	
	@Column(name="employee_salary")
	private double employee_salary;

	public Employee(){
		employee_id=0;
	}
	
	public Employee(int id, String name, String surname, double salary){
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


}
