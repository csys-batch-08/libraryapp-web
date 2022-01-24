<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.library.dao.impl.*" import="com.library.model.*"%>
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
<%
	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
	if ((session.getAttribute("user") == null)&&(session.getAttribute("admin")==null)&&(session.getAttribute("supplier")==null)) {
		response.sendRedirect("index.jsp");
	}
	%>
<fieldset id="register">
<%
BooksDaoImpl book=new BooksDaoImpl(); 
String book_title=session.getAttribute("bookname").toString();
String user_name=session.getAttribute("user").toString();
	Books b1 = new Books(book_title, user_name);
	String prerequestStatus=book.preRequest(b1);
	System.out.println(prerequestStatus);%>
	
	<h3><%=prerequestStatus %></h3>
	<button><a href="Logout.jsp">logout</a></button>
</fieldset>
</body>
</html>