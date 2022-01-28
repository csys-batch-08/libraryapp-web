<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Borrow Book</title>
<style type="text/css">
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
  padding: 20px;
}

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
		button{
		font-size:larger;
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

/* Add a color to the active/current link */
.topnav a {
  background-color: black;
  color: white;
  float: right;
}   
</style>
<body>
<%
	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
	if ((session.getAttribute("user") == null)&&(session.getAttribute("admin")==null)&&(session.getAttribute("supplier")==null)) {
		response.sendRedirect("index.jsp");
	}
	%>
<div class="topnav" >
  <a class="active" href="user.jsp">Home</a>
  <a href="logout.jsp">Logout</a>  
</div>
<%
   if(session.getAttribute("eligible") != null){%>
	   <h1>You are not eligible to borrow Book</h1>
	   
   <%session.removeAttribute("eligible"); }
   %>
<fieldset id="register">
<form action="bookName" method="post">
<label>Enter the Book Name</label>
<input type="text" name="bookname" required pattern="[a-zA-Z\s]{3,}"><br>
<button type="submit">Borrow Book</button>
</form>
</fieldset>

</body>
</html>