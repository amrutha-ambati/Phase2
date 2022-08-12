<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table  border=1 cellspacing=0 cellpadding=10>
	<tr>
			<th>Name</th><th>Description</th><th>Quantity</th><th>Price</th>
	</tr>
	<tr>
	<td><%= request.getParameter("Name")%></td>
	<td><%= request.getParameter("Description")%></td>
	<td><%= request.getParameter("Quantity")%></td>
	<td><%= request.getParameter("Price")%></td>
	</tr>
	
</table>

</body>
</html>