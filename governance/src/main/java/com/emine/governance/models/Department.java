package com.emine.governance.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name="department")
public class Department implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="department_id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
    private Long department_id;
	
	@Column(name="department_name", nullable=false)
	private String department_name;
	
	@Column(name="department_description")
	private String department_description;
	
	@OneToMany(/*cascade=CascadeType.ALL, */mappedBy = "departmentId", fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SELECT)    
	private List<Employee> employees;
	

	public Department(){
		department_id=null;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((department_description == null) ? 0 : department_description.hashCode());
		result = prime * result + ((employees == null) ? 0 : employees.hashCode());
		result = prime * result + ((department_id == null) ? 0 : department_id.hashCode());
		result = prime * result + ((department_name == null) ? 0 : department_name.hashCode());
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
		Department other = (Department) obj;
		if (department_description == null) {
			if (other.department_description != null)
				return false;
		} else if (!department_description.equals(other.department_description))
			return false;
		if (employees == null) {
			if (other.employees != null)
				return false;
		} else if (!employees.equals(other.employees))
			return false;
		if (department_id == null) {
			if (other.department_id != null)
				return false;
		} else if (!department_id.equals(other.department_id))
			return false;
		if (department_name == null) {
			if (other.department_name != null)
				return false;
		} else if (!department_name.equals(other.department_name))
			return false;
		return true;
	}
	

}
