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
    private Long departmentId;
	
	@Column(name="name", nullable=false)
	private String departmentName;
	
	@Column(name="description")
	private String departmentDescription;
	
	@OneToMany(/*cascade=CascadeType.ALL, */mappedBy = "department_id", fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SELECT)    
	private List<Employee> employees;
	

	public Department(){
		departmentId=null;
	}
	
	public Department(long id, String name, String description){
		this.departmentId = id;
		this.departmentName = name;
		this.departmentDescription = description;
	}

	public long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(long id) {
		this.departmentId = id;
	}

	public String getName() {
		return departmentName;
	}

	public void setName(String name) {
		this.departmentName = name;
	}
	
	public String getDescription() {
		return departmentDescription;
	}

	public void setDescription(String description) {
		this.departmentDescription = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((departmentDescription == null) ? 0 : departmentDescription.hashCode());
		result = prime * result + ((employees == null) ? 0 : employees.hashCode());
		result = prime * result + ((departmentId == null) ? 0 : departmentId.hashCode());
		result = prime * result + ((departmentName == null) ? 0 : departmentName.hashCode());
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
		if (departmentDescription == null) {
			if (other.departmentDescription != null)
				return false;
		} else if (!departmentDescription.equals(other.departmentDescription))
			return false;
		if (employees == null) {
			if (other.employees != null)
				return false;
		} else if (!employees.equals(other.employees))
			return false;
		if (departmentId == null) {
			if (other.departmentId != null)
				return false;
		} else if (!departmentId.equals(other.departmentId))
			return false;
		if (departmentName == null) {
			if (other.departmentName != null)
				return false;
		} else if (!departmentName.equals(other.departmentName))
			return false;
		return true;
	}
	

}
