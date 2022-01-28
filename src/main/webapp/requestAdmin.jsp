<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Validation</title>
<style>
        #register{
            width: 350px;
            margin-left: 600px;
            
        }
        body{
            background-image: url(Assets/Bgimage.jpeg);
            background-repeat: no-repeat;
            background-size:cover;
            color:springgreen;
        }

    </style>
</head>
<body>

<fieldset id="register">
<h3>Here After admin will takeover</h3>
<h3>Hi admin Enter your user_name</h3>
<form action="requestadmin" method="post">
<label for="User Name">User Name</label>
    <input type="text" id = "uname" name="uname1" required pattern="[A-Za-z]{2,}" oninvalid="setCustomValidity('Username must contains only alphabets')" onchange="try{setCustomValidity('')}catch(e){}"  ><br><br>
    <label for= "password">Password</label>
    <input type="password" id="password" name="password1" required pattern="^(?=.*[0-9])(?=.*[@#$%*!^()_+])(?=.*[a-z])(?=.*[A-Z]).{8,16}$" oninvalid="setCustomValidity('Password must contains a alphabet, a number and a special character')" onchange="try{setCustomValidity('')}catch(e){}" ><br><br>
    <label>Supplier Name</label>
    <input type="text" name="supplier" required pattern="[A-Za-z]{2,}" oninvalid="setCustomValidity('Supplier Name must contains only alphabets')" onchange="try{setCustomValidity('')}catch(e){}"  >
    <button type="submit">Log in</button>
    
     <%
   if(session.getAttribute("AdminError") != null){%>
	   <h1 style="color:red;background-color:white;font-size:25px;float:right;">Invalid Credentials</h1>
	   
   <%session.removeAttribute("AdminError"); }
   %>
    
    </form>
  </fieldset>  
</body>
</html>