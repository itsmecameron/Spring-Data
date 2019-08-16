<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isErrorPage="true"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


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
		<h1>Edit Book</h1>
		<form:form action="/books/${ book.id }" method="post"
			modelAttribute="book">
			<input type="hidden" name="_method" value="put">
			<p>
				<form:label path="title">Title</form:label>
				<form:errors path="title" />
				<form:input class="form-control mb-2 col-6" path="title" />
			</p>
			<p>
				<form:label path="description">Description</form:label>
				<form:errors path="description" />
				<form:textarea class="form-control mb-2 col-6" path="description" />
			</p>
			<p>
				<form:label path="language">Language</form:label>
				<form:errors path="language" />
				<form:input class="form-control mb-2 col-6" path="language" />
			</p>
			<p>
				<form:label path="numberOfPages">Pages</form:label>
				<form:errors path="numberOfPages" />
				<form:input class="form-control mb-2 col-6" type="number" path="numberOfPages" />
			</p>
			<input type="submit" value="Submit" />
		</form:form>

	</div>
</body>
</html>