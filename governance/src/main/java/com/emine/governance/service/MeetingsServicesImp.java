package com.emine.governance.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.emine.governance.dao.IMeetingsDao;
import com.emine.governance.models.Meetings;


@Service("meetingsServices")
public class MeetingsServicesImp implements MeetingsServices {
	
	private IMeetingsDao meetingsDao;

	@Override
	public Meetings getMeetingsById(long meetingsId) {
		Meetings obj = meetingsDao.getMeetingsById(meetingsId);
		return obj;
	}

	@Override
	public synchronized boolean addMeetings(Meetings meetings) {
		 if (meetingsDao.meetingsExists(meetings.getName(), meetings.getDescription())) {
	            return false;
          } else {
     	     meetingsDao.addMeetings(meetings);
	            return true;
          }
	}

	@Override
	public void updateMeetings(Meetings meetings) {
		meetingsDao.updateMeetings(meetings);
	}

	@Override
	public void deleteMeetings(long meetingsId) {
		meetingsDao.deleteMeetings(meetingsId);
	}

	@Override
	public List<Meetings> getAllMeetings() {
		return meetingsDao.getAllMeetings();
	}


}