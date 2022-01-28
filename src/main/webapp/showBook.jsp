<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  import="com.library.connection.*" import ="java.util.List" import ="com.library.test.*" import="java.sql.*" import="com.library.model.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Show Book</title>
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
  overflow:hidden;
}

.topnav{
background-color:gray;
overflow:hidden;}
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
.topnav a,h1 {
  
  color: white;
  float: right;
}
a{
color:white;
}   
</style>
</head>
<body>
<%
	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
	if ((session.getAttribute("user") == null)&&(session.getAttribute("admin")==null)&&(session.getAttribute("supplier")==null)) {
		response.sendRedirect("index.jsp");
	}
	%>
	<%
   if(session.getAttribute("eligible") != null){%>
	   <h1>You are not eligible to borrow Book</h1>
	   
   <%session.removeAttribute("eligible"); }
   %>


<div class="topnav" >
<h1 style="float:left;"> Library Management</h1>
  <a class="active" href="user.jsp">Home</a>
  <a href="logout.jsp">Logout</a>  
</div>
<div class="container-fluid">
<form action="bookName" method="post">
<table class="table table-hover" style="font-size:larger;">
<caption></caption>
<tr>
<th id="head">BookName</th>
<th id="head">Author</th>
<th id="head">Category</th>
<th id="head">Borrow</th>

</tr>

<c:forEach var="books" items="${booksList}">
<tr>
<td>${books.bookTitle}</td>
<td>${books.author}</td>
<td>${books.category}</td>
<td> <a href="bookName?bookname=${books.bookTitle}">Borrow Book</a> </td>
</tr>
</c:forEach>

</table>
</form>	
</div>








</body>
</html>