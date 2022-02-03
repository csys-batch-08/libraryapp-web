<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Book Available</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="assets/css/bookavailable.css">
</head>
<body>

<fieldset id="register">
<legend></legend>
<h3>Here After admin will takeover</h3>
<h3>Hi admin Enter your user name</h3>
<form action="borrowadmin" method="post">
<div class="container">
<label for="User Name">User Name</label>
    <input type="text" id = "uname" name="uname" required pattern="[A-Za-z]{3,}" oninvalid="setCustomValidity('Username must only have alphabets')" onchange="try{setCustomValidity('')}catch(e){}"  ><br><br>
    <label for= "password">Password&emsp;   </label>
    <input type="password" id="password" name="password" required pattern="^(?=.*[0-9])(?=.*[@#$%*!^()_+])(?=.*[a-z])(?=.*[A-Z]).{8,16}$" oninvalid="setCustomValidity('Password must contains a alphabet, a number and a special character')" onchange="try{setCustomValidity('')}catch(e){}" ><br><br>
    <button type="submit">Log In</button>
    
    <c:if test="${not empty AdminError}">
	   <h1 style="color:red;background-color:white;font-size:25px;float:right;">Invalid Credentials</h1>
	   
 </c:if>
   </div>
    </form>
    </fieldset>
</body>
</html>