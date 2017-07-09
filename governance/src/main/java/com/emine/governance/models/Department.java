package com.emine.governance.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="department")
public class Department implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	@Column(name="department_id")
    private long department_id;
	
	@Column(name="department_name")
	private String department_name;
	
	@Column(name="department_description")
	private String department_description;
	

	public Department(){
		department_id=0;
	}
	
	public Department(long id, String name, String description){
		this.department_id = id;
		this.department_name = name;
		this.department_description = description;
	}

	public long getDepartmentId() {
		return department_id;
	}

	public void setDepartmentId(long id) {
		this.department_id = id;
	}

	public String getName() {
		return department_name;
	}

	public void setName(String name) {
		this.department_name = name;
	}
	
	public String getDescription() {
		return department_description;
	}

	public void setDescription(String description) {
		this.department_description = description;
	}

	

}
