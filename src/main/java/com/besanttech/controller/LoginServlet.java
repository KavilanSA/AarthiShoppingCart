package com.besanttech.controller;

	import java.io.IOException;
	import java.io.PrintWriter;

	import javax.servlet.RequestDispatcher;
	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	import javax.servlet.http.HttpSession;

	import com.besanttech.dao.UserDao;
	import com.besanttech.entities.User;

	@WebServlet("/login")
	public class LoginServlet extends HttpServlet {
		public void doPost(HttpServletRequest req, HttpServletResponse res) {

			try {
				res.setContentType("text/html");
				PrintWriter out = res.getWriter();
				User user = new User();
				user.setUserName((String) req.getParameter("username"));
				user.setPassword((String) req.getParameter("userpass"));
				UserDao userDao = new UserDao();
				if (userDao.getUserDetails(user) != null) {
					// create session for the logged in user
					HttpSession session = req.getSession();
					session.setAttribute("username", user.getUserName());
					RequestDispatcher rd = req.getRequestDispatcher("views/home.jsp");
					rd.forward(req, res);
				} else {
					out.println("please check username and password<br/>");
					RequestDispatcher rd = req.getRequestDispatcher("views/login.jsp");
					rd.include(req, res);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}


