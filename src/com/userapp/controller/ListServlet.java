package com.userapp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.userapp.dao.UserDAO;
import com.userapp.model.User;

/**
 * Servlet implementation class ListServlet
 */
@WebServlet("/ListServlet")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserDAO dao = new UserDAO();
		try {
			List<User> users = dao.findAll();
			if (!users.isEmpty()) {
				RequestDispatcher rd = request.getRequestDispatcher("list.jsp");
				request.setAttribute("usersList", users);
				rd.forward(request, response);
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("list.jsp");
				request.setAttribute("MESSAGE", "No Users Found. Add User.");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			request.setAttribute("MESSAGE", e.getMessage());
			rd.forward(request, response);
		}

	}

}
