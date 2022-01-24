<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "com.library.dao.impl.*"  import = "com.library.model.*" import="com.library.exception.*"%>
<!DOCTYPE html>
<html>
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
<%
	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
	if ((session.getAttribute("user") == null)&&(session.getAttribute("admin")==null)&&(session.getAttribute("supplier")==null)) {
		response.sendRedirect("index.jsp");
	}
	%>
<div class="topnav" >
<h1 style="float:left">Library Management</h1>
  <a class="active" href="user.jsp">Home</a>
  <a href="Logout.jsp">Logout</a>  
</div>

<%!
ResultSet rs;
%>
<%

String authorName=request.getParameter("author");

BooksDaoImpl book=new BooksDaoImpl();



String category = null,book_title=null,author=null;
Books books=new Books(book_title,category,authorName);
rs = book.authorFetch(books);

%> 
<h2>Book List for Author: <%=authorName %></h2>
<fieldset id="register" class="container">
<br>
<%if(rs.next()){do{ %>
<a href="bookName?bookname=<%=rs.getString(1) %>" style="text-decoration: none;color:white;"><%= rs.getString(1)%></a><br>


<%}while(rs.next());


}else{
	try{
		throw new InvalidAuthorException();
	}catch(InvalidAuthorException e){
		String validate=e.getMessage();
		response.sendRedirect(validate);
	
	}}%>
<br><br>

</fieldset>
</body>
</html>