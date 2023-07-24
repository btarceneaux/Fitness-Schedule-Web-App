package com.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.bean.BatchParticipants;
import com.bean.Participant;
import com.service.BatchParticipantsService;
import com.service.ParticipantService;

/**
 * Servlet implementation class ParticipantController
 */
public class ParticipantController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    ParticipantService service = new ParticipantService();
    BatchParticipantsService bpService = new BatchParticipantsService();
	
    public ParticipantController() {
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
		case "/deleteParticipant":
			RequestDispatcher rdParticipant = request.getRequestDispatcher("participants.jsp");
			
			//Get the batch that needs to be deleted.
			int result = service.deleteParticipant(id);
			
			if(result == 1)
			{
				System.out.println("Participant Deleted Successfully!");
				rdParticipant.forward(request, response);
			}
			
			break;
		case "/updateParticipant":
			HttpSession session = request.getSession();
			session.setAttribute("participantId", id);
			
			RequestDispatcher updParticipant = request.getRequestDispatcher("updateParticipant.jsp");
			updParticipant.forward(request, response);
		default:
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("emailAddress");
		String password = request.getParameter("password");
		String batchIdString = request.getParameter("batchId");
		
		String action = request.getServletPath();
		
		Participant participant = new Participant();
		participant.setFirstName(firstName);
		participant.setLastName(lastName);
		participant.setEmail(email);
		participant.setPassword(password);
		
		
		switch (action)
		{
		case "/updateExistingParticipant":
			String[] stringArray = batchIdString.split(" ");
			String batchId = stringArray[0];
			
			int id = Integer.parseInt(request.getParameter("id"));
			participant.setUserId(id);
			
			BatchParticipants myBatchParticipant = new BatchParticipants();
			myBatchParticipant.setBatchId(Integer.parseInt(batchId));
			myBatchParticipant.setParticipantId(id);
			myBatchParticipant.setParticipantFirstName(firstName);
			myBatchParticipant.setParticipantLastName(lastName);
			
			int updateResult = service.updateParticipant(participant);
			int addToBatchResult = bpService.createBatchParticipant(myBatchParticipant);
			
			if(updateResult == 1)
			{
				System.out.println("Participant updated successfully");
				if (addToBatchResult == 1)
				{
					System.out.println("Participant added to batch");
				}
				else
				{
					System.out.println("Participant not added to batch.");
				}
				response.sendRedirect("participants.jsp");
			}
			else
			{
				System.out.println("Something went wrong! Please try again!");
			}
			
			break;

		default:
			int result = service.createParticipant(participant);
			
			if(result == 1)
			{
				System.out.println("Participant created successfully");
				
				response.sendRedirect("participants.jsp");
			}
			else
			{
				System.out.println("Something went wrong! Please try again!");
			}
			
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
