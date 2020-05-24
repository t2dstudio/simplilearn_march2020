<%@page import="java.util.List"%>
<%@page import="com.product.model.Product"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="st" uri="WEB-INF/product_tags.tld" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Search Results Page</title>
</head>
<body>
<%List<Product> productList=(List<Product>)session.getAttribute("productList");
if(productList !=null && productList.size()>0){
%>
<st:printProduct productList="<%=productList %>"/>
<%} %>
</body>
</html>