package com.bean;

public class BatchParticipants
{
	private int id;
	private int batchId; 
	private int participantId;
	private String participantLastName;
	private String participantFirstName;
	
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

	public String getParticipantLastName()
	{
		return participantLastName;
	}

	public void setParticipantLastName(String participantLastName)
	{
		this.participantLastName = participantLastName;
	}

	public String getParticipantFirstName()
	{
		return participantFirstName;
	}

	public void setParticipantFirstName(String participantFirstName)
	{
		this.participantFirstName = participantFirstName;
	}
	
	
}
