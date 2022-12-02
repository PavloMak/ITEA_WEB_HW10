package com.komsoft.shopmvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.komsoft.shopmvc.model.Product;
import com.komsoft.shopmvc.repository.DBManager;

public class SingleProductController extends HttpServlet{

	private static final long serialVersionUID = -8682903797858057744L;
	DBManager menager;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String pId = request.getParameter("prid");
		Product product = menager.getOneProduct(pId);

		request.setAttribute("product", product);
		String url = "WEB-INF/views/product.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
	
	@Override
	public void init() throws ServletException {
		super.init();
		menager = new DBManager();
	}

}
