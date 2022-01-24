<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  import="com.library.connection.*" import ="java.util.List" import ="com.library.test.*" import="java.sql.*" import="com.library.model.*" %>
<!DOCTYPE html>
<html>
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
  <a href="Logout.jsp">Logout</a>  
</div>
<div class="container-fluid">
<table class="table table-hover" style="font-size:larger;">
<th><b>BookName</b></th>
<th><b>Author</b></th>
<th><b>Category</b></th>
<th><b>Borrow</b></th>

<%List<Books> book=(List<Books>) session.getAttribute("booksList");for(Books books:book){
	
%>
<form action="bookName" method="post">
<tr>
<td><%=books.getBook_title() %></td>
<td>  <%=books.getAuthor() %></td>
<td>  <%=books.getCategory() %></td>
<td> <a href="bookName?bookname=<%=books.getBook_title() %>">Borrow Book</a> </td>
</tr>
<%
}
%>
</table>
</div>
</form>	







</body>
</html>