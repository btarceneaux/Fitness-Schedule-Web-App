package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.List;
import com.bean.Batch;
import com.resource.DBResource;
import java.util.ArrayList;

public class BatchDao
{
	final String TAG = getClass().getSimpleName();
	String username = System.getenv("DBUN");
	String password = System.getenv("DBPW");
	String url = System.getenv("BASEURL") + "fitness_schedule";
	
	public Batch getBatch(int batchId)
	{
		Batch myBatch = new Batch();
		
		try
		{	
			Connection connection = DBResource.createConnection();		
			String sql = "SELECT "
					+    "batch_id "
					+    "batch_day "
					+    "batch_time "
					+    "FROM batch "
					+    "WHERE batch_id = ?;";
			
			PreparedStatement psmt = connection.prepareStatement(sql);
			psmt.setInt(1, batchId);
			
			ResultSet rs = psmt.executeQuery();
			
			while(rs.next())
			{
				myBatch.setBatchId(rs.getInt("batch_id"));
				myBatch.setBatchDay(rs.getString("batch_day"));
				myBatch.setBatchTime(rs.getTime("batch_time"));
			}
			
			connection.close();
		} 
		catch (Exception e)
		{
			System.out.println("An error has occured : " + e);
		}
		
		return myBatch;
	}
	
	
	public Batch getBatchByDayAndTime(String day, Time time)
	{
		Batch myBatch = new Batch();
		
		try
		{
			Connection connection = DBResource.createConnection();	
			
			String sql = 
					"SELECT "
					+ "batch_id, "
					+ "batch_day, "
					+ "batch_time "
					+ "FROM batch "
					+ "WHERE batch_day = ? "
					+ "AND batch_time = ?;";
			
			PreparedStatement psmt = connection.prepareStatement(sql);
			psmt.setString(1, day);
			psmt.setTime(2, time);
			
			ResultSet rs = psmt.executeQuery();
			
			while(rs.next())
			{
				myBatch.setBatchId(rs.getInt("batch_id"));
				myBatch.setBatchDay(rs.getString("batch_day"));
				myBatch.setBatchTime(rs.getTime("batch_time"));
			}
			
			connection.close();
			
		} 
		catch (Exception e)
		{
			System.out.println("An error has occured : " + e);
		}
		
		return myBatch;
	}
	
	
	public static List<Batch> getAllBatches()
	{
		List<Batch> batchList = new ArrayList<Batch>();
		
		try
		{	
			Connection connection = DBResource.createConnection();
			
			PreparedStatement psmt = connection.prepareStatement(
					"SELECT "
					+ "batch_id, "
					+ "batch_day, "
					+ "batch_time "
					+ "FROM batch "
					+ "ORDER BY batch_id;");
			
			ResultSet rs = psmt.executeQuery();
			
			while(rs.next())
			{
				Batch batch = new Batch();
				
				batch.setBatchId(rs.getInt("batch_id"));
				batch.setBatchDay(rs.getString("batch_day"));
				batch.setBatchTime(rs.getTime("batch_time"));
				
				batchList.add(batch);
			}
			
			connection.close();
		} 
		catch (Exception e)
		{
			System.out.println("An exception has occured : " + e);
		}
		
		return batchList;
	}
	
	
	public int createBatch(Batch batch)
	{
		int result = 0;
		
		try
		{	
			Connection connection = DBResource.createConnection();
			
			String day = batch.getBatchDay().toString();
			String sql = "INSERT INTO batch VALUES(null, ?, ?);";
			PreparedStatement psmt = connection.prepareStatement(sql);
			
			
			
			psmt.setString(1, day);
			psmt.setTime(2, batch.getBatchTime());
			
			
			
			result = psmt.executeUpdate();
			
			String message = result > 0 ? "Batch Created Successfully" : "Batch Not Created. Please Try Again!";
			System.out.println(message);
			
			connection.close();
		} 
		catch (Exception e)
		{
			System.out.println("An exception has occured : " + e);
		}
		
		return result;
	}
	
	public int updateBatch(Batch batch)
	{
		int result = 0;
		
		try
		{	
			Connection connection = DBResource.createConnection();
			
			String sql = "UPDATE batch SET "
					+ "batch_day = ?, "
					+ "batch_time = ? "
					+ "WHERE batch_id = ?;";
			
			PreparedStatement psmt = connection.prepareStatement(sql);
			psmt.setString(1, batch.getBatchDay());
			psmt.setTime(2, batch.getBatchTime());
			psmt.setInt(3, batch.getBatchId());
			
			result = psmt.executeUpdate();
			String message = result > 0 ? "Batch Updated Successfully" : "Batch Not Updated. Please Try Again!";
			System.out.println(message);
			
			connection.close();
		}
		catch(Exception e)
		{
			System.out.println("An exception has occured : " + e);
		}
		
		return result;
	}
	
	
	public int deleteBatch(int batchId)
	{
		int result = 0;
		
		try
		{	
			Connection connection = DBResource.createConnection();
			
			String sql = "DELETE FROM batch WHERE batch_id = ?";
			PreparedStatement psmt = connection.prepareStatement(sql);
			psmt.setInt(1, batchId);
			
			result = psmt.executeUpdate();
			
			String message = result > 0 ? "Batch Deleted Successfully" : "Batch Not Deleted. Please Try Again!";
			System.out.println(message);
			
			connection.close();
		} 
		catch (Exception e)
		{
			System.out.println("An exception has occured : " + e);
		}
		
		return result;
	}
}
