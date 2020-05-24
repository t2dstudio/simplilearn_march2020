package com.interceptor;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet Filter implementation class ValidatorFilter
 */
public class ValidatorFilter implements Filter {

    /**
     * Default constructor. 
     */
    public ValidatorFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		response.setContentType("text/html");
		System.out.println("Hello Filter");
		String pan=request.getParameter("pan");
		PrintWriter out=response.getWriter();
		if(pan!=null && pan.matches("[A-Z]{5}[0-9]{4}[A-Z]{1}") ) {
			chain.doFilter(request, response);
			System.out.println("Bye bye Filterrr");
		}else {
			request.getRequestDispatcher("index.html").include(request, response);
			out.print("<span style='color:red;'>Entered Pan "+pan+" is invalid.... pLease re-enter");
		}
		// pass the request along the filter chain
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
