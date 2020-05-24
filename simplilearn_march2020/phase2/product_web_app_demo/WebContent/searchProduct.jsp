<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Search Page</title>
</head>
<body>
<form action="getProduct">
Select Search Criteria<select name="criteria">
<option value="1">Get All Products</option>
<option value="2">By Id</option>
<option value="3">By Manufacturer Name</option>
</select><br/>
Enter Search Value<input type="text" name="value"><br/>
<input type="submit" value="Search">

<span>***Note that if get all products then no need to enter Search Value</span>

</form>

<%if(request.getAttribute("error")!=null)
{
%>
<span style="color:red"><%=request.getAttribute("error") %></span>
<%} %>
</body>

</html>