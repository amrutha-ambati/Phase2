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
String  Name=request.getParameter("Name");
String  Description=request.getParameter("Description");
String  Quantity=request.getParameter("Quantity");
String  Price=request.getParameter("Price");

if((Name.equals("")) || (Description.equals("")) || (Quantity.equals(""))||(Price.equals(""))){
	
%>
<h2>Fill All The Fields</h2>
<jsp:include page="index.html"></jsp:include>
<% }
 else { %>


<jsp:forward page="save.jsp">
	<jsp:param value="<%=Name %>" name="Name"/>
	<jsp:param value="<%=Description %>" name="Description"/>
	<jsp:param value="<%=Quantity %>" name="Quantity"/>
	<jsp:param value="<%=Price %>" name="Price"/>
</jsp:forward>
<%}%>

</body>
</html>