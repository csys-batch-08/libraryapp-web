<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Borrow Book</title>
<link rel="stylesheet" href="assets/css/borrowbook.css">
<body>
<div class="topnav" >
  <a class="active" href="user.jsp">Home</a>
  <a href="logout.jsp">Logout</a>  
</div>
<c:if test="${not empty eligible}">
	   <h1>You are not eligible to borrow Book</h1>
	   
   </c:if>
<fieldset id="register">
<legend></legend>
<form action="bookName" method="post">
<label>Enter the Book Name</label>
<input type="text" name="bookname" required pattern="[a-zA-Z\s]{3,}"><br>
<button type="submit">Borrow Book</button>
</form>
</fieldset>

</body>
</html>