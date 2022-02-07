<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Admin Validation</title>
<link rel="stylesheet" href="assets/css/bookreturnadmin.css">
</head>
<body>

<fieldset id="register">
<legend></legend>
<h3>Here After admin will takeover</h3>
<h3>Hi admin Enter your user_name</h3>
<form action="returnadmin" method="post">
<label for="uname">User Name</label>
    <input type="text" id = "uname" name="uname1" required pattern="[A-Za-z]{3,}" oninvalid="setCustomValidity('Username must contains only alphabets')" onchange="try{setCustomValidity('')}catch(e){}" ><br><br>
    <label for= "password">Password</label>
    <input type="password" id="password" name="password1" required pattern="^(?=.*[0-9])(?=.*[@#$%*!^()_+])(?=.*[a-z])(?=.*[A-Z]).{8,16}$" oninvalid="setCustomValidity('Password must contains a alphabet, a number and a special character')" onchange="try{setCustomValidity('')}catch(e){}" ><br><br>
   Date Returned
    <input type="date" id="returndate" name="returndate" aria-label="Date Returned" required><br><br>
    <button type="submit">Log In</button>
   <c:if test="${not empty AdminError}">
	   <h1 style="color:red;background-color:white;font-size:25px;float:right;">Invalid Credentials</h1>
	   
 </c:if>
    </form>
    </fieldset>
</body>

<script src="assets/js/bookreturnadmin.js">
	
</script>
</html>