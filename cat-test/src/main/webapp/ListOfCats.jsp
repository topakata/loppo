<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="repository.Repository" %>
<%@ page import="models.Cat" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All cats</title>
</head>
<body>
	<% Repository collection = Repository.getInstance(); %>
	<table>
	<tr>
	<th>Име на собственик</th>
	<th>Име на котка</th>
	<th>Порода</th>
	<th>Описание</th>
	</tr>
	<% for(Cat u:Repository.getCollection()) {%>
	<tr>
	<td><%= u.getPersonName() %></a></td>
	<td><%= u.getCatName() %></td>
	<td><%= u.getBreed() %></td>
	<td><%= u.getDescription() %></td>	
	</tr>
	<%} %>
	</table>
</body>
</html>