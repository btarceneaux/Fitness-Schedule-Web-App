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
import java.util.List;
import com.service.BatchService;
import com.bean.Batch;

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
		response.setContentType("text/html");
		HttpSession hs = request.getSession();
		
		List<Batch> batchList = batchService.getAllBatches();
		hs.setAttribute("batchList",batchList);
		response.sendRedirect("batches.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String day = request.getParameter("day");
		String time = request.getParameter("time");
		
		PrintWriter pw = response.getWriter();
		
		int hour = 0;
		
		System.out.println(day);
		System.out.println(time);
		
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
		Batch myBatch = new Batch();
		myBatch.setBatchDay(day);
		myBatch.setBatchTime(scheduleTime);
		
		int result = batchService.createBatch(myBatch);
		
		RequestDispatcher rdUser = request.getRequestDispatcher("batches.jsp");
		
		if(result == 1)
		{
			pw.println("The batch was successfully created");
		}
		else
		{
			pw.println("The batch was not created. Please try again.");
		}
		rdUser.include(request, response);
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
