<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="sidenav">
	<h1 id="logo"> Administrative Academy Portal </h1>
	<c:url var="classesLink" value="AdminControllerServlet">
		<c:param name="command" value="CLASSES" />
	</c:url>

	<c:url var="subjectsLink" value="AdminControllerServlet">
		<c:param name="command" value="SUBJECTS" />
	</c:url>

	<c:url var="teachersLink" value="AdminControllerServlet">
		<c:param name="command" value="TEACHERS" />
	</c:url>

	<c:url var="studentsLink" value="AdminControllerServlet">
		<c:param name="command" value="STUDENTS" />
	</c:url>


		<a href="${classesLink}">Classes</a> <d style="padding-left:2em;" > </d>
		<a href="${subjectsLink}">Subjects</a> <d style="padding-left:2em;" > </d>
		<a href="${teachersLink}">Teachers</a> <d style="padding-left:2em;" > </d>
		<a href="${studentsLink}">Students</a> <d style="padding-left:2em;" > </d>
		<a href="login.jsp">LogOut</a>

</div>