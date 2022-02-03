<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.library.dao.impl.*" import="com.library.model.*" import="com.library.exception.*"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
 
<title>Category Search</title>
<link rel="stylesheet" href="assets/css/categorysearch.css">
</head>
<body>

<div class="topnav" >
<h1 style="float:left;">Library Management</h1>
  <a class="active" href="user.jsp">Home</a>
  <a href="logout.jsp">Logout</a>  
</div>



<h2>Book List</h2>

<fieldset id="register" class="container">
<legend></legend>

<c:forEach var="categoryBook" items="${categoryBookList}">

<a href="bookName?bookname=${categoryBook.bookTitle}" style="text-decoration: none;color:white;">${categoryBook.bookTitle}</a><br><br>

</c:forEach>


<br><br>
</fieldset>
</body>

</html>