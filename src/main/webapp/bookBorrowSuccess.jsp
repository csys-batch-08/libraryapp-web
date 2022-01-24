<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
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
<%
	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
	if ((session.getAttribute("user") == null)&&(session.getAttribute("admin")==null)&&(session.getAttribute("supplier")==null)) {
		response.sendRedirect("index.jsp");
	}
	%>
<fieldset id="register">
<%int rack=(int) session.getAttribute("rack"); %>
<h2>The Book is in Rack number : <%=rack %></h2>
<p><h3>Book Borrowed Success</h3></p>

<button><a href="user.jsp">Back To User</a></button>

<button><a href="Logout.jsp">logout</a></button>
</fieldset>
</body>
</html>