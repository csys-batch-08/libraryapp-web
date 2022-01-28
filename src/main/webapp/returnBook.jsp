<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.library.dao.impl.*" import="com.library.model.*" import="com.library.exception.InvalidReturnException"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

<title>Book Return</title>
<style type="text/css">
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
  padding: 20px;
}

        #register{
            width: 350px;
            margin-left: 600px;
            margin-top:100px;
            
        }
        body{
            background-image: url(Assets/Rose-flowers-books.jpg);
           background-repeat: no-repeat;
            background-size:cover;
            color:white;
            font-size:larger;
        }
		button{
		font-size:larger;
		}
		.topnav a {
  float: left;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}
.topnav a:hover {
  background-color: #ddd;
  color: black;
}

a{
color:white;
}

/* Add a color to the active/current link */
.topnav a {
  
  color: white;
  float: right;
}
.topnav{
background-color:gray;
overflow:hidden;
}   
</style>
</head>
<body>

	<div class="topnav" >
	<h2 style="float:left;">Library Management</h2>
  <a class="active" href="user.jsp">Home</a>
  <a href="logout.jsp">Logout</a>  
</div>
<h1>The Books To be Returned</h1>
<fieldset id="register">
<legend></legend>
<form action="bookReturn">


<c:forEach var="returnBook" items="${returnBookList}">
${returnBook.bookTitle}&emsp;&ensp;<a href="bookReturn?bookreturn=${returnBook.bookTitle}">Return Book</a><br><br>

</c:forEach>



</form>
</fieldset>
</body>
</html>