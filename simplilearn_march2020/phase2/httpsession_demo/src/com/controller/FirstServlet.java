package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.User;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/first")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String fname=request.getParameter("fname");
		String city=request.getParameter("city");
		String email=request.getParameter("email");
		String contact=request.getParameter("contact");
		
		User user=new User();
		user.setFname(fname);
		user.setContact(contact);
		user.setEmail(email);
		user.setCity(city);
		
		HttpSession session=request.getSession(); // it will create a new session
		// or you can also use getSession(true) which is overloaded method and even it would do the same
		session.setAttribute("user", user);
		response.sendRedirect("two.html");
		
		
		
		
	}

}
