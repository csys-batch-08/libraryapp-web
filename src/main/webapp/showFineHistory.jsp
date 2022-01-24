<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.library.connection.*" import="com.library.dao.impl.*" import="com.library.model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Fine History</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style type="text/css">
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
  padding: 20px;
}
.table tr:hover{
color:black;
background-color: white;
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

/* Add a color to the active/current link */
.topnav a {
  background-color: black;
  color: white;
  float: right;
}   
</style>
</head>.
<body>
<%
	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
	if ((session.getAttribute("user") == null)&&(session.getAttribute("admin")==null)&&(session.getAttribute("supplier")==null)) {
		response.sendRedirect("index.jsp");
	}
	%>
<div class="topnav" >
  <a class="active" href="admin.jsp">Home</a>
  <a href="Logout.jsp">Logout</a>
  
</div>
<%!ResultSet rs; %>
<div class="container">
<h1>Fine History</h1>
<table class="table table-hover" style="color:white;">
<th><b>User Name</b></th>
<th><b>Fine Amount</b></th>
<th><b>Collected Time</b></th>
<%

FineHistoryDaoImpl fineHist = new FineHistoryDaoImpl();

				rs = fineHist.view();
				while(rs.next()){%>
					
			<tr>
<td><%=rs.getString(1)%></td>
<td>  <%=rs.getString(2) %></td>
<td>  <%=rs.getString(3) %></td>
</tr>	
				
			<%} %>
			
			</table>
</div>
</body>
</html>