<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<meta charset="utf-8">
<meta name="viewport" content="width-device-width, inital-scale=1">

<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">


<title>Welcome ${user}</title>
<link rel="stylesheet" href="assets/css/user.css">
</head>
<body>
	
	
	
		<h1 id="capital">
			Welcome to Library Management System! ${user}
		</h1>

	<br>
	<div class="topnav">

<form method="post">
		<div class="main-header">
			<div class="container">

				<div id="admin1">
					<nav class="navitem">
						<div class='navbar-links' id='navbar-links'>
							<a href="searchBook.jsp">Search Books</a> 
							<a href="bookShowUser">View	Books</a> 
							<a href="adminOrderBook">Ordered Book List</a> 
							<a href="BookReturn">Return Book</a> 
							<a href="requestBook.jsp">Request New Book</a> 
							<a href="UserHistoryList">View Book Borrow History</a>
							<a href="logout.jsp" style="float: right;">Logout</a>



						</div>

					</nav>
				</div>
			</div>
			</div>
</form>
			

		</div>
		
		
	<br>
	<br>
	<br>
	<br>
	<h1>
		Your User Wallet Amount is
		${userWalletLogin}</h1>
		<br><br>
<c:if test="${not empty eligible}">   
<h1 style="color:red;background-color:white;font-size:25px;float:left;">You are not eligible to borrow Book</h1>
	   </c:if>

</body>
</html>
