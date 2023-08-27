package com.oibsip.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oibsip.DAO.UserDAO;
import com.oibsip.Database.DBConnect;
import com.oibsip.entity.User;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		UserDAO dao = new UserDAO(DBConnect.getConnection());
		User user = dao.getLogin(email, password);
		
		if (user!=null) {
			
//			PrintWriter out =response.getWriter();
//			out.print("Login Successfully");
			
			HttpSession session = request.getSession();
			session.setAttribute("user-ob", user);
			response.sendRedirect("home.jsp");
			
		}else {
			
//			PrintWriter out =response.getWriter();
//			out.print("Invalid Password");
			
			HttpSession session = request.getSession();
			session.setAttribute("error-msg", "Invalid email & password");
			response.sendRedirect("login.jsp");
		}
		
		
	}

}
