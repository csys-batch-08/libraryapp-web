<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.library.connection.*" import="com.library.dao.impl.*" import="com.library.model.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Books Issue List</title>
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
/* Add a color to the active/current link */
.topnav a {
  
  color: white;
  float: right;
} 
.topnav{
background-color:gray;
overflow:hidden;} 
#capital{
text-transform: capitalize;} 
</style>
</head>
<body>

<div class="topnav" >
<h1 style="float:left;">Library Management</h1>
  <a class="active" href="admin.jsp">Home</a>
  <a href="logout.jsp">Logout</a>
 
  
</div>

<h1>Book Issue List</h1>
<br><br>
<div class="container-fluid">
<table class="table table-hover" style="font-size:larger;" >
<caption>Book Issue List</caption>
<tr>
<th id="head1"><strong>Issue No</strong></th>
<th id="head2"><strong>Book Name</strong></th>
<th id="head3"><strong>User Name</strong></th>
<th id="head4"><strong>Issued Date</strong></th>
<th id="head5"><strong>Return Date</strong></th>
<th id="head6"><strong>Date Returned</strong></th>
<th id="head7"><strong>Fine Range in Month</strong></th>
</tr>
<c:forEach var="books" items="${BookIssueList }">				
<tr>
<td> ${books.bookIssueId}</td>
<td> ${books.bookCode}</td>
<td id="capital"> ${books.userName}</td>
<td>${books.dateIssue}</td>
<td> ${books.dateReturn}</td>
<td> ${books.dateReturned}</td>
<td> ${books.fineRange}</td>

</tr>	
</c:forEach>
			
			</table>
</div>
</body>
</html>