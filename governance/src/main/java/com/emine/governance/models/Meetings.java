package com.emine.governance.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="meetings")
public class Meetings implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id	
	@Column(name="meeting_id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
    private Long meeting_id;
	
	@NotEmpty
	@Column(name="meeting_name")
	private String meeting_name;
	
	@Column(name="meeting_description")
	private String meeting_description;
	
	@Column(name="meeting_department")
	private String meeting_department;
	
	 @ManyToMany(fetch = FetchType.EAGER)
	 @JoinTable(name = "department_meetings", joinColumns = { @JoinColumn(name = "meeting_id") }, inverseJoinColumns = { @JoinColumn(name = "department_id") })
	 @Fetch (FetchMode.SELECT)
     private List<Department> departments;

	public Meetings(){
		meeting_id=null;
	}
	
	public Meetings(long id, String name, String description, String department){
		this.meeting_id = id;
		this.meeting_name = name;
		this.meeting_description = description;
		this.meeting_department = department;
	}
	
	public long getMeetingsId() {
		return meeting_id;
	}

	public void setMeetingsId(long id) {
		this.meeting_id = id;
	}

	public String getName() {
		return meeting_name;
	}

	public void setName(String name) {
		this.meeting_name = name;
	}

	public String getDescription() {
		return meeting_description;
	}

	public void setDescription(String description) {
		this.meeting_description = description;
	}

	public String getDepartment() {
		return meeting_department;
	}

	public void setDepartment(String department) {
		this.meeting_department = department;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((departments == null) ? 0 : departments.hashCode());
		result = prime * result + ((meeting_description == null) ? 0 : meeting_description.hashCode());
		result = prime * result + ((meeting_id == null) ? 0 : meeting_id.hashCode());
		result = prime * result + ((meeting_name == null) ? 0 : meeting_name.hashCode());
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
		Meetings other = (Meetings) obj;
		if (departments == null) {
			if (other.departments != null)
				return false;
		} else if (!departments.equals(other.departments))
			return false;
		if (meeting_description == null) {
			if (other.meeting_description != null)
				return false;
		} else if (!meeting_description.equals(other.meeting_description))
			return false;
		if (meeting_id == null) {
			if (other.meeting_id != null)
				return false;
		} else if (!meeting_id.equals(other.meeting_id))
			return false;
		if (meeting_name == null) {
			if (other.meeting_name != null)
				return false;
		} else if (!meeting_name.equals(other.meeting_name))
			return false;
		return true;
	}

}
