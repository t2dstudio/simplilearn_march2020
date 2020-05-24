package com.product.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.product.bo.ProductBO;
import com.product.bo.impl.ProductBoImpl;
import com.product.dao.impl.ProductDaoImpl;
import com.product.exception.BusinessException;
import com.product.model.Product;

/**
 * Servlet implementation class ProductController
 */
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductBO productBO = new ProductBoImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// System.out.println("I am in get");
		List<Product> productList=null;
		int criteria = Integer.parseInt(request.getParameter("criteria"));
		HttpSession session=request.getSession();
		switch (criteria) {
		case 1:try {
				productList=new ProductDaoImpl().getAllProducts();
				session.setAttribute("productList", productList);
				response.sendRedirect("searchResults.jsp");
			} catch (BusinessException e1) {
				request.setAttribute("error", e1.getMessage());
				request.getRequestDispatcher("searchProduct.jsp").include(request, response);
			}

			break;
		case 2:
			try {
				int id=Integer.parseInt(request.getParameter("value"));
				Product product=productBO.getProductById(id);
				
				productList=new ArrayList<>();
				productList.add(product);
				session.setAttribute("productList", productList);
				response.sendRedirect("searchResults.jsp");
			} catch (NumberFormatException e) {
				request.setAttribute("error", "Product Id should be Integer only");
				request.getRequestDispatcher("searchProduct.jsp").include(request, response);
				
			} catch (BusinessException e) {
				request.setAttribute("error", e.getMessage());
				request.getRequestDispatcher("searchProduct.jsp").include(request, response);
				
			}

			break;
		case 3:

			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// System.out.println(request.getAttribute("product"));
		response.setContentType("text/html");
		HttpSession session = request.getSession(false);
		Product product = (Product) session.getAttribute("product");

		System.out.println("session id = " + session.getId());
		try {
			product = productBO.addProduct(product);
			// request.getRequestDispatcher("addProduct.jsp").include(request, response);
			// request.setAttribute("resultProduct", product);
			System.out.println("product created " + product);
			session.setAttribute("productNew", product);
			response.sendRedirect("success.jsp");
		} catch (BusinessException e) {
			request.getRequestDispatcher("addProduct.jsp").include(request, response);
			// System.out.println("Error "+e.getMessage());
			session.setAttribute("error", e.getMessage());
			response.sendRedirect("success.jsp");
		}

	}

}
