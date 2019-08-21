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

<title>Show Dormitory</title>
</head>
<body>
	<div class="container">
	
		<h1 class="d-inline">
			<c:out value="${dorm.name}" /> Dormitory
		</h1>
			<a class="d-inline" href="/students">Dashboard</a>
		<form action="/dorms/${dorm.id}/process" method="post">
			<p>
				<label>Student</label> <select class="form-control mb-2 col-6"
					name="students">
					
					<c:forEach items="${students}" var="student">
						<option value="${student.id}">${student.first_name}
							${student.last_name}</option>
					</c:forEach>
				</select>
			</p>
			<input type="submit" value="Submit"/>
		</form>

		<table class="table mt-5">
			<thead>
				<tr>
					<th scope="col">Name</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${dorm.students}" var="student">
					<tr>
						<td><c:out value="${student.first_name}" /> <c:out
								value="${student.last_name}" /></td>
						<td><a href="/dorms/${student.id}/delete">Remove</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>