<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Fine Calculation</title>
<link rel="stylesheet" href="assets/css/finecalculation.css">
</head>
<body>

<fieldset id="register">
<legend></legend>
	<p id="para">${userName }</p><p>you have fine of rs</p>${fineamount}
	<p>	You have to pay now</p>
	<button type="submit"><a href="returnSuccess">Pay now</a></button>
	
</fieldset>							
</body>
</html>