package com.service;

import java.sql.Time;
import java.util.List;
import com.bean.Batch;
import com.dao.BatchDao;

public class BatchService 
{
	BatchDao dao = new BatchDao();
	
	public List<Batch> getAllBatches()
	{
		return BatchDao.getAllBatches();
	}
	
	public int createBatch(Batch batch)
	{
		int result = dao.createBatch(batch);
		
		return result;
	}
	
	public int deleteBatch(int batchId)
	{
		int result = dao.deleteBatch(batchId);
		
		return result;
	}
	
	public int updateBatch(Batch batch)
	{
		int result = dao.updateBatch(batch);
		
		return result;
	}
	
	public Batch getBatchByDayAndTime(String day, Time time)
	{
		Batch myBatch = dao.getBatchByDayAndTime(day, time);
		
		return myBatch;
	}
}