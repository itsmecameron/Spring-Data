<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>
		<c:out value="${Book.title}" />
	</h1>
	<p>
		Description:
		<c:out value="${Book.description}" />
	</p>
	<p>
		Language:
		<c:out value="${Book.language}" />
	</p>
	<p>
		Number of pages:
		<c:out value="${Book.numberOfPages}" />
	</p>
	<a href="/books/${Book.id}/edit">Edit Book</a>
	<form action="/books/${Book.id}" method="post">
		<input type="hidden" name="_method" value="delete"> <input
			type="submit" value="Delete">
	</form>
</body>
</html>