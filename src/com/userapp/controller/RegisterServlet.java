package com.userapp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.userapp.dao.UserDAO;
import com.userapp.model.User;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String emailId = request.getParameter("email_id");
		String password = request.getParameter("password");

		User user = new User();
		user.setName(name);
		user.setEmailId(emailId);
		user.setPassword(password);
		try {
			UserDAO dao = new UserDAO();
			dao.save(user);
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			request.setAttribute("MESSAGE", "Successfully Registerd.Login to Continue.");
			rd.forward(request, response);
		} catch (Exception e) {
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			request.setAttribute("MESSAGE", e.getMessage());
			rd.forward(request, response);
		}

	}

}
