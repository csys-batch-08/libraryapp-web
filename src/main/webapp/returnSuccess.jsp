<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.library.dao.impl.*" import="com.library.model.*"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Fine Payment</title>
<link rel="stylesheet" href="assets/css/returnsuccess.css">
</head>
<body>
<div class="topnav" >
<h1 style="float: left;">Library Management</h1>
  <a class="active" href="index.jsp">Home</a>
  <a class="active" href="user.jsp">User</a>
</div>

<fieldset id="register">
<legend></legend>
<h3>Your revised Wallet amount is Rs. ${userWallet }</h3>				
<h3>Book Return Success</h3><br><br>
<h3><a href="user.jsp?userWalletLogin=${userWallet }">Back to User Page</a></h3>&emsp;&emsp;
<button><a href="logout.jsp" id="log">Log out</a></button>
</fieldset>				
</body>
</html>