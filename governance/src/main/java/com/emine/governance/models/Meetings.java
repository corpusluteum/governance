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
    private Long meetingId;
	
	@NotEmpty
	@Column(name="meetings_name")
	private String meetingName;
	
	@Column(name="meetings_description")
	private String meetingDescription;
	
	@Column(name="meetings_department")
	private String meetingDepartment;
	
	 @ManyToMany(fetch = FetchType.EAGER)
	 @JoinTable(name = "meetings", joinColumns = { @JoinColumn(name = "meeting_id") }, inverseJoinColumns = { @JoinColumn(name = "department_id") })
	 @Fetch (FetchMode.SELECT)
     private List<Department> departments;

	public Meetings(){
		meetingId=null;
	}
	
	public Meetings(long id, String name, String description, String department){
		this.meetingId = id;
		this.meetingName = name;
		this.meetingDescription = description;
		this.meetingDepartment = department;
	}
	
	public long getMeetingsId() {
		return meetingId;
	}

	public void setMeetingsId(long id) {
		this.meetingId = id;
	}

	public String getName() {
		return meetingName;
	}

	public void setName(String name) {
		this.meetingName = name;
	}

	public String getDescription() {
		return meetingDescription;
	}

	public void setDescription(String description) {
		this.meetingDescription = description;
	}

	public String getDepartment() {
		return meetingDepartment;
	}

	public void setDepartment(String department) {
		this.meetingDepartment = department;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((departments == null) ? 0 : departments.hashCode());
		result = prime * result + ((meetingDescription == null) ? 0 : meetingDescription.hashCode());
		result = prime * result + ((meetingId == null) ? 0 : meetingId.hashCode());
		result = prime * result + ((meetingName == null) ? 0 : meetingName.hashCode());
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
		if (meetingDescription == null) {
			if (other.meetingDescription != null)
				return false;
		} else if (!meetingDescription.equals(other.meetingDescription))
			return false;
		if (meetingId == null) {
			if (other.meetingId != null)
				return false;
		} else if (!meetingId.equals(other.meetingId))
			return false;
		if (meetingName == null) {
			if (other.meetingName != null)
				return false;
		} else if (!meetingName.equals(other.meetingName))
			return false;
		return true;
	}

}
