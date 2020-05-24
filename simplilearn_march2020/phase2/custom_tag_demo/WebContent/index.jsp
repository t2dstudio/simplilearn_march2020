<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="st" uri="WEB-INF/mytags.tld" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Custom Tag Demo</title>
</head>
<body>
<h1>This is a simple tag now</h1>
<st:mydate/>
<h1>This is a tag with attribute</h1>
<st:customdate format="dd.MMM.yy  EEEEE hh:mm:ss a"/>
<h1>This is a tag with body</h1>
<st:upper>i will be converted to uppercase</st:upper>
</body>
</html>