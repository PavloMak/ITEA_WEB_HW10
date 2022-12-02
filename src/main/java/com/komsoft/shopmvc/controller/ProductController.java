package com.komsoft.shopmvc.controller;

import com.komsoft.shopmvc.model.Product;
import com.komsoft.shopmvc.repository.DBManager;
import jdk.javadoc.internal.doclets.formats.html.markup.Head;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class ProductController extends HttpServlet {

	DBManager menager;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String category = request.getParameter("category");
		List<Product> products = menager.getAllProduct(category);

		request.setAttribute("products", products);
		String url = "WEB-INF/views/products.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	@Override
	public void init() throws ServletException {
		super.init();
		menager = new DBManager();
	}

}
