<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.library.dao.impl.*" import="com.library.model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Fine Calculation</title>
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
            font-size:larger;
        }

    </style>
</head>
<body>
<%
	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
	if ((session.getAttribute("user") == null)&&(session.getAttribute("admin")==null)&&(session.getAttribute("supplier")==null)) {
		response.sendRedirect("index.jsp");
	}
	%>
<fieldset id="register">
<h1>Welcome</h1>
	<form>
	<p>Welcome you have pending fine</p>
	<p>You have to repay the fine amount to enter in to library</p>
	<p>Are you ready to pay </p>
	<button type="submit"><a href="index.jsp">Pay later</a></button>
	<button type="submit"><a href="loginFine.jsp">Pay now</a></button>
	</form>
		<button><a href="Logout.jsp">logout</a></button>	
</fieldset>
</body>
</html>