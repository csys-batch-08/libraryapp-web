<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SignUp</title>
   <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <style>
        #register{
        background-image:linear-gradient(rgba(0,0,0,0.7),rgba(0,0,0,0.7));
            width: 370px;
            margin-left: 600px;
            font-size:larger;
            color:white;
            position:absolute;
            right:100px;
            top:10px;
        }
        body{
            height:100vh;
            background-image: url(Assets/Rose-flowers-books.jpg);
            background-repeat: no-repeat;
            background-position:center;
            background-size:cover;
            color:springgreen;
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
  float: left;
}
   
</style>
</head>
<body>

<div class="topnav" >
  <a href="logout.jsp">Logout</a>
  
</div>
<br><Br>

	<c:if test="${not empty unameExists}">   <h1 style="color:red;background-color:white;font-size:25px;float:left;">UserName Already Exists</h1>
	   </c:if>
	   
	 <c:if test="${not empty email}">   <h1 style="color:red;background-color:white;font-size:25px;float:left;">EmailId Already Exists</h1>
	   </c:if> 
	 
	 <c:if test="${not empty mobileExists}">   <h1 style="color:red;background-color:white;font-size:25px;float:left;">Mobileno Already Exists</h1>
	   </c:if>   
   
  

    <div >
        <fieldset id="register">
            <legend><h2>User register</h2></legend>
            <hr>
        <form action="signUp" method="post" class="was-validated">
        <div class="container mt-1">
        <div class="mb-1 mt-1">
        <label for="user name" class="form-label">User name</label><br>
        <input type="text" id="text" name="text" class="form-control" required pattern="[A-Za-z]{3,}" oninvalid="setCustomValidity('UserName must have alphabets only')" onchange="try{setCustomValidity('')}catch(e){}"  >
        </div>
        <div class="mb-1 mt-1">
        <label for="city" class="form-label" >City</label><br>
        <input type="text" id="text1" class="form-control" name="text1" required pattern="[A-Za-z]{3,}" oninvalid="setCustomValidity('City name must have alphabets only')" onchange="try{setCustomValidity('')}catch(e){}"  >
        </div>
        <div class="mb-1 mt-1">
        <label for="password" class="form-label">Password</label><br>
        <input type="password" id="text2" class="form-control" name="text2" required pattern="^(?=.*[0-9])(?=.*[@#$%*!^()_+])(?=.*[a-z])(?=.*[A-Z]).{8,16}$" oninvalid="setCustomValidity('Password must contains a alphabet, a number and a special character')" onchange="try{setCustomValidity('')}catch(e){}" >
        </div>
        <div class="mb-1 mt-1">
        <label for="mobileno" class="form-label">Mobile number</label><br>
        <input type="number" id="text3" class="form-control" name="text3" required pattern="[6-9][0-9]{9}" oninvalid="setCustomValidity('Mobile Number must be 10 numbers length')" onchange="try{setCustomValidity('')}catch(e){}" >
        </div>
        <div class="mb-1 mt-1">
        <label for="email" class="form-label" >Email Id</label><br>
        <input type="email" id="text4" name="text4"  class="form-control" required pattern="([a-zA-Z0-9]+[@][a-zA-Z]+[.][a-z]+{15,40})" oninvalid="setCustomValidity('Please type in username@*.com format')" onchange="try{setCustomValidity('')}catch(e){}" >
        </div>
        
        <div class="form-check mb-3">
        <h6>You Have to pay 1000rs as Entry Charge to enter Library</h6>
    <input class="form-check-input" type="checkbox" id="myCheck" name="remember" required>
    
    <label class="form-check-label" for="myCheck">I agree on the terms and conditions.</label>
    
        </div>
        
        <div class="mb-3 mt-3">
        <button type="submit" value="sign up" class="btn btn-primary"> Sign Up</button>
        </div>
        </div>
    </form>
</fieldset>


    </div>


</body>
</html>