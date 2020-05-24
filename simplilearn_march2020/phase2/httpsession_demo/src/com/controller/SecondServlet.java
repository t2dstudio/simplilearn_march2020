package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.User;

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
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession session = request.getSession(false);
		// this will not create a new session and if there is active session running
		// this servlet will
		// be participating or will be part of that session
		if (session == null) {
			PrintWriter out=response.getWriter();
			out.print("<h3 style='color:red'>You should access this app from first page only</h3>");
			out.print("<a href='/httpsession_demo'>Click Here</a>");
		} else {

			String qualification = request.getParameter("qualification");
			int year = Integer.parseInt(request.getParameter("year"));
			String university = request.getParameter("university");
			User user=(User)session.getAttribute("user");
			user.setQualification(qualification);
			user.setYear(year);
			user.setCollage(university);
			session.setAttribute("user", user);
			response.sendRedirect("three.html");
		}
	}

}
