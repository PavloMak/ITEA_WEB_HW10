package com.komsoft.shopmvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainPageController extends HttpServlet {

	private static final long serialVersionUID = 2974588900643780667L;
	RequestDispatcher dispatcher = null;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		String url = "WEB-INF/views/mainpage.jsp";

		dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}
}
