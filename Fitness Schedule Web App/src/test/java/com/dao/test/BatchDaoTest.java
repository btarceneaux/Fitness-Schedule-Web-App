package com.dao.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Order;
import com.bean.Batch;
import com.dao.BatchDao;
import com.resource.DBResource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Time;

@TestMethodOrder(OrderAnnotation.class)
class BatchDaoTest
{
	BatchDao dao = new BatchDao();
	
	@Test
	@Order(1)
	public void CreateBatchTest()
	{
		Connection connection = DBResource.createConnection();	
		
		@SuppressWarnings("deprecation")
		Time myTime = new Time(8, 0, 0);
		
		Batch myBatch = new Batch();
		myBatch.setBatchDay("Sunday");
		myBatch.setBatchTime(myTime);
		
		int result = dao.createBatch(myBatch);
		assertEquals(1, result);
		
		try
		{
			connection.close();
		} 
		catch (SQLException e)
		{
			System.out.println("An error has occured : " + e);
		}
	}
	
	@Test
	@Order(2)
	public void UpdateBatchTest()
	{
		Connection connection = DBResource.createConnection();	
		
		@SuppressWarnings("deprecation")
		Time myTime = new Time(8, 0, 0);
		
		// First get the existing Batch
		Batch myBatch = dao.getBatchByDayAndTime("Sunday", myTime);
		
		// Next update the batch
		myBatch.setBatchDay("Friday");
		
		int result = dao.updateBatch(myBatch);
		assertEquals(1, result);
		
		try
		{
			connection.close();
		} 
		catch (SQLException e)
		{
			System.out.println("An error has occured : " + e);
		}
	}
	
	@Test
	@Order(3)
	public void getAllBathesTest()
	{
		Connection connection = DBResource.createConnection();	
		
		List<Batch> batchList = new ArrayList<Batch>();
		batchList = dao.getAllBatches();
		
		assertNotEquals(0, batchList.size());
		
		try
		{
			connection.close();
		} 
		catch (SQLException e)
		{
			System.out.println("An error has occured : " + e);
		}
	}
	
	@Test
	@Order(4)
	public void deleteBatchTest()
	{
		Connection connection = DBResource.createConnection();	
		
		@SuppressWarnings("deprecation")
		Time myTime = new Time(8, 0, 0);
		
		// First get the existing Batch
		Batch myBatch = dao.getBatchByDayAndTime("Friday", myTime);
		
		int result = dao.deleteBatch(myBatch.getBatchId());
		assertEquals(1, result);
		
		try
		{
			connection.close();
		} 
		catch (SQLException e)
		{
			System.out.println("An error has occured : " + e);
		}
	}

}
