<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.library.dao.impl.*" import="com.library.model.*"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
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

		<table>
		<tr>
		<th><b>BookName</b></th>
		<th><b>Author</b></th>
		</tr>
	<c:forEach var="orderBook" items="${OrderBookList}">
			<tr>
			<td>${orderBook.book_name }</td>
			<td>${orderBook.author}</td>
			
			</tr>
	</c:forEach>
	</table>
	<br>
		<button style="margin-left:650px;font-size:large;"><a href="index.jsp">Send Books</a></button>
		
	

</body>
</html>