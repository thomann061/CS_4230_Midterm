package invoice.controller;

import invoice.model.AuthenticationModel;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = -4005026852514057123L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		
		String token = AuthenticationModel.getLoginToken(name, password);

		RequestDispatcher dispatch = request.getRequestDispatcher("error/login_error.jsp");
		if (token != null) {
			dispatch = request.getRequestDispatcher("main.jsp");
			request.setAttribute("message", "test");
		}
		else {
			request.setAttribute("error", "Login for user '" + name + "' was incorrect.");
		}
		
		dispatch.forward(request, response);
	}
}
