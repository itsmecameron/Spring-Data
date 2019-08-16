<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
		<h3>New Language</h3>
		<form action="/language/${language.id}/delete" method="post">
			<input type="hidden" name="_method" value="delete" /> <input
				type="submit" class="btn btn-link" value="Delete" />
		</form>
		<a href="/">Dashboard</a>
		<form:form action="/language/${language_id}" method="post"
			modelAttribute="language">
			<input type="hidden" name="_method" value="put">
			<p>
				<form:label path="name">Name of Language</form:label>
				<form:errors path="name" />
				<form:input class="form-control mb-2 col-6" value="${ name }"
					path="name" />
			</p>
			<p>
				<form:label path="creator">creator</form:label>
				<form:errors path="creator" />
				<form:input class="form-control mb-2 col-6" value="${ creator }"
					path="creator" />
			</p>
			<p>
				<form:label path="version">version</form:label>
				<form:errors path="version" />
				<form:input class="form-control mb-2 col-6" value="${ version }"
					path="version" />
			</p>

			<input type="submit" value="Submit" />
		</form:form>

	</div>
</body>
</html>