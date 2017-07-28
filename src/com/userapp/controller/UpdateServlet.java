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
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(request.getParameter("id"));
		Integer id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String emailId = request.getParameter("email_id");
		String password = request.getParameter("password");
		Boolean active = Boolean.parseBoolean(request.getParameter("active"));

		User user = new User();
		user.setId(id);
		user.setName(name);
		user.setEmailId(emailId);
		user.setPassword(password);
		user.setActive(active);
		UserDAO dao = new UserDAO();
		try {
			dao.update(user);
			response.sendRedirect("ListServlet");
		} catch (Exception e) {
			e.printStackTrace();
			RequestDispatcher rd = request.getRequestDispatcher("edit.jsp");
			request.setAttribute("MESSAGE", e.getMessage());
			rd.forward(request, response);
		}

	}

}
