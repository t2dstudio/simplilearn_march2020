package com.product.tagclass;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.product.model.Product;

public class PrintProduct extends SimpleTagSupport {

	private List<Product> productList;

	@Override
	public void doTag() throws IOException {
		JspWriter out = getJspContext().getOut();
		String headings[] = { "Name", "Manufacturer Name", "Cost", "Rating", "Unique Id","Product Id" };
		out.print("<table border='1px'>");
		out.print("<tr>");
		for (String heading : headings) {
			out.print("<th>" + heading + "</th>");
		}
		out.print("</tr>");
		for (Product product : productList) {
			
			out.print("<tr>");
			
			out.print("<td>" + product.getName() + "</td>");
			out.print("<td>" + product.getManufacturerName() + "</td>");
			out.print("<td>" + product.getCost() + "</td>");
			out.print("<td>" + product.getRating() + "</td>");
			out.print("<td>" + product.getUniqueId() + "</td>");
			out.print("<form action='deleteProduct'>");
			out.print("<td><input type='hidden' name='id' value='" + product.getId() + "'/>"+product.getId()+"</td>");
			out.print("<td><input type='submit' value='Delete'/></td>");
			out.print("</tr>");
			out.print("</form>");
		}
		out.print("</table>");
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

}
