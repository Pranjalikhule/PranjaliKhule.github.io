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
		<a href="http://localhost:8082/truyum/cart.jsp">Cart</a> <a
			href="menu-item-list-customer.jsp">Menu</a>
	</div>
	<div class="field-spacing">
		<h1 class="message">Cart</h1>
		<h6>
			No items in cart. Use 'Add to Cart' option in <span><a
				href="ShowMenuItemListCustomer">Menu Item List.</a></span>
		</h6>
	</div>
	<div class="footer">
		<h3>Copyright @ 2019</h3>
	</div>
</body>
</html>