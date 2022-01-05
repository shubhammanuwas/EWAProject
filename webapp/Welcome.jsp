<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%

//line for removing or disabling back button

response.setHeader("Cache-Control","no-cache, no-stored, must-revalidate");

if(session.getAttribute("username")==null)
{
	response.sendRedirect("Login.jsp");
}
%>
New User
<a href="record.jsp"></a>
<form action="Logout">
	<input type="submit" value="Logout">
</form>
<form action="record.jsp">
<input type="submit" value="records">
</form>

</body>
</html>