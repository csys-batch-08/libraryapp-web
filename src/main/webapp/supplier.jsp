<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <title>Add Supplier</title>
    <style type="text/css">


        #register{
            width: 350px;
            margin-left: 600px;
            margin-top:100px;
            
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
  margin-top:0px;

}
.topnav a:hover {
  background-color: #ddd;
  color: black;
}

/* Add a color to the active/current link */
.topnav a {
 
  color: white;
  float: right;
}

.topnav{
background-color: gray;
overflow:hidden;}

form{
border:2px solid white;
border-radius: 10px;
width:300px;
background-image:linear-gradient(rgba(0,0,0,0.7),rgba(0,0,0,0.7));
}    
</style>
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
  <a class="active" href="admin.jsp">Home</a>
  <a href="Logout.jsp">Logout</a>
  
</div>
    
        <fieldset id="register">
          <legend><h3>Supplier register</h3></legend>  
            
        <form action="adminjsp" method="post">
        <div class="container-mt-1" >
        
        <label for="user name">User name</label><br>
        <input type="text" id="text" name="text"  required pattern="[A-Za-z]{3,}" ><br><br>
        <label for="city">City</label><br>
        <input type="text" id="text1" name="text1"  required pattern="[A-Za-z]{3,}" ><br><br>
        <label for="mobileno">Mobile number</label><br>
        <input type="tel" id="text3" name="text3" required pattern="[6-9][0-9]{9}"><br><br>
        <button type="submit">Add Supplier</button>
       </div>
    </form>
</fieldset>


   


</body>
</html>