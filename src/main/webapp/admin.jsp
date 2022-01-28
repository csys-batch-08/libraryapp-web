<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<meta charset="utf-8">
<meta name="viewport" content="width-device-width, inital-scale=1">
<head>
<title>Welcome ${admin}</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<style type="text/css">
body {
	background-image:
		url(Assets/adminpage.jpg);
	background-repeat: no-repeat;
	background-size: cover;
	color: white;
	overflow:hidden;
}

.main {
	margin-left: 160px; /* Same as the width of the sidebar */
	padding: 0px 10px;
}

.header {
	padding-top: 12px;
	background: gray;
	color: white;
	padding-bottom: 12px;
}

.header a h3:hover {
	background-color: black;
	height: 50px;
	
}

h3 {
	text-transform: capitalize;
}

.side-navbar {
	width: 180px;
	height: 100%;
	position: fixed;
	margin-left: -300px;
	background-color: #100901;
	transition: 0.5s;
}


ul{
padding: 25px;}

.nav-link:active, .nav-link:focus, .nav-link:hover {
	background-color: #ffffff26;
}

.my-container {
	transition: 0.4s;
}

.active-nav {
	margin-left: 0;
}

/* for main section */
.active-cont {
	margin-left: 180px;
}

.kiddo {
	margin-left: -20px;
}
.row flex-nowrap{
margin-rop:-20px;}


i {
	color: gray;
	
}
</style>

</head>
<body>
	

	<div class="header container-fluid">
		<h3>
			Welcome ${admin}</h3>
		<a href="logout.jsp"><h3
				style="float: right; position: relative; bottom: 40px; color: white;">Logout</h3></a>
	</div>

	<div class="kiddo">
		<div class="container-fluid">
			<div class="row flex-nowrap" style="height: 559px;">
				<div
					class="col-auto col-md-3 col-xl-2 px-sm-2 px-0 bg-light bg-gradient">
					<div
						class="d-flex flex-column align-items-center align-items-sm-start px-3 pt-2 text-white min-vh-100">
						<ul
							class="nav nav-pills flex-column mb-sm-auto mb-0 align-items-center align-items-sm-start"
							id="menu" >
							<li class="nav-item"><a href="home.jsp"
								class="nav-link align-middle px-0 text-dark"> <em
									class="fs-4 bi-house\"></em>> <span
									class="ms-1 d-none d-sm-inline">Home</span>
							</a></li>

							<li><a href="bookShowUser"
								class="nav-link px-0 align-middle text-dark"> <em
									class="fs-4 bi-table"></em>> <span
									
									class="ms-1 d-none d-sm-inline">Show Books</span></a></li>
							<li><a href="addBook.jsp"
								class="nav-link px-0 text-dark" class="text-md-start"> <span
									class="d-none d-sm-inline">Add Books</span></a></li>
							


							<li><a href="fineHistory.jsp"
								class="nav-link px-0 text-dark"> <span
									class="d-none d-sm-inline">Add Fine Details</span>
							</a></li>
							<li><a href="adminUserList"
								class="nav-link px-0 text-dark"> <span
									class="d-none d-sm-inline">View All Users</span>
							</a></li>
							<li><a href="adminBookList"
								class="nav-link px-0 text-dark"> <span
									class="d-none d-sm-inline">View Available Books</span></a></li>
							<li><a href="unavailableBooks"
								class="nav-link px-0 text-dark"> <span
									class="d-none d-sm-inline">View Unavailable Books</span></a></li>


							<li><a href="BookIssueList"
								class="nav-link px-0 align-middle text-dark"> <em class="fs-4 bi-people"></em> <span
									class="ms-1 d-none d-sm-inline">View Book Issue Details</span>
							</a></li>
							
							<li><a href="adminOrderBook"
								class="nav-link px-0 align-middle text-dark"> <em class="fs-4 bi-people"></em>> <span
									class="ms-1 d-none d-sm-inline">View Ordered Book list</span>
							</a></li>
							
							<li><a href="FineHistory"
								class="nav-link px-0 text-dark"> <span
									class="d-none d-sm-inline">User Fine History</span></a></li>
						</ul>
						<hr>
					</div>
				</div>
			</div>
		</div>
	</div>








</body>
</html>
