<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.library.dao.impl.*" import="com.library.model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Supplier Page</title>
<style>
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
  padding: 20px;
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
            color:springgreen;
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

<%!ResultSet rs = null; %>
<%
		session = request.getSession();
		OrderBookDaoImpl obDao = new OrderBookDaoImpl();
		String book_name=null;
		String author=null;
		String user_name=session.getAttribute("supplier").toString();
		OrderBook order=new OrderBook(user_name,author,book_name);
		
		try {
			rs = obDao.view(order);
		}  catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}if (rs.next()) {
	%>
		<table>
		<tr>
		<th><b>BookName</b></th>
		<th><b>Author</b></th>
		</tr>
	<%do{ %>
			<tr>
			<td><%=rs.getString(1)%></td>
			<td><%=rs.getString(2)%></td>
			</tr>
	<%	}while (rs.next());%>
	</table>
	<br>
		<button style="margin-left:650px;font-size:large;"><a href="index.jsp">Send Books</a></button>
		
		<%}
	else{%>
	
	<h1>You dont have any orders</h1>
	<%}%>

</body>
</html>