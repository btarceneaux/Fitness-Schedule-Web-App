package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.bean.Participant;
import com.resource.DBResource;
import java.util.List;
import java.util.ArrayList;

public class ParticipantDao
{
	final String TAG = getClass().getSimpleName();
	String username = System.getenv("DBUN");
	String password = System.getenv("DBPW");
	String url = System.getenv("BASEURL") + "fitness_schedule";
	
	public Participant getParticipantByEmailAddress(String emailAddress)
	{
		Participant myParticipant = new Participant();
		
		try
		{
			Connection connection = DBResource.createConnection();
			connection = DriverManager.getConnection(url, username, password);
			System.out.println("Connection created.");
			
			String sql = 
					"SELECT "
					+ "user_id, "
					+ "last_name, "
					+ "first_name, "
					+ "email, "
					+ "password "
					+ "FROM participant "
					+ "WHERE email = ?;";
			
			PreparedStatement psmt = connection.prepareStatement(sql);
			psmt.setString(1, emailAddress);
			
			ResultSet rs = psmt.executeQuery();
			
			while(rs.next())
			{
				myParticipant.setUserId(rs.getInt("user_id"));
				myParticipant.setLastName(rs.getString("last_name"));
				myParticipant.setFirstName(rs.getString("first_name"));
				myParticipant.setEmail(rs.getString("email"));
				myParticipant.setPassword(rs.getString("password"));
			}
			
			connection.close();
		} 
		catch (Exception e)
		{
			System.out.println("An error has occured : " + e);
		}
		
		return myParticipant;
		
	}
	
	
	public List<Participant> getAllParticipants()
	{
		List<Participant> participantList = new ArrayList<Participant>();
		
		try
		{
			Connection connection = DBResource.createConnection();
			connection = DriverManager.getConnection(url, username, password);
			System.out.println("Connection created.");
			
			PreparedStatement psmt = connection.prepareStatement(
					"SELECT "
					+ "user_id, "
					+ "last_name, "
					+ "first_name, "
					+ "password, "
					+ "email "
					+ "FROM participant "
					+ "ORDER BY 2, 3;");
			
			ResultSet rs = psmt.executeQuery();
			
			while(rs.next())
			{
				Participant participant = new Participant();
				
				participant.setEmail(rs.getString("email"));
				participant.setFirstName(rs.getString("first_name"));
				participant.setLastName(rs.getString("last_name"));
				participant.setPassword(rs.getString("password"));
				participant.setUserId(rs.getInt("user_id"));
				
				participantList.add(participant);
				
				connection.close();
			}
		} 
		catch (Exception e)
		{
			System.out.println("An exception has occured : " + e);
		}
		
		return participantList;
		
	}
	
	
	public int createParticipant(Participant participant)
	{
		int result = 0;
		
		try
		{
			Connection connection = DBResource.createConnection();
			connection = DriverManager.getConnection(url, username, password);
			System.out.println("Connection created.");
			
			String sql = "INSERT INTO participant VALUES(null, ?, ?, ?, ?)";
			PreparedStatement psmt = connection.prepareStatement(sql);
			psmt.setString(1, participant.getLastName());
			psmt.setString(2, participant.getFirstName());
			psmt.setString(3, participant.getPassword());
			psmt.setString(4, participant.getEmail());
			
			result = psmt.executeUpdate();
			
			String message = result > 0 ? "Participant Created Successfully" : "Participant Not Created. Please Try Again!";
			System.out.println(message);
			
			connection.close();
			System.out.println(TAG + "Connection closed with status : " + connection.isClosed());
		} 
		catch (Exception e)
		{
			System.out.println("An exception has occured : " + e);
		}
		
		return result;
	}
	
	
	public int updateParticipant(Participant participant)
	{
		int result = 0;
		
		try
		{
			Connection connection = DBResource.createConnection();
			connection = DriverManager.getConnection(url, username, password);
			System.out.println("Connection created.");
			
			String sql = "UPDATE participant SET "
					+ "last_name = ?, "
					+ "first_name = ?, "
					+ "password = ?, "
					+ "email = ? "
					+ "WHERE user_id = ?;";
			
			PreparedStatement psmt = connection.prepareStatement(sql);
			psmt.setString(1, participant.getLastName());
			psmt.setString(2, participant.getFirstName());
			psmt.setString(3, participant.getPassword());
			psmt.setString(4, participant.getEmail());
			psmt.setInt(5, participant.getUserId());
			
			result = psmt.executeUpdate();
			String message = result > 0 ? "Participant Updated Successfully" : "Participant Not Updated. Please Try Again!";
			System.out.println(message);
			
			connection.close();
		}
		catch(Exception e)
		{
			System.out.println("An exception has occured : " + e);
		}
		
		return result;
	}
	
	
	public int deleteParticipant(int userId)
	{
		int result = 0;
		
		try
		{
			Connection connection = DBResource.createConnection();
			connection = DriverManager.getConnection(url, username, password);
			System.out.println("Connection created.");
			
			String sql = "DELETE FROM participant WHERE user_id = ?";
			PreparedStatement psmt = connection.prepareStatement(sql);
			psmt.setInt(1, userId);
			
			result = psmt.executeUpdate();
			
			String message = result > 0 ? "Participant Deleted Successfully" : "Participant Not Deleted. Please Try Again!";
			System.out.println(message);
			
			connection.close();
			System.out.println(TAG + "Connection closed with status : " + connection.isClosed());
		} 
		catch (Exception e)
		{
			System.out.println("An exception has occured : " + e);
		}
		
		return result;
	}
}
