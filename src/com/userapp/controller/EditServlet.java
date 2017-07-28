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
 * Servlet implementation class EditServlet
 */
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Integer id = Integer.parseInt(request.getParameter("id"));

		UserDAO dao = new UserDAO();
		try {
			User user = dao.findOne(id);
			RequestDispatcher rd = request.getRequestDispatcher("edit.jsp");
			request.setAttribute("USER", user);
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			RequestDispatcher rd = request.getRequestDispatcher("list.jsp");
			request.setAttribute("MESSAGE", e.getMessage());
			rd.forward(request, response);
		}

	}

}
