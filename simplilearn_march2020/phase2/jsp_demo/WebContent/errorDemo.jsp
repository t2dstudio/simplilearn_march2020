<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page isErrorPage="false" %>
    <%@page errorPage="error.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error Demo</title>
</head>
<body>
<form action="">
Enter Input1 <input type="text" name="x"><br/>
Enter Input2 <input type="text" name="y"><br/>
<input type="submit" name="click" value="Divide"/>
</form>

<%if(request.getParameter("click")!=null){
	int x = Integer.parseInt(request.getParameter("x"));
	int y = Integer.parseInt(request.getParameter("y"));
	if(y<=0){
		throw new ArithmeticException("You cannot divide by zero....");
	}
	int res=x/y;
	out.print("<h4>Result is "+res+"</h4>");
}

%>

</body>
</html>