<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.library.dao.impl.*" import="com.library.model.*"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Recharge Wallet</title>
<style>
        #register{
        background-image:linear-gradient(rgba(0,0,0,0.5),rgba(0,0,0,0.5));
            background-repeat: no-repeat;
            width: 350px;
            margin-top:50px;
            margin-left: 600px;
            
        }

       html
        {
          background-image:url(Assets/Bgimage.jpeg);
            background-repeat: no-repeat;
            background-size:cover;
            color:white;
            font-size:larger;
        }
        button,a{
        font-size:medium;
        text-decoration:none;
        color:black;
        }

h3 {
	text-transform: capitalize;
}
    </style>
</head>
<body>

<fieldset id="register">
<h1>Welcome</h1>

	<p><h3>${user}</h3> your walletamount is ${userWalletLogin }.It is very low</p>
	<p>You have to recharge your wallet with rs.500 to enter in to library</p>
	<p>Are you ready to pay </p>
	<button type="submit"><a href="loginwallet.jsp">Pay now</a></button>&emsp;
	<button type="submit"><a href="index.jsp">Pay later</button>&emsp;
	<button><a href="logout.jsp">Logout</a></button>
			

</body>
<script>

function fieldhid(){
let field = document.getElementById("card");
field.style.visibility = "visibile";
}
</script>
</html>