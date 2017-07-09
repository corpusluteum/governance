package com.emine.governance.service;

import java.util.List;

import com.emine.governance.models.Department;
import com.emine.governance.models.Meetings;

public interface MeetingsServices {

	Meetings getMeetingsById(long meetingsId);

	boolean addMeetings(Meetings meetings);

	void updateMeetings(Meetings meetings);

	void deleteMeetings(long meetingsId);

	List<Meetings> getAllMeetings();

}
