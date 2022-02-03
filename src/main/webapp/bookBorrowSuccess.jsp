<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Borrow Book</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/borrowbook.css">
</head>
<body>
<div class="topnav" >
<h1 style="float:left;"> Library Management</h1>
  <a class="active" href="user.jsp">Home</a>
  <a href="logout.jsp">Logout</a>  
</div>

<fieldset id="register">
<legend></legend>
<h2>The Book is in Rack number : <c:out value="${rack }" /></h2>
<span class="badge bg-success">Book Borrowed Success</span><br>
<p> You have to return the book within three months otherwise you will be fined...</p>


</fieldset>
</body>
</html>