package com.service;

import java.util.List;
import com.bean.Participant;
import com.dao.ParticipantDao;

public class ParticipantService 
{
	ParticipantDao dao = new ParticipantDao();
	
	public List<Participant> getAllParticipants()
	{
		return dao.getAllParticipants();
	}
	
	public int createParticipant(Participant participant)
	{
		int result = dao.createParticipant(participant);
		
		return result;
	}
	
	public int deleteParticipant(Participant participant)
	{
		int result = dao.deleteParticipant(participant.getUserId());
		
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