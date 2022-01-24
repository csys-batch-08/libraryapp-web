<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.library.dao.impl.*" import="com.library.model.*"%>
<!DOCTYPE html>
<html>
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
<%
	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
	if ((session.getAttribute("user") == null)&&(session.getAttribute("admin")==null)&&(session.getAttribute("supplier")==null)) {
		response.sendRedirect("index.jsp");
	}
	%>
<fieldset id="register">
<h3>The Book is not available</h3>

<a href="bookPreRequest.jsp">Prerequest Book</a><br><br>
<a href="user.jsp">Back to user Page</a><br><br>
<a href="showBook.jsp">Back to view Books</a><br><Br>
<button><a href="Logout.jsp" id="but">Logout</a></button>
</fieldset>

</body>
</html>