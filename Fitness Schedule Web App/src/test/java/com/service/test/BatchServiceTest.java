package com.service.test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.ArrayList;
import com.bean.Batch;
import org.junit.jupiter.api.Test;

import com.service.BatchService;

class BatchServiceTest
{
	BatchService service = new BatchService();

	@Test
	public void getAllBatchesTest()
	{
		List<Batch> batchList = new ArrayList<Batch>();
		batchList = service.getAllBatches();
		
		assertEquals(20, batchList.size());
	}

}
