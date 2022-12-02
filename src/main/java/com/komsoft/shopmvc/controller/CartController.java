package com.komsoft.shopmvc.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.komsoft.shopmvc.dto.ProductDto;
import com.komsoft.shopmvc.model.Product;
import com.komsoft.shopmvc.repository.DBManager;

public class CartController extends HttpServlet {

	private static final long serialVersionUID = 8191210582162225292L;

	DBManager menager;

	@Override
	public void init() throws ServletException {
		super.init();
		menager = new DBManager();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String url = "WEB-INF/views/cartpage.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idString = request.getParameter("id");
		String countString = request.getParameter("count");

		try {
			int count = countString == null ? 0 : Integer.parseInt(countString);
			HttpSession session = request.getSession();
			if (session.getAttribute("userCart") == null) {
				session.setAttribute("userCart", new HashMap<Product, Integer>());
			}
			Map<Product, Integer> cart = (Map<Product, Integer>) session.getAttribute("userCart");
			Product product = menager.getOneProduct(idString);
			int quantity = cart.get(product) == null ? 0 : cart.get(product);
			quantity += count;
			cart.put(product, quantity);
			session.setAttribute("userCart", cart);
			System.out.println("Cart has: " + cart);
			response.sendRedirect(request.getHeader("Referer"));

		} catch (NumberFormatException ignored) {
		}
	}

}
