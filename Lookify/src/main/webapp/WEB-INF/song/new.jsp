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
<title>Add Song</title>
</head>
<body>
	<div class="container">
		<a href="/dashboard">Dashboard</a>
		<div>
			<form:form action="/songs/process" method="post"
				modelAttribute="newSongObject">
				<p>
					<form:label path="title">Title</form:label>
					<form:errors path="title" />
					<form:input class="form-control mb-2 col-6" path="title" />
				</p>
				<p>
					<form:label path="artist">Artist</form:label>
					<form:errors path="artist" />
					<form:input class="form-control mb-2 col-6" path="artist" />
				</p>
				<p>
					<form:label path="rating">Rating (1-10)</form:label>
					<form:errors path="rating" />
					<form:select class="form-control mb-2 col-6" path="rating">
						<% for (int i = 1; i <= 10; i++) { %>
							<form:option value="<%= i %>"><%= i %></form:option>
						<% } %>
					</form:select>
				</p>

				<input type="submit" value="Submit" />
			</form:form>
		</div>
	</div>
</body>
</html>