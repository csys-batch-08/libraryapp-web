<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.library.util.*" import="com.library.dao.impl.*" import="com.library.model.*"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page import="java.time.format.DateTimeFormatter" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Fine History</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="assets/css/showfinehistory.css">


<link rel="style" href="//cdn.datatables.net/1.11.4/css/jquery.dataTables.min.css">
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.js" ></script>
<script type="text/javascript" src="https://cdn.datatables.net/1.11.4/js/jquery.dataTables.min.js"></script>



<style type="text/css">

label{
float: right;
}
#myTable_length{
float: left;
}
#myTable_paginate {
background-color:black;

}
span {
padding: 20px;
letter-spacing: 20px;
text-decoration: none;

}
a{
text-decoration: none;
color:white;}

</style>



</head>
<body>
<div class="topnav" >
<h1 style="float:left;">Library Management</h1>
  <a class="active" href="admin.jsp">Home</a>
  <a href="logout.jsp">Logout</a>
  
</div>
<div class="container">
<h1>Fine History</h1>
<table id="myTable" class="table table-hover" style="color:white;">
<caption></caption>
<thead>
<tr>
<th id="head"><strong>S No</strong></th>
<th id="head"><strong>User Name</strong></th>
<th id="head"><strong>Fine Amount</strong></th>
<th id="head"><strong>Collected Time</strong></th>
</tr>
</thead>
<tbody>
	<c:forEach var="fine" items="${fineList}">				
			<tr>
<td>${fine.serialNo}</td>
<td>${fine.userName}</td>
<td>Rs. ${fine.fineAmount}</td>
<td>${fine.collectedTime.format( DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:SS"))}</td>
</tr>	
				
			</c:forEach>
</tbody>			
			</table>
</div>
</body>
<script type="text/javascript">
$(document).ready( function () {
    $('#myTable').DataTable();
} );
</script>
</html>