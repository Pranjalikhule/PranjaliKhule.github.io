<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="styles\style.css">
<title>Insert title here</title>
<script src="js\script.js"></script>
</head>
<body>

	<div class="topnav">
		<div class="home">truYum</div>
		<img
			src="C:\Users\833494\eclipse-eclipseserver-Practice\truyum\WebContent\images\truyum_logo.png">
		<a href="ShowMenuItemListAdmin">Menu</a>
	</div>

	<h3>Edit Menu Item</h3>
	<div class="body-content-colour">
		<form action="EditMenuItem" name="menuItemForm"
			onsubmit="return  validateMenuItemForm()" method="POST">
			<br>
			<div class="form-field-spacing">
				<label for="name">Name</label> <input type="text"
					class="text-box text-box-title" name="name" id="name"
					value="${menuItem.name}">
			</div>

			<div class="form-field-spacing">
				<label for="price">Price(Rs.)</label> <input type="text"
					class="text-box" name="price" id="price" value="${menuItem.price}">
			</div>

			<div class="form-field-spacing">
				<label for="inStock">Active</label> <input class="radio"
					type="radio" name="active" value="yes"
					<c:if test="${menuItem.active}">checked</c:if>>Yes <input
					class="radio" type="radio" name="active" value="no"
					<c:if test="${!menuItem.active}">checked</c:if>>No
			</div>

			<div class="form-field-spacing">
				<label for="dateOfLaunch">Date of Lunch</label>
				<div>
					<input type="text" class="text-box" name="dateOfLaunch"
						value=<fmt:formatDate value="${menuItem.dateOfLaunch}" pattern="dd/MM/yyyy"/>>
				</div>
			</div>

			<div class="form-field-spacing">
				<label for="category">category</label> <select name="category"
					class="dropdown">
					<option value=" ${menuItem.category}">
						${menuItem.category}</option>
					<option value="Main Course">Main Course</option>
					<option value="starter">Starter</option>

					<option value="dessert">Dessert</option>
					<option value="drinks">Drinks</option>
				</select>
			</div>

			<div class="form-field-spacing">
				<label for="freeDelivery">Free Delivery</label> <input
					type="checkbox" name="freeDelivery" checked
					<c:if test="${menuItem.freeDelivery}">checked</c:if>>
			</div>

			<div>
				<input type="hidden" name="id" value="${menuItem.id}">
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