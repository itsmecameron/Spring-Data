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
<title>Insert title here</title>
</head>
<body>
	<div class="container-fluid">
		<h1>All Books</h1>
		<a href="/createNewBook">New Book</a>
		<table class="table">
			<thead>
				<tr>
					<th scope="col">Title</th>
					<th scope="col">Description</th>
					<th scope="col">Language</th>
					<th scope="col">Number of Pages</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="book" items="${books}">
					<tr>
						<th scope="row"><c:out value="${book.title}" /></th>
						<td><c:out value="${book.description}" /></td>
						<td><c:out value="${book.language}" /></td>
						<td><c:out value="${book.numberOfPages}" /></td>
						<td> 
						<a href="/books/${ book.id }/show">Show</a>
						| <a href="/books/${ book.id}/edit">Edit</a>
						| <form style="display: inline-block" action="/books/${book.id}" method="post">
							<input type="hidden" name="_method" value="delete" />
							<input type="submit" value="Delete" />
						</form>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>