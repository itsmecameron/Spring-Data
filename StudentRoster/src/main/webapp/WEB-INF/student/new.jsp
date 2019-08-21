<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<title>New Student</title>
</head>
<body>
	<div class="container">
	<h1 class="d-inline" >New Student</h1>
	<a class="d-inline" href="/students">Dashboard</a>
		<form:form action="/students/process" method="post"
			modelAttribute="newStudent">
			<p>
				<form:label path="first_name">First Name</form:label>
				<form:errors path="first_name" />
				<form:input class="form-control mb-2 col-6" path="first_name" />
			</p>
			<p>
				<form:label path="last_name">Last Name</form:label>
				<form:errors path="last_name" />
				<form:input class="form-control mb-2 col-6" path="last_name" />
			</p>
			<p>
				<form:label path="age">Age</form:label>
				<form:errors path="age" />
				<form:input class="form-control mb-2 col-6" path="age" />
			</p>
			<input type="submit" value="Create" />
		</form:form>
	</div>

</body>
</html>