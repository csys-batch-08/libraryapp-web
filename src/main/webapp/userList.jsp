<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.library.util.*" import="com.library.dao.impl.*" import="com.library.model.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>List of Users</title>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="assets/css/userlist.css">
</head>
<body>

<div class="topnav" >
<h1 style="float:left;">Library Management</h1>
  <a class="active" href="admin.jsp">Home</a>
  <a href="logout.jsp">Logout</a>
  
</div>
<h1>User List</h1>
<div class="container-fluid">
<table class="table table-hover" style="font-size:larger;">
<caption></caption>
<tr>
<th id="head"><strong>User Name</strong></th>
<th id="head"><strong>City</strong></th>
<th id="head"><strong>Contact No</strong></th>
<th id="head"><strong>Email</strong></th>
<th id="head"><strong>User Wallet</strong></th>
</tr>
<c:forEach var="users" items="${adminUserList } ">

<tr>
<td>${users.userName }</td>
<td>${users.city }</td>
<td>${users.mobileNo }</td>
<td> ${users.emailId }</td>
<td> ${users.userWallet }</td>
</tr>	
</c:forEach>			
			
			
			</table>
</div>
</body>
</html>