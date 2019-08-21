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

<title>New Dormitories</title>
</head>
<body>
	<div class="container">
		<h1 class="d-inline">Dormitories</h1>
		<a class="d-inline" href="/students">Dashboard</a>
		<form:form action="/dorms/process" method="post"
			modelAttribute="newDorm">
			<p>
				<form:label path="name">Name:</form:label>
				<form:errors class="text-danger text-monospace" path="name" />
				<form:input class="form-control mb-2 col-6" path="name" />
			</p>
			<input type="submit" value="Create" />
		</form:form>
	</div>
</body>
</html>