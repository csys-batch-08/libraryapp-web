<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.library.dao.impl.*" import="com.library.model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Fine</title>
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
<fieldset id="regiser">
<% 
	  UsersDaoImpl user=new UsersDaoImpl();
	  int fineOf=Integer.parseInt(session.getAttribute("loginfine").toString());
	  String user_name=session.getAttribute("user").toString();
	  Users u3=new Users(fineOf,user_name);
	  FineHistoryDaoImpl fineHistory=new FineHistoryDaoImpl();
		
			try {
				user.setFine(u3);
				FineHistory fh1 = new FineHistory(user_name, fineOf);
				fineHistory.insert(fh1);
			} catch (Exception e) {
			
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("user.jsp");
			%>
			
	</fieldset>	
</body>
</html>