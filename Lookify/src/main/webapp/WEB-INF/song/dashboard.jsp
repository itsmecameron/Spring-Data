<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<title>Lookify!</title>
</head>
<body>
	<div class="container">
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<a class="navbar-brand" href="#">Navbar</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item active"><a class="nav-link" href="/songs/new">Add
							New <span class="sr-only">(current)</span>
					</a></li>
					<li class="nav-item active"><a class="nav-link" href="/search/topTen">Top
							Songs <span class="sr-only">(current)</span>
					</a></li>
				</ul>
				<form action="/search" method="post"class="form-inline my-2 my-lg-0">
					<input class="form-control mr-sm-2" type="search" required
						placeholder="Search" name="searchArtist">
					<button class="btn btn-outline-success my-2 my-sm-0 text-capitalize" type="submit">Search
						Artist</button>
				</form>
			</div>
		</nav>
		<div>
			<table class="table table-striped">
				<thead class="thead-dark">
					<tr>
						<th scope="col">Title</th>
						<th scope="col">Artist</th>
						<th scope="col">Rating</th>
						<th scope="col">Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${ songs }" var="song">
						<tr>
							<td scope="row">
								<a href="/song/${ song.id }/show">
									<c:out value="${ song.title }" />
								</a>
							</td>
							<td><c:out value="${ song.artist }" /></td>
							<td><c:out value="${ song.rating }" /></td>
							<td>
								<form action="/song/${song.id}/delete" method="post">
								<input type="hidden" name="_method" value="delete" /> <input
									type="submit" class="btn btn-link" value="Delete" />
							</form>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

</body>
</html>