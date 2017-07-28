package com.userapp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.userapp.dao.UserDAO;
import com.userapp.model.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String emailId = request.getParameter("email_id");
		String password = request.getParameter("password");

		User user = new User();
		user.setEmailId(emailId);
		user.setPassword(password);

		UserDAO dao = new UserDAO();
		try {
			User userObject = dao.findByEmailAndPassword(user);
			System.out.println(userObject);
			if (userObject != null) {
				String name = userObject.getName();
				HttpSession session = request.getSession();
				session.setAttribute("NAME", name);
				response.sendRedirect("ListServlet");
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				request.setAttribute("MESSAGE", "Invalid User. Try Again!");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			request.setAttribute("MESSAGE", e.getMessage());
			rd.forward(request, response);
		}

	}

}
