<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Forgot Password</title>
<link rel="stylesheet" href="assets/css/forgotpassword.css">
</head>
<body>
<fieldset id="register">
<legend>Forgot Password</legend>
<form action="forgotpass" method="post">
<label for="User Name">User Name</label>
    <input type="text" id = "uname" name="uname" pattern="[A-Za-z]{3,}" required oninvalid="setCustomValidity('Username must contains only alphabets')" onchange="try{setCustomValidity('')}catch(e){}" ><br><br>
    <label for= "password">Enter New Password</label>
    <input type="password" id="password" name="password" pattern="^(?=.*[0-9])(?=.*[@#$%*!^()_+])(?=.*[a-z])(?=.*[A-Z]).{8,16}$" required oninvalid="setCustomValidity('Password must contains a alphabet, a number and a special character')" onchange="try{setCustomValidity('')}catch(e){}" ><br><br>
    <button type="submit">Change Password</button>
    </form>
    </fieldset>
</body>
</html>