package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.bean.Participant;
import com.service.ParticipantService;

/**
 * Servlet implementation class ParticipantController
 */
public class ParticipantController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    ParticipantService service = new ParticipantService();
	
    public ParticipantController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("emailAddress");
		String password = request.getParameter("password");
		
		Participant participant = new Participant();
		participant.setFirstName(firstName);
		participant.setLastName(lastName);
		participant.setEmail(email);
		participant.setPassword(password);
		
		int result = service.createParticipant(participant);
		
		String message = "";
		if(result == 1)
		{
			System.out.println("Participant created successfully");
			message = "Participant created successfully";
		}
		else
		{
			System.out.println("Something went wrong! Please try again!");
			message = "Something went wrong! Please try again!";
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
