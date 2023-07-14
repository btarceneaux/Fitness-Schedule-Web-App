package com.bean;

import java.sql.Time;

public class Batch
{
	private int batchId;
	private String batchDay;
	private Time batchTime;
	
	public Batch()
	{
		
	}

	public int getBatchId()
	{
		return batchId;
	}

	public void setBatchId(int batchId)
	{
		this.batchId = batchId;
	}

	public String getBatchDay()
	{
		return batchDay;
	}

	public void setBatchDay(String batchDay)
	{
		this.batchDay = batchDay;
	}

	public Time getBatchTime()
	{
		return batchTime;
	}

	public void setBatchTime(Time batchTime)
	{
		this.batchTime = batchTime;
	}

}
