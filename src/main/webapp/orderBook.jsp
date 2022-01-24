<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.library.dao.impl.*" import="com.library.model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

<title>Ordered Books</title>
<style>
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
  padding: 20px;
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
  border-radius:20px;
  
}
.button1 {
  background-color: white; 
  color: black; 
  border: 2px solid pink;
  }
  .button1:hover {
  background-color:gray;
  color: white;
}


        table{
            width: 350px;
            margin-left: 600px;
            font-size:larger;
            color:white;
            
        }
        body{
            background-image: url(Assets/Rose-flowers-books.jpg);
           background-repeat: no-repeat;
            background-size:cover;
            color:white;
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
color:black;
}
table tabl-hover{
font-size:larger;
}
table tr{
color:white;
}

table tr:hover{
color:black;
background-color:white; 

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
<h2>Ordered Books</h2>
<%!ResultSet rs = null; %>
<%
		session = request.getSession();
		OrderBookDaoImpl obDao = new OrderBookDaoImpl();
		String book_name=null;
		String author=null;
		String userName=session.getAttribute("user").toString();
		OrderBook order=new OrderBook(userName,author,book_name);
		
//		String user_name=session.getAttribute("supplier").toString();
		
		
		try {
			rs = obDao.userView(order);
		}  catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}if (rs.next()) {
	%>
		<table class = "container">
		<tr>
		<th><b>BookName</b></th>
		<th><b>Author</b></th>
		<th><b>Status</b></th>
		</tr>
	<%do{ %>
			<tr>
			<td><%=rs.getString(2)%></td>
			<td><%=rs.getString(3)%></td>
			<%if(rs.getString(5).equals("arrived")){%>
			<td><button style="font-size:large;width:100px;" class="button button1"><a href="bookName?bookname=<%=rs.getString(2)%>&orderAuthorName=<%=rs.getString(3)%>" style="text-decoration:none;color:black; ">Borrow Book</a></button></td>
			<%}else %>
			
			</tr>
	<%	}while (rs.next());%>
	</table>
	<br>

		<%}
	else{%>
	
	<h1>You dont have any orders</h1>
	<%}%>

</body>
</html>