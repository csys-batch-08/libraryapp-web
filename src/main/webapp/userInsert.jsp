<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SignUp</title>
  <link rel="stylesheet" href="assets/css/userinsert.css">
</head>
<body>

<div class="topnav" >
  <a class="active" href="admin.jsp">Home</a>
  <a href="logout.jsp">Logout</a>
  
</div>

    <div >
        <fieldset id="register">
            <legend>User register</legend>
        <form action="indexrole" method="post" >
        <label for="text">User name</label><br>
        <input type="text" id="text" name="text" required pattern="[A-Za-z]{3,}" ><br><br>
        <label for="text1">City</label><br>
        <input type="text" id="text1" name="text1" required pattern="[A-Za-z]{3,}" ><br><br>
        <label for="text2">Password</label><br>
        <input type="password" id="text2" name="text2" required pattern="^(?=.*[0-9])(?=.*[@#$%*!^()_+])(?=.*[a-z])(?=.*[A-Z]).{8,16}$"><br><br>
        <label for="text3">Mobile number</label><br>
        
        <input type="number" id="text3" name="text3" required pattern="[6-9][0-9]{9}"><br><br>
        <label for="userrole">User Role</label><br>
        <input type="text" name="role" id="userrole" required pattern="[A-Za-z]{3,}"><br><br>
        <label for="text4">Email Id</label><br>
        <input type="email" id="text4" name="text4" required pattern="([a-zA-Z0-9]+[@][a-zA-Z]+[.][a-z]+{15,40})"><br><br>
        <input type="submit" value="sign up">
    </form>
</fieldset>


    </div>


</body>
</html>