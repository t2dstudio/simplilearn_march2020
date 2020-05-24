<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>First JSP Page</title>
</head>
<body>
<h1>Hello from HTML</h1>
<%="<h1>Hello from JSP @ "+new Date() +"</h1>"%>
<%!int x=0; %>
<%int y=10;
out.print("y = "+(y++)+"<br/>");
out.print("x = "+(x++));
%>
<br/>
<%
for(int i=0;i<10;i++){
	out.print(i+"  ");
}
%><br/>
<input type="text" value="<%=x %>"/>

<form action="">
Enter Name <input type="text" name="fname"><br/>
<input type="submit" name="click" value="Say Hello"/>
</form>

<%if(request.getParameter("click")!=null){
	out.print("<h4>Hello "+request.getParameter("fname")+"</h4>");
}

%>

</body>
</html>