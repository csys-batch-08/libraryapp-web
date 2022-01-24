<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.library.dao.impl.*" import="com.library.model.*" import="com.library.exception.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
 
<title>Category Search</title>
<style type="text/css">
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
  padding: 20px;
}

        #register{
            width: 350px;
            
            
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
.topnav{
background-color: gray;
overflow:hidden;
}

/* Add a color to the active/current link */
.topnav a {
  
  color: white;
  float: right;
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
<div class="topnav" >
<h1 style="float:left;">Library Management</h1>
  <a class="active" href="user.jsp">Home</a>
  <a href="Logout.jsp">Logout</a>  
</div>

<%!ResultSet rs; %>
<%String categoryName=request.getParameter("category");

String book_title=null;
String authorName=null;
String category =null;
BooksDaoImpl book=new BooksDaoImpl();
Books b1=new Books(book_title,categoryName,authorName);
rs = book.categoryFetch(b1); %>

<h2>Book List for category: <%=categoryName %></h1>

<fieldset id="register" class="container">

<% if(rs.next()){do{ %>

<a href="bookName?bookname=<%=rs.getString(1) %>" style="text-decoration: none;color:white;"><%= rs.getString(1)%></a><br><br>

<%}while(rs.next());
}else{
	try{
		throw new InvalidCategoryException();
	}catch(InvalidCategoryException e){
		String validate=e.getMessage();
		response.sendRedirect(validate);
	}} %>


<br><br>
</fieldset>
</body>

</html>