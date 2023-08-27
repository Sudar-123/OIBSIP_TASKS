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


@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
					String name = request.getParameter("uname");
					String email = request.getParameter("email");
					String password = request.getParameter("password");
					
					User user = new User();
					user.setName(name);
					user.setEmail(email);
					user.setPassword(password);
					
					
					UserDAO dao = new UserDAO( DBConnect.getConnection());
					boolean f = dao.userRegister(user);
					
					if (true) {
						
//							PrintWriter out =response.getWriter();
//							out.print("Data Inserted Successfully");
							
							HttpSession session  = request.getSession();
							session.setAttribute("reg-msg", "Registration Sucessfully..");
							response.sendRedirect("register.jsp");
						
					} else {
//						PrintWriter out =response.getWriter();
//						out.print("Data not Inserted Successfully");
						
						HttpSession session  = request.getSession();
						session.setAttribute("error-msg", "Something went wrong");
						response.sendRedirect("register.jsp");
					}
					
					
	}

}
