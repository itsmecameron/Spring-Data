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
<title>Details</title>
</head>
<body>
	<div class="container">
		<a class="btn btn-outline-info" href="/dashboard">Dashboard</a>
		<h1>
			<c:out value="${Song.title}" />
		</h1>
		<p>
			Creator:
			<c:out value="${Song.artist}" />
		</p>
		<p>
			Version:
			<c:out value="${Song.rating}" />
		</p>
		<form action="/song/${song.id}/delete" method="post">
			<input type="hidden" name="_method" value="delete"> <input
				type="submit" value="Delete">
		</form>
	</div>
</body>
</html>