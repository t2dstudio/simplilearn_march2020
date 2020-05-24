<%@page import="java.sql.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Success Page</title>
</head>
<body>
<%if(session.getAttribute("userid")!=null){%>
<h3>Hello <%=session.getAttribute("userid") %>...... </h3>
<h3>You have logged in successfully at <%=new SimpleDateFormat("dd.MM.yyyy EEE HH:mm:ss").format(new Date(session.getCreationTime())) %></h3>
<a href="logout">Logout</a>
<%}else{
	response.sendRedirect("login.jsp");
}
	%>

</body>
</html>