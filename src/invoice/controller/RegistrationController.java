package invoice.controller;

import invoice.model.AuthenticationModel;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = -5674924737330186469L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName"); 
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("error/register_error.jsp");
		try {
			AuthenticationModel.registerUser(username, password, firstName, lastName);
			
			dispatcher = request.getRequestDispatcher("main.jsp");
		} catch (Exception e) {
			request.setAttribute("error", e.toString());
			e.printStackTrace();
		}
		
		dispatcher.forward(request, response);
	}
}
