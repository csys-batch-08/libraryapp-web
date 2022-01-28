<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Fine Calculation</title>
<style>
        #register{
            width: 350px;
            margin-left: 600px;
            
        }
        button{
        font-size:medium;
        }
        body{
            background-image: url(Assets/Bgimage.jpeg);
            background-repeat: no-repeat;
            background-size:cover;
            color:springgreen;
            font-size:larger;
        }
        #para{
        text-transform:capitalize;
        }

    </style>
</head>
<body>

<fieldset id="register">

	<p id="para">${userName }</p><p>you have fine of rs</p>${fineamount}
	<p>	You have to pay now</p>
	<button type="submit"><a href="returnSuccess">Pay now</a></button>
	
</fieldset>							
</body>
</html>