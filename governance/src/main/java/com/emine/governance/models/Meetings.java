package com.emine.governance.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="meetings")
public class Meetings implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	@Column(name="meeting_id")
    private long meeting_id;
	
	@Column(name="meeting_name")
	private String meeting_name;
	
	@Column(name="meeting_description")
	private String meeting_description;
	
	@Column(name="meeting_department")
	private String meeting_department;

	public Meetings(){
		meeting_id=0;
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



}
