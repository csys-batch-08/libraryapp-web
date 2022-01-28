<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.library.dao.impl.*" import="com.library.model.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<style>
a{
text-decoration:none;
}
        #register{
        background-image:linear-gradient(rgba(0,0,0,0.7),rgba(0,0,0,0.7));
            width: 350px;
            margin-left: 600px;
            color:white;
            
        }
        a{
        color:white;
        }
        #but{
        color:black;
        font-size:medium;
        }
        body{
            background-image: url(Assets/Bgimage.jpeg);
            background-repeat: no-repeat;
            background-size:cover;
            color:white;
        }

    </style>
<title>Book Unavailable</title>
</head>
<body>

<fieldset id="register">
<h3>The Book is not available</h3>

<a href="bookPrerequest">Prerequest Book</a><br><br>
<a href="user.jsp">Back to user Page</a><br><br>
<a href="bookShowUser">Back to view Books</a><br><Br>
<button><a href="logout.jsp" id="but">Logout</a></button>
</fieldset>

</body>
</html>