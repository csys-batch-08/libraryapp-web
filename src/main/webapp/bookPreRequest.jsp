<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.library.dao.impl.*" import="com.library.model.*"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PreRequest Book</title>
<style>
        #register{
            width: 350px;
            margin-left: 600px;
            border-radius:25px;
            
        }
        body{
            background-image: url(Assets/Rose-flowers-books.jpg);
            background-repeat: no-repeat;
            background-size:cover;
            color:white;
            font-size:larger;
        }
        a{
        text-decoration:none;
        }

    </style>
</head>
<body>

<fieldset id="register">

	
	<h3><c:out value="${preRequestStatus}" /></h3>
	<button><a href="logout.jsp">logout</a></button>
</fieldset>
</body>
</html>