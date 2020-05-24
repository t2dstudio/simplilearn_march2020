package com.login.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SuccessServlet
 */
public class SuccessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuccessServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
	//	out.print("<h3>Welcome "+request.getParameter("userid")+"</h3>");
		HttpSession session=request.getSession(false);
		if(session==null) {
			out.print("Please login first");
		}else {
		out.print("<h3>Welcome "+session.getAttribute("userid")+"</h3>");
		out.print("<h3>You have logged in successfully at "+new SimpleDateFormat("dd/MMMM/yyyy HH:mm:ss").format(new Date())+"</h3>");
		out.print("<a href='logout'>LOGOUT</a>");}
		
	}

}
