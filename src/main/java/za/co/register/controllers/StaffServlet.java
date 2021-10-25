package za.co.register.controllers;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import za.co.register.models.Staff;
import za.co.register.models.User;
import za.co.register.services.StaffService;
//import za.co.register.models.User;

public class StaffServlet extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
	}




	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String phoneNumber = request.getParameter("phoneNumber");
		String confirmationPassword = request.getParameter("confirmationPassword");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
StaffService staffservice=new StaffService();
Staff staff=new Staff(firstName,lastName,email,phoneNumber);
	User user=new User(username,password);
	
	staffservice.registerStaff(staff, user);
	
	request.setAttribute("user", user);
	request.setAttribute("staff", staff);
	String error ="password dont match";
	
	if(password.equals(confirmationPassword)) {
		request.getRequestDispatcher("/staffRegistrationSucess.jsp").forward(request,response);
		
		
	}else {
		request.setAttribute("error",error);
		request.getRequestDispatcher("/registerStaff.jsp").forward(request, response);
		
	}
	
	

	
	
 
}
}