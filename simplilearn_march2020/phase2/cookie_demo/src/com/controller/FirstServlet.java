package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		Cookie c1=new Cookie("FirstName", fname);
		Cookie c2=new Cookie("City", city);
		Cookie c3=new Cookie("E-mail", email);
		Cookie c4=new Cookie("Contact", contact);
		
		
		response.addCookie(c1);
		response.addCookie(c2);
		response.addCookie(c3);
		response.addCookie(c4);
		
		response.sendRedirect("two.html");
		
		
		
		
	}

}
