package com.service;

import java.util.List;
import com.bean.Participant;
import com.dao.ParticipantDao;

public class ParticipantService 
{
	ParticipantDao dao = new ParticipantDao();
	
	public List<Participant> getAllParticipants()
	{
		return ParticipantDao.getAllParticipants();
	}
	
	public int createParticipant(Participant participant)
	{
		int result = dao.createParticipant(participant);
		
		return result;
	}
	
	public int deleteParticipant(int participantId)
	{
		int result = dao.deleteParticipant(participantId);
		
		return result;
	}
	
	public int updateParticipant(Participant participant)
	{
		int result = dao.updateParticipant(participant);
		
		return result;
	}
	
	public Participant getParticipantByEmail(String email)
	{
		Participant participant = dao.getParticipantByEmailAddress(email);
		
		return participant;
	}

}