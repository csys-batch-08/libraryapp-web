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
<link rel="stylesheet" href="assets/css/supplierlogin.css">
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