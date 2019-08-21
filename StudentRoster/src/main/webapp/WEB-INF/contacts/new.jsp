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

<title>New Contact</title>
</head>
<body>
	<div class="container">
		<h1>Contact Info</h1>
		<form:form action="/contact/process" method="post"
			modelAttribute="newContact">
			<p>
				<form:label path="student">Student</form:label>
				<form:errors path="student" />
				<form:select path="student" class="form-control mb-2 col-6">

					<c:forEach items="${students}" var="student">
						<option value="${student.id}">${student.first_name}
							${student.last_name}</option>
					</c:forEach>
				</form:select>
			</p>
			<p>
				<form:label path="address">Address</form:label>
				<form:errors path="address" />
				<form:input path="address" class="form-control mb-2 col-6" />
			</p>
			<p>
				<form:label path="city">City</form:label>
				<form:errors path="city" />
				<form:input path="city" class="form-control mb-2 col-6" />
			</p>
			<p>
				<form:label path="state">State</form:label>
				<form:errors path="state" />
				<form:input path="state" class="form-control mb-2 col-6" />
			</p>
			<input type="submit" value="Create" />
		</form:form>
	</div>

</body>
</html>