<%@page import="com.library.model.Books"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  import="com.library.connection.*" import ="java.util.List" import ="com.library.test.*" import="java.sql.*" import="com.library.dao.impl.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Book List</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">

<style type="text/css">
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
  padding: 20px;
}

        #register{
        background-image:linear-gradient(rgba(0,0,0,0.7),rgba(0,0,0,0.7));
            width: 350px;
            margin-left: 600px;
            
        }
        body{
            background-image: url(Assets/Rose-flowers-books.jpg);
           background-repeat: no-repeat;
            background-size:cover;
            color:white;
        }
		button{
		font-size:larger;
		}
		.table tabl-hover{
font-size:larger;
}
.table tr{
color:white;
}

.table tr:hover{
color:black;
background-color:white; 

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
background-color: gray;
overflow:hidden;
}
th{
font-style: italic;
}   
</style>
</head>
<body>

<div class="topnav" >
<h1 style="float:left;">Library Management</h1> 
  <a class="active" href="admin.jsp">Home</a>
  <a href="logout.jsp">Logout</a>  
</div>
<h2>Book List</h2>
<div class="container-fluid">
<table class="table table-hover" style="font-size:larger;">
<caption></caption>
<tr>
<th id="head1"><h3>BookName</h3></th>
<th id="head2"><h3>Category</h3></th>
<th id="head3"><h3>Author</h3></th>
</tr>



<c:forEach var="books" items="${booksList}">
<tr>
<td>${books.bookTitle}</td>
<td>${books.author}</td>
<td>${books.category}</td>
</tr>
</c:forEach>
</table>
</div>

</body>
</html>