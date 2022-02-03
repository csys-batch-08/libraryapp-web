<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.library.connection.*" import="com.library.dao.impl.*" import="com.library.model.*"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Fine History</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="assets/css/showfinehistory.css">
</head>
<body>
<div class="topnav" >
<h1 style="float:left;">Library Management</h1>
  <a class="active" href="admin.jsp">Home</a>
  <a href="logout.jsp">Logout</a>
  
</div>
<div class="container">
<h1>Fine History</h1>
<table class="table table-hover" style="color:white;">
<caption></caption>
<tr>
<th id="head"><strong>User Name</strong></th>
<th id="head"><strong>Fine Amount</strong></th>
<th id="head"><strong>Collected Time</strong></th>
</tr>
	<c:forEach var="fine" items="${fineList}">				
			<tr>
<td>${fine.userName}</td>
<td>Rs. ${fine.fineAmount}</td>
<td>${fine.collectedTime}</td>
</tr>	
				
			</c:forEach>
			
			</table>
</div>
</body>
</html>