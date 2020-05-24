package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SecondServlet
 */
@WebServlet("/second")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SecondServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String qualification=request.getParameter("qualification");
		String year=request.getParameter("year");
		String university=request.getParameter("university");
		
		
		Cookie c1=new Cookie("Qualification", qualification);
		Cookie c2=new Cookie("GraduattionYear", year);
		Cookie c3=new Cookie("UniversityOrCollegeName", university);
		
		
		
		response.addCookie(c1);
		response.addCookie(c2);
		response.addCookie(c3);
		
		
		response.sendRedirect("three.html");
	}

}
