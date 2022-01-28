<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Borrow Book</title>
<style>
        #register{
            width: 350px;
            margin-left: 600px;
            border-radius:18px;
            text-decoration:none;
            
        }
        a{
        text-decoration:none;
        }
         
        body{
            background-image: url(Assets/Rose-flowers-books.jpg);
           background-repeat: no-repeat;
            background-size:cover;
            color:white;
        }

    </style>
</head>
<body>

<fieldset id="register">
<legend></legend>
<h2>The Book is in Rack number : <c:out value="${rack }" /></h2>
<p><h3>Book Borrowed Success</h3></p>

<button><a href="user.jsp">Back To User</a></button>

<button><a href="logout.jsp">logout</a></button>
</fieldset>
</body>
</html>