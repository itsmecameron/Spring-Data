<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<title>Search</title>
</head>
<body>
	<div class="container">
		<h1>Top Ten Songs</h1>
		<a class="btn btn-outline-info" href="/dashboard">Dashboard</a>
		<table class="table">
			<thead>
				<tr>
					<th>Title</th>
					<th>Artist</th>
					<th>Rating</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ Songs }" var="song">
					<tr>
						<td><c:out value="${song.title}" /></td>
						<td><c:out value="${song.artist}" /></td>
						<td><c:out value="${song.rating}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>