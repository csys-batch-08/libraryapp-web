<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <title>Add Supplier</title>
    <link rel="stylesheet" href="assets/css/supplier.css">
</head>
<body>

<div class="topnav" >
<h1 style="float:left;">Library Management</h1>
  <a class="active" href="admin.jsp">Home</a>
  <a href="logout.jsp">Logout</a>
  
</div>
    
        <fieldset id="register">
          <legend>Supplier register</legend>  
            
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