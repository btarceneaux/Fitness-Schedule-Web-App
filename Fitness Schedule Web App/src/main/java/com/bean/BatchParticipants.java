package com.bean;

public class BatchParticipants
{
	private int id;
	private int batchId; 
	private int participantId;
	
	public BatchParticipants()
	{
		
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public int getBatchId()
	{
		return batchId;
	}

	public void setBatchId(int batchId)
	{
		this.batchId = batchId;
	}

	public int getParticipantId()
	{
		return participantId;
	}

	public void setParticipantId(int participantId)
	{
		this.participantId = participantId;
	}
}
