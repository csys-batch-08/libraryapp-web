<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Book Available</title>
<style>
        #register{
        background-image:linear-gradient(rgba(0,0,0,0.7),rgba(0,0,0,0.7));
            width: 350px;
            margin-left: 600px;
            
        }
        body{
            background-image: url(Assets/Bgimage.jpeg);
            background-repeat: no-repeat;
            background-size:cover;
            color:white;
        }

    </style>
</head>
<body>

<fieldset id="register">
<h3>Here After admin will takeover</h3>
<h3>Hi admin Enter your user name</h3>
<form action="borrowadmin" method="post">
<label for="User Name"><h3>User Name</h3></label>
    <input type="text" id = "uname" name="uname" required pattern="[A-Za-z]{3,}" oninvalid="setCustomValidity('Username must only have alphabets')" onchange="try{setCustomValidity('')}catch(e){}"  ><br>
    <label for= "password"><h3>Password</h3></label>
    <input type="password" id="password" name="password" required pattern="^(?=.*[0-9])(?=.*[@#$%*!^()_+])(?=.*[a-z])(?=.*[A-Z]).{8,16}$" oninvalid="setCustomValidity('Password must contains a alphabet, a number and a special character')" onchange="try{setCustomValidity('')}catch(e){}" ><br><br>
    <button type="submit">Log In</button>
    
    <%
   if(session.getAttribute("AdminError") != null){%>
	   <h1 style="color:red;background-color:white;font-size:25px;float:right;">Invalid Credentials</h1>
	   
   <%session.removeAttribute("AdminError"); }
   %>
    </form>
    </fieldset>
</body>
</html>