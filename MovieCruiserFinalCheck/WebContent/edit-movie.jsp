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
		<a href="ShowMovieListAdmin">Movies</a>
	</div>
	<h1 class="p">Edit Movie</h1>
	<div class="body-content-colour">
		<form action="EditMovie" name="movieForm"
			onsubmit="return validateMovieForm()" method="POST">
			<br>
			<div class="form-field-spacing">
				<label for="title">Title</label><br> <input type="text"
					class="text-box text-box-title" name="title" id="title"
					value="${movie.title }">
			</div>
			<br>
			<div class="form-field-spacing">
				<label for="gross">Gross(Rs.)</label><br> <input type="text"
					class="text-box" name="gross" id="gross" value="${movie.gross}">
			</div>
			<div class="form-field-spacing">
				<label for="active">Active</label><br> <input class="radio"
					type="radio" name="active" value="yes"
					<c:if test="${movie.active}">checked</c:if>>Yes <input
					class="radio" type="radio" name="active" value="no"
					<c:if test="${!movie.active}">checked</c:if>>No
			</div>
			<div class="form-field-spacing">
				<label for="dateOfLaunch">Date of Lunch</label> <input type="text"
					class="text-box" name="dateOfLaunch"
					value=<fmt:formatDate value="${movie.dateOfLaunch}" pattern="dd/MM/yyyy"/>>
			</div>
			<div class="form-field-spacing">
				<label for="genre">Genre</label> <br> <select name="genre"
					class="dropdown">
					<option value="${movie.genre}">${movie.genre}</option>
					<option value="science fiction">Science Fiction</option>
					<option value="superhero">Superhero</option>
					<option value="romance">Romance</option>
					<option value="comedy">comedy</option>
					<option value="adventure">Adventure</option>
					<option value="thriller">Thriller</option>
				</select>
			</div>
			<div class="form-field-spacing">
				<label for="hasteaser">Has Teaser</label> <input type="checkbox"
					name="hasteaser" checked
					<c:if test="${movie.hasTeaser}">checked</c:if>>
			</div>
			<br>
			<div>
				<input type="hidden" name="id" value="${movie.id}">
			</div>
			<div class="form-field-spacing">
				<input type="submit" class="button success-button" value="Save">
			</div>
		</form>
	</div>
	<div class="footer">
		<h3>Copyright @ 2019</h3>
	</div>
</body>
</html>