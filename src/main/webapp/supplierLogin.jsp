<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.library.dao.impl.*" import="com.library.model.*"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Welcome ${supplier}</title>
<style>
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
  padding: 20px;
}
#capital{
text-transform: capitalize;
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
<h1 id="capital">Welcome ${supplier}</h1>
		<table>
		<caption></caption>
		<tr>
		<th id="head">BookName</th>
		<th id="part">Author</th>
		</tr>
	<c:forEach var="orderBook" items="${OrderBookList}">
			<tr>
			<td>${orderBook.bookName }</td>
			<td>${orderBook.author}</td>
			
			</tr>
	</c:forEach>
	</table>
	<br>
		<button style="margin-left:650px;font-size:large;"><a href="index.jsp">Send Books</a></button>
		
	

</body>
</html>