package com.besanttech.controller;


	import java.io.IOException;
	import java.util.ArrayList;
	import java.util.List;

	import javax.servlet.RequestDispatcher;
	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	import javax.servlet.http.HttpSession;

	import com.besanttech.dao.ProductDao;
	import com.besanttech.entities.Product;

	@WebServlet("/cart")
	public class CartServlet extends HttpServlet {

		public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			String action = request.getParameter("action");
			if (action == null) {
				request.getRequestDispatcher("views/cart.jsp").forward(request, response);
			} else if (action.equals("add")) {
				HttpSession session = request.getSession(false);
				List<Product> cartProducts = (List<Product>) session.getAttribute("cartProducts");
				if (cartProducts == null) {
					cartProducts = new ArrayList<>();
				}
				ProductDao productDao = new ProductDao();
				Product product = productDao.getProductById(Integer.parseInt(request.getParameter("product_id")));
				if (product != null) {
					cartProducts.add(product);
					session.setAttribute("cartProducts", cartProducts);
					updateCartPrice(cartProducts,session);
				}
				
				
				RequestDispatcher rd = request.getRequestDispatcher("/products");
				rd.forward(request, response);

			} else if (action.equals("remove")) {
				HttpSession session = request.getSession(false);
				List<Product> cartProducts = (List<Product>) session.getAttribute("cartProducts");
				for (Product product : cartProducts) {
					if (product.getId() == Integer.parseInt(request.getParameter("product_id"))) {
						cartProducts.remove(product);
						session.setAttribute("cartProducts", cartProducts);
						updateCartPrice(cartProducts,session);
						break;
					}
				}

				RequestDispatcher rd = request.getRequestDispatcher("views/cart.jsp");
				rd.forward(request, response);
			}
		}
		
		public void updateCartPrice(List<Product> cartProducts, HttpSession session) {
			float price =0;
			for(Product product: cartProducts) {
				price = (float) (price + product.getPrice());
			}
		
			session.setAttribute("cartPrice", price);
		}
	}

