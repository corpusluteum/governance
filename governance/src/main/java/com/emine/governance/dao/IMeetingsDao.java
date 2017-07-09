package com.emine.governance.dao;

import java.util.List;

import com.emine.governance.models.Meetings;

public interface IMeetingsDao {
	
	Meetings getMeetingsById(long meetingsId);

	void addMeetings(Meetings meetings);

	void updateMeetings(Meetings meetings);

	void deleteMeetings(long meetingsId);

	boolean meetingsExists(String name, String description);

	List<Meetings> getAllMeetings();

}
