<%@page import="com.library.model.OrderBook"%>
<%@page import="com.library.dao.impl.OrderBookDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Book</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="assets/css/addorderbook.css">
</head>
<body>

<div class="topnav" >
  <a class="active" href="admin.jsp">Home</a>
  <a href="logout.jsp">Logout</a>
  
</div>

        <fieldset id="register">
        <legend>Book register</legend>
        <form action="addBook" method="post">
        <div class="container-mt-1" style="height: 100%;">
        
        <label for="text">Book Code</label><br>
        <input type="text" id="text" name="text" required pattern="[0-9]{3,}" class="form-control"><br>
        
        
      
       <label for="text1">Book Name</label><br>
        <input type="text" id="text1" name="text1" value="<c:out value="${orderBookName}" />" readonly required pattern="[A-Za-z\s]{3,}" class="form-control"><br>
        <label for="text2">Category</label><br>
        <input type="text" id="text2" name="text2" required pattern="[A-Za-z]{3,}" class="form-control"><br>
        <label for="text3">Author</label><br>
        <input type="tel" id="text3" name="text3" value="<c:out value="${orderAuthorName}" />" readonly required pattern="[A-Za-z\s]{3,}" class="form-control"><br>
        
        <label for="text4">Price</label><br>
        <input type="number" id="text4" name="text4" required min="1" max="10000" class="form-control" onkeyup="if(parseInt(this.value)>10000){ this.value =10000; return false; }"><br>
        <label for="text5">Rack Number</label><br>
        <input type="number"  id ="text5" name="text5" required min="0" max="1000" class="form-control" onkeyup="if(parseInt(this.value)>1000){ this.value =1000; return false; }"><br>
        <button type="submit">Add Book</button>
        </div>
    </form>
</fieldset>




</body>
</html>