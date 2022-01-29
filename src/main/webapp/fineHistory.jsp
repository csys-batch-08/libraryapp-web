<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Fine History</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
 
    <style type="text/css">
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
  padding: 20px;
}

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
width:500px;
background-image:linear-gradient(rgba(0,0,0,0.7),rgba(0,0,0,0.7));
}  
</style>
</head>
<body>

<div class="topnav" >
<h1 style="float:left;">Library Management</h1>
  <a class="active" href="admin.jsp">Home</a>
  <a href="logout.jsp">Logout</a>
  
</div>
    <div >
        <fieldset id="register">
            <legend><h3>Fine register</h3></legend>
        <form class="container" action="finedetail" method="post">
        <label for="user name">Fine Range</label><br>
        <input type="text" id="text" name="text" required pattern="[0-9]{1,}"><br><br>
        <label for="city">Fine Amount</label><br>
        <input type="text" id="text1" name="text1" required pattern="[0-9]{1,}"><br><br>
        
        <button type="submit">Add Fine Details</button>
    </form>
</fieldset>


    </div>


</body>
</html>