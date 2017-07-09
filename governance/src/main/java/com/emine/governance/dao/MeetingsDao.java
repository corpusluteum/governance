package com.emine.governance.dao;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.emine.governance.models.Meetings;

@Transactional
@Repository
public class MeetingsDao implements IMeetingsDao{

	
	
private static final AtomicLong counter = new AtomicLong();
	

@PersistenceContext	
private EntityManager entityManager;


@Override
public Meetings getMeetingsById(long meetingsId) {
	return entityManager.find(Meetings.class, meetingsId);
}

@SuppressWarnings("unchecked")
public List<Meetings> getAllMeetings() {
	String hql = "FROM Departmnet ORDER BY meetings_Id";
	return (List<Meetings>) entityManager.createQuery(hql).getResultList();
}	
@Override
public void addMeetings(Meetings meetings) {
	entityManager.persist(meetings);
}
@Override
public void updateMeetings(Meetings meetings) {
	Meetings dpt = getMeetingsById(meetings.getMeetingsId());
	dpt.setName(meetings.getName());
	dpt.setDescription(meetings.getDescription());
	entityManager.flush();
}
@Override
public void deleteMeetings(long meetingsId) {
	entityManager.remove(getMeetingsById(meetingsId));
}
@Override
public boolean meetingsExists(String name, String description) {
	String hql = "FROM Meetings as dp WHERE dp.name = ? and dp.description = ?";
	int count = entityManager.createQuery(hql).setParameter(1, name)
	              .setParameter(2, description).getResultList().size();
	return count > 0 ? true : false;
}
}
