<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.library.dao.impl.*" import="com.library.model.*"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Recharge Wallet</title>
 <link rel="stylesheet" href="assets/css/walletrecharge.css">
</head>
<body>

<fieldset id="register">
<legend></legend>
<h1>Welcome</h1>

	<p>${user} your wallet amount is Rs. ${userWalletLogin }.It is very low</p>
	<p>You have to recharge your wallet with rs.500 to enter in to library</p>
	<p>Are you ready to pay </p>
	<button type="submit"><a href="loginwallet.jsp">Pay now</a></button>&emsp;
	<button type="submit"><a href="index.jsp">Pay later</button>&emsp;
	<button><a href="logout.jsp">Logout</a></button>
			
</fieldset>
</body>
<script src="assets/js/walletrecharge.js">


</script>
</html>