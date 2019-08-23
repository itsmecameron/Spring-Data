<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<title>Students</title>
</head>
<body>
	<div class="container">
		<h1 class="d-inline">All Students</h1>
		<a class="d-inline" href="/students/new">Add New Student</a> | <a
			class="d-inline" href="/contacts/new">Add New Contact</a> | <a
			class="d-inline" href="/dorms/new">Add New Dorm</a> | <a
			class="d-inline" href="/courses/new">Add New Course</a>
		<table class="table table-striped">
			<thead class="thead-dark">
				<tr>
					<th scope="col">Name</th>
					<th scope="col">Age</th>
					<th scope="col">Address</th>
					<th scope="col">City</th>
					<th scope="col">State</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ students }" var="student">
					<tr>
						<td scope="row">
							<a href="/students/${student.id}"> 
							<c:out value="${student.first_name} ${student.last_name}" />
							</a>
						</td>
						<td><c:out value="${student.age}" /></td>
						<td><c:out value="${student.contact.address}" /></td>
						<td><c:out value="${student.contact.city}" /></td>
						<td><c:out value="${student.contact.state}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>