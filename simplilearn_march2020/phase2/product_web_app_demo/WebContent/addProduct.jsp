<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Product Page</title>
</head>
<body>
<a href="/product_web_app_demo">Home</a>
<div align="center">
		<h4 style="text-decoration: underline;">Add Product Menu</h4>
		<form method="post">
		<table>
			<tr>
				<td><input type="text" name="name" placeholder="Product Name"/></td>
			</tr>
			<tr>
				<td><input type="number" name="cost" placeholder="Product Cost"/></td>
			</tr>
			<tr>
				<td><input type="number" name="rating" placeholder="Product Rating"/></td>
			</tr>
			<tr>
				<td><input type="text" name="manufacturerName" placeholder="Product's Manufacturer Name"/></td>
			</tr>
			<tr>
				<td><input type="submit" name="add" value="Add"/></td>
			</tr>
		</table>
		</form>
	</div>
	
	<%if(request.getParameter("add")!=null){ %>
	<jsp:useBean id="product" class="com.product.model.Product" scope="session"></jsp:useBean>
	<jsp:setProperty property="*" name="product"/>
	<jsp:forward page="addProduct"></jsp:forward>
	<%
	//response.sendRedirect("addProduct");
	} %>
	
	
</body>
</html>