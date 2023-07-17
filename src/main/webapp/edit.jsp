<%@page import="Dao.testDao"%>
<%@page import="model.test"%>
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
int id = Integer.parseInt(request.getParameter("id"));
test t = testDao.getTestByID(id); 
%>
	<form action="TestController" method="post">

		<table>
			<tr>
				<td>Id :</td>
				<td><input type="hidden" name="id" value="<%=t.getId()%>"></td>
			</tr>
			<tr>
				<td>Name:</td>
				<td><input type="text" name="name" value="<%=t.getName()%>"></td>
			</tr>
			<tr>
				<td>Contact:</td>
				<td><input type="text" name="contact" value="<%=t.getContact()%>"></td>
			</tr>
			<tr>
				<td>Gender:</td>
				<td><input type="radio" name="gender" value="female" value="<%=t.getGender()%>" >Female</td>
				<td><input type="radio" name="gender" value="male" value="<%=t.getGender()%>">Male</td>
			</tr>
			<tr>
				<td>Date of Birth:</td>
				<td><input type="text" name="dob" value="<%=t.getDob()%>"></td>
			</tr>
			<tr>
				<td>Address:</td>
				<td><input type="text" name="address" value="<%=t.getAdddress()%>"></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input type="email" name="email" value="<%=t.getEmail()%>"></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="password" value="<%=t.getPassword()%>"></td>
			</tr>
			<tr>
				<td><input type="submit" name="action" value="update"></td>
			</tr>
		</table>

	</form>

</body>
</html>