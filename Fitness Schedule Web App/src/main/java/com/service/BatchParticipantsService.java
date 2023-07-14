package com.service;

import java.util.List;

import com.bean.BatchParticipants;
import com.dao.BatchParticipantDao;

public class BatchParticipantsService
{
	BatchParticipantDao dao = new BatchParticipantDao();
	
	public List<BatchParticipants> getAllBatchParticipants()
	{
		return dao.getAllBatchParticipants();
	}
	
	public List<BatchParticipants> getAllParticipantsFromSpecificBatch(int batchParticipantId)
	{
		return dao.getBatchParticipant(batchParticipantId);
	}
	
	public BatchParticipants getBatchParticipantIsIn(int participantId)
	{
		return dao.getBatchParticipantByParticipantId(participantId);
	}
	
	public int createBatchParticipant(BatchParticipants myBatchParticipant)
	{
		return dao.createBatchParticipant(myBatchParticipant);
	}
	
	public int updateBatchParticipants(BatchParticipants myBatchParticipant)
	{
		return dao.updateBatchParticipant(myBatchParticipant);
	}
	
	public int deleteBatchParticipantsFromBatch(int batchParticipantsId)
	{
		return dao.deleteBatchParticipantFromBatch(batchParticipantsId);
	}
	
	public int deleteParticipantFromBatch(int participantId)
	{
		return dao.deleteBatchParticipantFromBatch(participantId);
	}
}
