package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		String certification=request.getParameter("certification");
		String yoc=request.getParameter("yoc");
		String valid=request.getParameter("valid");
		PrintWriter out=response.getWriter();
		Cookie cookies[]=request.getCookies();
		out.print("<h4>Hello User... Here are your details</h4>");
		out.print("<table border='1px'>");
		for(Cookie cookie:cookies) {
			out.print("<tr>");
			out.print("<th>"+cookie.getName()+"</th>");
			out.print("<td>"+cookie.getValue()+"</td>");
			out.print("</tr>");
		}
		out.print("<tr>");
		out.print("<th>Certification Name</th>");
		out.print("<td>"+certification+"</td>");
		out.print("</tr>");
		out.print("<tr>");
		out.print("<th>Certified Year</th>");
		out.print("<td>"+yoc+"</td>");
		out.print("</tr>");
		out.print("<tr>");
		out.print("<th>Certification Validity</th>");
		out.print("<td>"+valid+"</td>");
		out.print("</tr>");
		out.print("</table>");
	}

}
