<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
<form action="">
Enter Name <input type="text" name="fname"><br/>
Select Designation<select name="designation">
<option value="">Select</option>
<option value="Trainee">Trainee</option>
<option value="Trainer">Trainer</option>
<option value="Manager">Manager</option>
</select><br/>
<input type="submit" name="click" value="Login">
</form>
<%if(request.getParameter("click")!=null){
	String name=request.getParameter("fname");
	String designation=request.getParameter("designation");
	if(name!=null && designation !=null && name.length()>0 && designation.length()>0){
		if(designation.equals("Trainee")){%>
			<jsp:include page="trainee.jsp"></jsp:include>
		<% }else if(designation.equals("Trainer")){%>
			<jsp:include page="trainer.jsp"></jsp:include>
		<% }else if(designation.equals("Manager")){%>
			<jsp:include page="manager.jsp"></jsp:include>
		<% }
	}else{
		out.print("<p style='color:red;'>Name and designation is must</p>");
		}
}
	%>

<%@include file="footer.html" %>

</body>
</html>