package com.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Time;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import com.service.BatchService;
import com.bean.Batch;
import com.dao.BatchDao;

/**
 * Servlet implementation class BatchController
 */
public class BatchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	BatchService batchService = new BatchService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BatchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getServletPath();
		int id = Integer.parseInt(request.getParameter("id"));
		
		switch (action)
		{
		case "/deleteBatch":
			RequestDispatcher rdBatch = request.getRequestDispatcher("batches.jsp");
			
			//Get the batch that needs to be deleted.
			int result = batchService.deleteBatch(id);
			rdBatch.forward(request, response);
			
			break;
		case "/updateBatch":
			HttpSession session = request.getSession();
			session.setAttribute("batchId", id);
			
			RequestDispatcher udBatch = request.getRequestDispatcher("updateBatch.jsp");
			udBatch.forward(request, response);
		default:
			break;
		}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String day = request.getParameter("day");
		String time = request.getParameter("time");
		String action = request.getServletPath();
		int hour = 0;
		
		String[] stringarray = time.split(":");
		if(stringarray[1].equals("00am") || (stringarray[0].equals("12") && stringarray[1].equals("00pm")))
		{
			hour = Integer.parseInt(stringarray[0]);
		}
		else
		{
			hour = Integer.parseInt(stringarray[0]) + 12;
		}
		
		Time scheduleTime = new Time(hour, 0, 0);
		PrintWriter pw = response.getWriter();
		
		switch (action)
		{
		case "/updateExistingBatch":
			String id = request.getParameter("id");
			int myBatchId = Integer.parseInt(id);
			
			Batch updatedBatch = new Batch();
			updatedBatch.setBatchDay(day);
			updatedBatch.setBatchTime(scheduleTime);
			updatedBatch.setBatchId(myBatchId);
			
            int updateResult = batchService.updateBatch(updatedBatch);
			
			if(updateResult == 1)
			{
				System.out.println("The batch was successfully created");
			}
			else
			{
				System.out.println("The batch was not created");
			}
			
			RequestDispatcher upeBatch = request.getRequestDispatcher("batches.jsp");
			upeBatch.forward(request, response);
			
			break;
		default:
			Batch myBatch = new Batch();
			myBatch.setBatchDay(day);
			myBatch.setBatchTime(scheduleTime);
			
			int result = batchService.createBatch(myBatch);
			
			RequestDispatcher rdUser = request.getRequestDispatcher("index.html");
			
			if(result == 1)
			{
				pw.println("The batch was successfully created");
			}
			else
			{
				pw.println("The batch was not created. Please try again.");
			}
			
//			rdUser.include(request, response);
			response.sendRedirect("index.html");
			
			break;
		}		
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
