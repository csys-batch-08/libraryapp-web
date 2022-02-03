<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>New Book Request</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="assets/css/requestbook.css">
</head>
<body>

	<div class="topnav" >
	<h2 style="float:left;">Library Management</h2>
  <a class="active" href="user.jsp">Home</a>
  <a href="logout.jsp">Logout</a>  
</div>
<fieldset id="register">
<legend></legend>
<h1>New Book Request</h1>
<form action="requestBook" method="post" >
<label>Book Name</label><br>
<input type="text" name="bookName" pattern="[A-Za-z\s]{3,}" required><br><br>
<label>Author Name</label><br>
<input type="text" name="authorName" pattern="[A-Za-z\s]{3,}" required><br><br>
<button type="submit">Request Book</button>
<button><a href="Logout.jsp">logout</a></button>
</form>
</fieldset>
</body>
</html>