package invoice.controller;

import invoice.model.AccessParts;
import invoice.model.AuthenticationModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;

public class PartsController extends HttpServlet {
	private static final long serialVersionUID = -4005026852514057123L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ResultSet partSet;
		AccessParts parts = new AccessParts();
		if(parts.retrieveParts()) {
			partSet = parts.getParts();
			request.setAttribute("parts", partSet);
			RequestDispatcher dispatch = request.getRequestDispatcher("parts.jsp");
			dispatch.forward(request, response);
		} else {
			request.setAttribute("message", "test");
			RequestDispatcher dispatch = request.getRequestDispatcher("error/login_error.jsp");
			dispatch.forward(request, response);
		}
	}
}
