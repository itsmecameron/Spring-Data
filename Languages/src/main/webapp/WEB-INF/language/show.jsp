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
	<a href="/">Dashboard</a>
	<h1>
		<c:out value="${Language.name}" />
	</h1>
	<p>
		Creator:
		<c:out value="${Language.creator}" />
	</p>
	<p>
		Version:
		<c:out value="${Language.version}" />
	</p>
	<a href="/language/${Language.id}/edit">Edit Language</a>
	<form action="/language/${Language.id}/delete" method="post">
		<input type="hidden" name="_method" value="delete"> <input
			type="submit" value="Delete">
	</form>
</body>
</html>