<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register Bean</title>
</head>
<body>
<form action="" method="post">
Enter Name<input type="text" name="fname"><br/>
Enter Age <input type="text" name="age"><br/>
Enter Email <input type="email" name="email"><br/>
Enter Contact <input type="text" name="contact"><br/>
Select Gender<input type="radio" name="gender" value="Female" >F &nbsp;&nbsp;<input type="radio" name="gender" value="Male" >M<br/>
 Select Country <select name="country">
 <option value="India">India</option>
 <option value="United States">USA</option>
 </select><br/>
 select Hobby/s<br/>
 <input type="checkbox" value="Swim" name="hobby">Swimming<br/>
 <input type="checkbox" value="Dance" name="hobby">Dancing<br/>
 <input type="checkbox" value="Books" name="hobby">Reading Books/Novels<br/>
 <input type="checkbox" value="Browse" name="hobby">Browsing<br/>
 <input type="checkbox" value="Others" name="hobby">Other Hobbies<br/>
 <input type="submit" value="Register" name="register">
</form>
<%if(request.getParameter("register")!=null){%>
	<jsp:useBean id="user" class="com.model.User" scope="session"></jsp:useBean>
	<jsp:setProperty property="*" name="user"/>
	<%-- <jsp:forward page="register"></jsp:forward> --%>
	
<%
response.sendRedirect("register");
}%>
</body>
</html>