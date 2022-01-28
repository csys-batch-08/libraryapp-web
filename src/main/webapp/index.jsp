<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Library Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        #field1{
         background-image:linear-gradient(rgba(0,0,0,0.7),rgba(0,0,0,0.7));
            width: 500px;
            color: white;
            float:left;
            font-size:20px;
            margin-left:465px;
            border-radius:20px;
            margin-top:80px;
            

        }
        body{
            background-image: url(Assets/login.jpg);
            background-repeat: no-repeat;
            background-size:cover;
            color: springgreen;
          
        }
        
        #forgot, a{
            width: 100px;
            text-decoration:none;
            color:white;
        }
        #forgot{
        color:black;
        }
       button{
        width: 150px;
            text-decoration:none;
        }
        #forgot{
        width:150px;
        }
    </style>
</head>
<body>
 <c:if test="${not empty passchange}">
	   <h1>Password Changed Successfully!!</h1>
	   
   </c:if>
  
    <h1 style="color: white;font-size: 50px;margin-left: 480px;" >Welcome to Library</h1>
    
    <div>
         <fieldset id="field1">
        <legend style="font-size: 20px;color:white;">Log In</legend>
        <form action="Index" method="post">
            
            <br>
    <label for="User Name" style="color:white;"><h3>User Name</h3></label>
    <input type="text" id = "uname" name="uname" pattern="[A-Za-z\s]{3,}" required class="form-control form-control-lg" oninvalid="this.setCustomValidity('Username must be more than 3 charcters')" onchange="try{setCustomValidity('')}catch(e){}"><br>
    <label for= "password"style="color:white;"	><h3>Password</h3></label>
    
    <input type="password" id="myInput" name="password" pattern="^(?=.*[0-9])(?=.*[@#$%*!^()_+])(?=.*[a-z])(?=.*[A-Z]).{8,16}$" class="form-control form-control-lg" oninvalid="setCustomValidity('Password must contains a alphabet, a number and a special character')" onchange="try{setCustomValidity('')}catch(e){}" 	 required>
    <c:if test="${not empty invalidUser}">
	   <h1 style="color:red;background-color:white;font-size:25px;float:right;">Invalid Credentials</h1>
	   
   </c:if>
    <input type="checkbox" onclick="myFunction()" style="color:red;">Show Password<br><br>
     
    <button type="submit">Log In</button>
    
    <button id="forgot" style="width:200px;"><a href="forgotPassword.jsp" style="color:black;">Forgot Password</a></button><br><br>
    <h3>New user <a href="signup.jsp">Sign Up </a>here</h3>

        </form>
        </fieldset>
</div>
</body>

<script>
function myFunction() {
  var x = document.getElementById("myInput");
  if (x.type === "password") {
    x.type = "text";
  } else {
    x.type = "password";
  }
}
</script>
</html>