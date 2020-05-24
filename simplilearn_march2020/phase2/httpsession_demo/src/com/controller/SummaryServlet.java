package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.User;

/**
 * Servlet implementation class SummaryServlet
 */
@WebServlet("/summary")
public class SummaryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SummaryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession session = Reusable.createSession(request);
		PrintWriter out=response.getWriter();
		if (session == null) {
			
			out.print("<h3 style='color:red'>You should access this app from first page only</h3>");
			out.print("<a href='/httpsession_demo'>Click Here</a>");
		} else {
		String certification=request.getParameter("certification");
		String yoc=request.getParameter("yoc");
		String valid=request.getParameter("valid");
		User user=(User)session.getAttribute("user");
		user.setCertificationName(certification);
		user.setYearOfCertification(Integer.parseInt(yoc));
		user.setValidity(Integer.parseInt(valid));
		
		out.print("<h4>Hello "+user.getFname()+" below are your details</h4>");
		out.print("<h4>"+user+"</h4>");
		out.print("<h5>Id = "+session.getId()+"</h5>");
		out.print("<h5>session creation time - "+new Date(session.getCreationTime())+"</h5>");
		session.invalidate();// will destroy the session
		out.print("<h5>session object after invalidate() "+session);
		//session.setMaxInactiveInterval(interval); 
		//after the inactive seconds is expired the session will be destroy or invalidate
		//session.getMaxInactiveInterval() reading the inactive interval

		}
	}

}
