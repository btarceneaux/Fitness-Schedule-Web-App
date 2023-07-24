package com.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.bean.BatchParticipants;
import com.resource.DBResource;
import java.sql.DriverManager;


public class BatchParticipantDao
{
	final String TAG = getClass().getSimpleName();
	String username = System.getenv("DBUN");
	String password = System.getenv("DBPW");
	String url = System.getenv("BASEURL") + "fitness_schedule";
	
	public static List<BatchParticipants> getBatchParticipant(int batchParticipantsId)
	{
		List<BatchParticipants> batchParticipantList = new ArrayList<BatchParticipants>();
		
		try
		{	
			Connection connection = DBResource.createConnection();
			
			System.out.println("Connection created.");
			
			String sql = "SELECT "
					+    "id, "
					+    "batch_id, "
					+    "participant_id, "
					+    "participant_first_name, "
					+    "participant_last_name "
					+    "FROM batch_participants "
					+    "WHERE batch_id = ?;";
			
			PreparedStatement psmt = connection.prepareStatement(sql);
			psmt.setInt(1, batchParticipantsId);
			
			ResultSet rs = psmt.executeQuery();
			
			while(rs.next())
			{
				BatchParticipants myBatchParticipant = new BatchParticipants();
				
				myBatchParticipant.setId(rs.getInt("id"));
				myBatchParticipant.setBatchId(rs.getInt("batch_id"));
				myBatchParticipant.setParticipantId(rs.getInt("participant_id"));
				myBatchParticipant.setParticipantFirstName(rs.getString("participant_first_name"));
				myBatchParticipant.setParticipantLastName(rs.getString("participant_last_name"));
				
				batchParticipantList.add(myBatchParticipant);
			}
			
			connection.close();
		} 
		catch (Exception e)
		{
			System.out.println("An error has occured : " + e);
		}
		
		return batchParticipantList;
	}
	
	
	public BatchParticipants getBatchParticipantByParticipantId(int participantId)
	{
		BatchParticipants myBatchParticipant = new BatchParticipants();
		
		try
		{
			Connection connection = DBResource.createConnection();
			
			System.out.println("Connection created.");
			
			String sql = "SELECT "
					+    "id, "
					+    "batch_id, "
					+    "participant_id "
					+    "FROM batch_participants "
					+    "WHERE id = ?;";
			
			PreparedStatement psmt = connection.prepareStatement(sql);
			psmt.setInt(1, participantId);
			
			ResultSet rs = psmt.executeQuery();
			
			connection.close();
			System.out.println(TAG + "Connection closed with status : " + connection.isClosed());
			
			while(rs.next())
			{
				myBatchParticipant.setId(rs.getInt("id"));
				myBatchParticipant.setBatchId(rs.getInt("batch_id"));
				myBatchParticipant.setParticipantId(rs.getInt("participant_id"));
			}
		} 
		catch (Exception e)
		{
			System.out.println("An error has occured : " + e);
		}
		
		return myBatchParticipant;
	}
	
	
	public static List<BatchParticipants> getAllBatchParticipants()
	{
		List<BatchParticipants> myBatchParticipantList = new ArrayList<BatchParticipants>();
		
		try
		{
			Connection connection = DBResource.createConnection();
			
			System.out.println("Connection created.");
			
			PreparedStatement psmt = connection.prepareStatement(
					  "SELECT "
					+ "id, "
					+ "batch_id, "
					+ "participant_id,"
					+ "participant_last_name,"
					+ "participant_first_name "
					+ "FROM batch_participants "
					+ "ORDER BY participant_last_name, participant_first_name;");
			
			ResultSet rs = psmt.executeQuery();
			
			while(rs.next())
			{
				BatchParticipants myBatchParticipant = new BatchParticipants();
				
				myBatchParticipant.setId(rs.getInt("id"));
				myBatchParticipant.setId(rs.getInt("batch_id"));
				myBatchParticipant.setId(rs.getInt("participant_id"));
				myBatchParticipant.setParticipantLastName(rs.getString("participant_last_name"));
				myBatchParticipant.setParticipantFirstName(rs.getString("participant_first_name"));
				
				myBatchParticipantList.add(myBatchParticipant);
			}
			
			connection.close();
		} 
		catch (Exception e)
		{
			System.out.println("An exception has occured : " + e);
		}
		
		return myBatchParticipantList;
	}
	
	public int createBatchParticipant(BatchParticipants batchParticipant)
	{
		int result = 0;
		
		try
		{
			Connection connection = DBResource.createConnection();
			
			System.out.println("Connection created.");
			
			String sql = "INSERT INTO batch_participants VALUES(null, ?, ?, ?, ?)";
			PreparedStatement psmt = connection.prepareStatement(sql);
			
			psmt.setInt(1, batchParticipant.getBatchId());
			psmt.setInt(2, batchParticipant.getParticipantId());
			psmt.setString(3, batchParticipant.getParticipantFirstName());
			psmt.setString(4, batchParticipant.getParticipantLastName());
			
			result = psmt.executeUpdate();
			
			String message = result > 0 ? "Batch Participant Added Successfully" : "Batch Participant Not Added. Please Try Again!";
			System.out.println(message);
			
			connection.close();
		} 
		catch (Exception e)
		{
			System.out.println("An exception has occured : " + e);
		}
		
		return result;
	}
	
	
	public int updateBatchParticipant(BatchParticipants batchParticipant)
	{
		int result = 0;
		
		try
		{
			Connection connection = DBResource.createConnection();
			
			System.out.println("Connection created.");
			
			String sql = "UPDATE batch_participants SET "
					+    "batch_id = ?, "
					+    "participant_id = ? "
					+    "WHERE id = ?;";
			
			PreparedStatement psmt = connection.prepareStatement(sql);
			
			psmt.setInt(1, batchParticipant.getBatchId());
			psmt.setInt(2, batchParticipant.getParticipantId());
			psmt.setInt(3, batchParticipant.getId());
			
			result = psmt.executeUpdate();
			
			String message = result > 0 ? "Batch Participant Updated Successfully" : "Batch Participant Not Updated. Please Try Again!";
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
	
	
	public int deleteBatchParticipants(int batchParticipantsId)
	{
		int result = 0;
		
		try
		{
			Connection connection = DBResource.createConnection();
			
			System.out.println("Connection created.");
			
			String sql = "DELETE FROM batch_participants WHERE id = ?;";
			
			PreparedStatement psmt = connection.prepareStatement(sql);
			
			psmt.setInt(1, batchParticipantsId);
			
			result = psmt.executeUpdate();
			
			String message = result > 0 ? "Batch Participant Deleted Successfully" : "Batch Participant Not Deleted From Batch. Please Try Again!";
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
	
	public int deleteBatchParticipantFromBatch(int participantId)
	{
		int result = 0;
		
		try
		{
			Connection connection = DBResource.createConnection();
			
			System.out.println("Connection created.");
			
			String sql = "DELETE FROM batch_participants WHERE participant_id = ?;";
			
			PreparedStatement psmt = connection.prepareStatement(sql);
			
			psmt.setInt(1, participantId);
			
			result = psmt.executeUpdate();
			
			String message = result > 0 ? "Batch Participant Deleted Successfully" : "Batch Participant Not Deleted From Batch. Please Try Again!";
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
