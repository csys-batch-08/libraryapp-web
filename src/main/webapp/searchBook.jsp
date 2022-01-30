<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  import="com.library.connection.*" import ="java.util.List" import ="com.library.test.*" import="java.sql.*" import="com.library.dao.impl.*" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Book Search</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
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
        .alignment{
        margin-top:150px;}
        body{
            background-image: url(Assets/Rose-flowers-books.jpg);
           background-repeat: no-repeat;
            background-size:cover;
            color:white;
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
.button {
  background-color:pink; 
  border: none;
  color: white;
  padding: 4px 10px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  transition-duration: 0.4s;
  cursor: pointer;
  border-radius: 20px;
}
.button1 {
  background-color: white; 
  color: black; 
  border: 2px solid pink;
  }
  .button1:hover {
  background-color:black;
  color: white;
}



/* Add a color to the active/current link */
.topnav a {
  
  color: white;
  float: right;
}   
.topnav{
background-color: gray;
overflow:hidden;}

</style>
</head>
<body>
<%
	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
	if ((session.getAttribute("user") == null)&&(session.getAttribute("admin")==null)&&(session.getAttribute("supplier")==null)) {
		response.sendRedirect("index.jsp");
	}
	%>
	
	
<div class="topnav" >
<h1 style="float:left;">Library Management</h1>
  <a class="active" href="user.jsp">Home</a>
  <a href="logout.jsp">Logout</a>  

</div>

<fieldset id="register" class="alignment">
<legend></legend>
<form action="authorSearch" method="post">
<label >Search By Author Name</label><br>
<input type="text" name="author" pattern="[A-Za-z\s]{3,}" required>
<button type="submit" class="button button1">Search Book</button>
</form>
<form action="categorySearch" method="post">
<label >Search By Category Name</label>
<input type="text" name="category" pattern="[A-Za-z\s]{3,}" required>
<button type="submit" class="button button1">Search Book</button>

</form>
</fieldset>

	<c:if test="${not empty authorNotFound}">
	   <h1>Invalid Author</h1>
	   
  </c:if>
	
	<c:if test="${not empty categoryNotFound}">
	   <h1>Invalid Category</h1>
	   
   </c:if>

</body>
</html>