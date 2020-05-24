<%session=request.getSession(false); %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Product success</title>
</head>
<body>
<a href="addProduct.jsp">Click Here to Add Product again</a>
<br/>
<br/>

	<%if(session!=null && session.getAttribute("productNew")!=null) {%>
	<span style="color:green;">Product Added Successfully with details<%=session.getAttribute("productNew") %></span>
	<%
	session.removeAttribute("productNew");
	} %>
	<%if(session!=null && session.getAttribute("error")!=null) {%>
	<span style="color:red;">Error from Server<%=session.getAttribute("error") %></span>
	<%}session.removeAttribute("error"); %>
</body>
</html>