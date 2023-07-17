<%@page import="Dao.testDao"%>
<%@page import="java.util.List"%>
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
		test t = null;
		if( session.getAttribute("data") != null){
			t = (test)session.getAttribute("data");
		}else {
			response.sendRedirect("login.jsp");
		}
	
	%>
	Welcome,
	<%=t.getName() %>
	<table>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Contact</th>
			<th>Gender</th>
			<th>Address</th>
			<th>Email</th>
			<th>Password</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<%List<test> list = testDao.getAllTest(); %>
		<%for(test t1:list){ %>
		<tr>
			<td><%=t1.getId() %></td>
			<td><%=t1.getName() %></td>
			<td><%=t1.getContact() %></td>
			<td><%=t1.getGender() %></td>
			<td><%=t1.getDob() %></td>
			<td><%=t1.getAdddress() %></td>
			<td><%=t1.getEmail() %></td>
			<td><%=t1.getPassword() %></td>
			<td><a href="edit.jsp?id=<%=t1.getId()%>">Edit</a></td>
			<td><a href="delete.jsp?id=<%=t1.getId()%>">Delete</a></td>
		</tr>
		
		<%} %>
		</table>
</body>
</html>