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

<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div>
		<h1 class="pt-4 d-inline">${student.first_name}${student.last_name}</h1>
		<a class="d-inline" href="/students">Dashboard</a>
		
			<form action="/students/${student.id}/process" method="post">
				<label>Course</label> <select class="form-control mb-2 col-6"
					name="course_id">
					<c:forEach items="${courses}" var="course">
						<option value="${course.id}">${course.name}</option>
					</c:forEach>
				</select> <input type="submit" value="Submit"/>
			</form>
		</div>

		<table class="table mt-5">
			<thead>
				<tr>
					<th scope="col">Name</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${student.courses}" var="course">
					<tr>
						<td><a href="/courses/${course.id}">${course.name}</a></td>
						<td>
							<form action="/students/${course.id}/delete" method="get">
								<input type="hidden" name="student_id" value="${student.id}" />
								<input type="hidden" name="course_id" value="${course.id}" /> <input
									type="submit" class="btn btn-link" value="Delete" />
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>