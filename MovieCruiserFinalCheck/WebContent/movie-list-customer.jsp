<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="style\style.css">
<title>Insert title here</title>
<script src="js\script.js"></script>
</head>
<body>
	<div class="topnav">
		<div class="home">Movie Cruiser</div>
		<img
			src="C:\Users\833494\eclipse-eclipseserver-Final\MovieCruiserFinalCheck\WebContent\image\movie_cruiser_logo.jpg">
		<a href="ShowFavorites">Favorites</a> <a href="ShowMovieListCustomer">Movies</a>
	</div>
	<div class="field-spacing">
		<div class="message">
			<h3>Movies</h3>
		</div>
		<c:if test="${addFavoritesStatus}">
			<div class="success message">Item added to Favorites
				Successfully.</div>
		</c:if>
		<table id="myTable">
			<tr>
				<th>Title</th>
				<th>Box Office</th>
				<th>Genre</th>
				<th>Has Teaser</th>
				<th>Action</th>
			</tr>
			<c:forEach items="${moviesList}" var="movie">
				<tr>

					<td>${movie.title }</td>
					<td class="currency">$<fmt:formatNumber value="${movie.gross}"
							pattern="#,##,##,##,###" /></td>
					<td>${movie.genre}</td>
					<td><c:if test="${movie.hasTeaser}">Yes</c:if> <c:if
							test="${!movie.hasTeaser}">No</c:if></td>
					<td><a href="AddToFavorites?id=${movie.id}">Add to
							Favorites</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div class="footer">
		<h3>Copyright @ 2019</h3>
	</div>
</body>
</html>