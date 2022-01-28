<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>New Book Request</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
 
<style>
        #register{
            width: 350px;
            margin-left: 600px;
            
        }
        body{
            background-image: url(Assets/Rose-flowers-books.jpg);
            background-repeat: no-repeat;
            background-size:cover;
            color:white;
        }
        .topnav a {
  float: left;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}
.topnav a:hover {
  background-color: #ddd;
  color: black;
}
.topnav a {
  
  color: white;
  float: right;
} 
.topnav{
background-color: gray;
overflow:hidden;
}

    </style>
</head>
<body>

	<div class="topnav" >
	<h2 style="float:left;">Library Management</h2>
  <a class="active" href="user.jsp">Home</a>
  <a href="logout.jsp">Logout</a>  
</div>
<fieldset id="register">
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