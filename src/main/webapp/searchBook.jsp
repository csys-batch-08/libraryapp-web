<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  import="com.library.util.*" import ="java.util.List" import ="com.library.test.*" import="java.sql.*" import="com.library.dao.impl.*" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Book Search</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="assets/css/searchbook.css">
</head>
<body>
<%
	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
	if ((session.getAttribute("user") == null)&&(session.getAttribute("admin")==null)&&(session.getAttribute("supplier")==null)) {
		response.sendRedirect("index.jsp");
	}
	%>
	
	
<div class="topnav" >
<h1 style="float:left;">Library Management</h1>
  <a href="user.jsp">Home</a>
  <a href="logout.jsp">Logout</a>  

</div>

<fieldset id="register" class="alignment">
<legend></legend>
<form action="authorSearch" method="post">
<label for="author">Search By Author Name</label><br>
<input type="text" id="author" name="author" pattern="[A-Za-z\s]{3,}" required>
<button type="submit" class="button button1">Search Book</button>
</form>
<form action="categorySearch" method="post">
<label for="category">Search By Category Name</label>
<input type="text" name="category" id="category" pattern="[A-Za-z\s]{3,}" required>
<button type="submit" class="button button1">Search Book</button>

</form>
</fieldset>

	<c:if test="${not empty authorNotFound}">
	   <h1>Books written by Author you search is not available</h1>
	   
  </c:if>
	
	<c:if test="${not empty categoryNotFound}">
	   <h1>The Category of Book you search is not available </h1>
	   
   </c:if>

</body>
</html>