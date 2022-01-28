<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Book</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
   <style type="text/css">
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
  padding: 20px;
}

        #register{
            width: 350px;
            margin-left: 350px;
            
            
        }
        body{
            background-image: url(Assets/Rose-flowers-books.jpg);
           background-repeat: no-repeat;
            background-size:cover;
            color:white;
        }
        label{
        font-size:larger;
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
input{
border:2px solidx;}
</style>
</head>
<body>

<div class="topnav" >
<h1 style="float:left;">Library Management</h1>
  <a class="active" href="admin.jsp">Home</a>
  <a href="logout.jsp">Logout</a>
  
</div>

        <fieldset id="register">
        <legend>Book register</legend>
        <form action="addBook" method="post">
        <div class="container">
        
        <label for="user name">Book Code</label><br>
        <input type="text" id="text" name="text" required pattern="[0-9]{3,}" class="form-control">
        <label for="city">Book Name</label><br>
        <input type="text" id="text1" name="text1" required pattern="[A-Za-z\s]{3,}" class="form-control">
        <label for="password">Category</label><br>
        <input type="text" id="text2" name="text2" required pattern="[A-Za-z]{3,}" class="form-control">
        <label for="mobileno">Author</label><br>
        <input type="tel" id="text3" name="text3" required pattern="[A-Za-z\s]{3,}" class="form-control">
        <label for="email">Price</label><br>
        <input type="number" id="text4" name="text4" required min="1" max="10000" class="form-control" onkeyup="if(parseInt(this.value)>10000){ this.value =10000; return false; }">
        <label for="email">Rack Number</label><br>
        <input type="number"  id ="text4" name="text5" required min="0" max="1000" class="form-control" onkeyup="if(parseInt(this.value)>1000){ this.value =1000; return false; }"><br>
        <button type="submit">Add Book</button>
        </div>
    </form>
</fieldset>


    


</body>
</html>