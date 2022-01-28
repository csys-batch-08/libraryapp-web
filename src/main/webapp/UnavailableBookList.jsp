<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.library.connection.*" import="com.library.dao.impl.*" import="com.library.model.*"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>List of Unavailable Books</title>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<style type="text/css">
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
  padding: 20px;
}

        #register{
            width: 350px;
            margin-left: 600px;
            font-size:larger;
            
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
#capital{
text-transform: capitalize;}
/* Add a color to the active/current link */
.topnav a {
   color: white;
  float: right;
}  
.topnav{
background-color:gray;
} 
</style>
</head>
<body>

<div class="topnav">
<h1 style="float:left;">Library Managemen</h1>
  <a class="active" href="admin.jsp">Home</a>
  <a href="logout.jsp">Logout</a>
<h1>t	</h1>

  
</div>


<br><br>
<div class="container">
<table class="table table-hover" style="font-size:larger;">
<th><b>Book Name</b></th>
<th><b>Category</b></th>
<th><b>Author</b></th>
<th><b>User Name</b></th>
<th><b>Price</b></th>
<th><b>Pre Request</b></th>

<c:forEach var="availableBooks" items="${unavailableBookList }">
					
			<tr>

<td>${availableBooks.book_title }</td>
<td>${availableBooks.category }</td>
<td>${availableBooks.author }</td>
<td id="capital">${availableBooks.user_name }</td>
<td>${availableBooks.price }</td>
<td>${availableBooks.prerequest }</td>
</tr>	
				
			</c:forEach>
			
			</table>
</div>
</body>
</html>