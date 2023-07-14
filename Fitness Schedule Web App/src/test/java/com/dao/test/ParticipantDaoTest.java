package com.dao.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Order;
import com.bean.Participant;
import com.dao.ParticipantDao;
import java.sql.Connection;
import com.resource.DBResource;


@TestMethodOrder(OrderAnnotation.class)
class ParticipantDaoTest
{
    ParticipantDao dao = new ParticipantDao();
	
	@Test
	@Order(1)
	public void CreateParticipantTest()
	{
		Connection connection = DBResource.createConnection();
		
		Participant myParticipant = new Participant();
		
		myParticipant.setFirstName("Shaquille");
		myParticipant.setLastName("O'Neal");
		myParticipant.setPassword("shaquille@123");
		myParticipant.setEmail("shaquille.oneal@example.com");
		
		int result = dao.createParticipant(myParticipant);
		
		assertEquals(1, result);
		
		try
		{
			connection.close();
		} 
		catch (Exception e)
		{
			System.out.println("An exception has occured : " + e);
		}
	}
	
	@Test
	@Order(2)
	public void UpdateParticipantTest()
	{
		Connection connection = DBResource.createConnection();
		
		//First get the participant that is already there
		Participant myParticipant = dao.getParticipantByEmailAddress("shaquille.oneal@example.com");
		myParticipant.setFirstName("Shaq");
		
		//Then update the participant
		int result = dao.updateParticipant(myParticipant);
		
		assertEquals(1, result);
		
		try
		{
			connection.close();
		} 
		catch (Exception e)
		{
			System.out.println("An exception has occured : " + e);
		}
	}
	
	@Test
	@Order(3)
	public void GetAllParticipantsTest()
	{
		Connection connection = DBResource.createConnection();
		
		List<Participant> participantList = new ArrayList<Participant>();
		participantList = dao.getAllParticipants();
		
		assertNotEquals(0, participantList.size());
		
		try
		{
			connection.close();
		} 
		catch (Exception e)
		{
			System.out.println("An exception has occured : " + e);
		}
	}
	
	@Test
	@Order(4)
	public void DeleteParticipantTest()
	{
		Connection connection = DBResource.createConnection();
			
		Participant myParticipant = dao.getParticipantByEmailAddress("shaquille.oneal@example.com");
		
		int result = dao.deleteParticipant(myParticipant.getUserId());
		
		assertEquals(1, result);
		
		try
		{
			connection.close();
		} 
		catch (Exception e)
		{
			System.out.println("An exception has occured : " + e);
		}
	}

}
