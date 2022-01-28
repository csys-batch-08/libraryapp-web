<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "com.library.dao.impl.*"  import = "com.library.model.*" import="com.library.exception.*"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

<title>Author Search</title>
<style type="text/css">
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
  padding: 20px;
}

        #register{
            width: 350px;
            margin-left: 600px;
            
        }
        body{
            background-image: url(Assets/Rose-flowers-books.jpg);
           background-repeat: no-repeat;
            background-size:cover;
            color:white;
        }
		body,a{
		font-size:larger;
		}
		a{
		color:blue;
		text-decotation:none;
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
<h1 style="float:left">Library Management</h1>
  <a class="active" href="user.jsp">Home</a>
  <a href="logout.jsp">Logout</a>  
</div>

 
<h2>Book List</h2>
<fieldset id="register" class="container">
<legend></legend>
<br>
<c:forEach var="authorBook" items="${authorBookList}">

<a href="bookName?bookname=${authorBook.book_title }" style="text-decoration: none;color:white;">${authorBook.book_title}</a><br>


</c:forEach>
<br><br>

</fieldset>
</body>
</html>