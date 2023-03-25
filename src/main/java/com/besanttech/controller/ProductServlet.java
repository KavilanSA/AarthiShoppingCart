package com.besanttech.controller;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.besanttech.dao.ProductDao;

@WebServlet("/products")
public class ProductServlet extends HttpServlet {
	
	public ProductServlet() {
		
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProductDao productDao = new ProductDao();
		request.setAttribute("products", productDao.getAllProducts());
		request.getRequestDispatcher("views/products.jsp").forward(request, response);
	}
	
}
