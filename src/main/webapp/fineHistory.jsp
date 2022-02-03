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
 
   <link rel="stylesheet" href="assets/css/finehistory.css">
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