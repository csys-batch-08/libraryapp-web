<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.library.dao.impl.*" import="com.library.model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Fine Payment</title>
<style>
        #register{
        background-image:linear-gradient(rgba(0,0,0,0.7),rgba(0,0,0,0.7));
            width: 350px;
            margin-left: 600px;
            margin-top:150px;
        }
        body{
            background-image: url(Assets/Bgimage.jpeg);
            background-repeat: no-repeat;
            background-size:cover;
            color:white;
        }

   .topnav a:hover {
  background-color: #ddd;
  color: black;
}

/* Add a color to the active/current link */
.topnav a {
  background-color: black;
  color: white;
  float: right;
}   
 #para{
        text-transform:capitalize;
        }
        a{
        text-decoration:none;
        color:white;
        }
        a:hover{
        color:gray;
        background-color: black;
        }
        #log{
        color:black;
        font-size:larger;
        }
        #log:hover{
        background-color:gray;
        }
</style>
</head>
<body>
<div class="topnav" >
  <a class="active" href="index.jsp">Home</a>
  <a class="active" href="user.jsp">User</a>
</div>
<%
	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
	if ((session.getAttribute("user") == null)&&(session.getAttribute("admin")==null)&&(session.getAttribute("supplier")==null)) {
		response.sendRedirect("index.jsp");
	}
	%>
<fieldset id="register">
<%!int userWallet; %>
<%
int fineOf=Integer.parseInt(session.getAttribute("fineamount").toString());
String user_name=session.getAttribute("user").toString();
Users u3=new Users(fineOf,user_name);
%><h2 id="para"><%=user_name %></h2><%
UsersDaoImpl user=new UsersDaoImpl();
FineHistoryDaoImpl fineHistory=new FineHistoryDaoImpl();
	try {
				userWallet=user.setFine(u3);
				FineHistory fh1 = new FineHistory(user_name, fineOf);
				fineHistory.insert(fh1);
				} catch (Exception e) {
									
				e.printStackTrace();
				}%>
<h3>Your revised Wallet amount is <%=userWallet %></h3>				
<h3>Book Return Success</h3><br><br>
<h3><a href="user.jsp">Back to User Page</a></h3>&emsp;&emsp;
<button><a href="Logout.jsp" id="log">Log out</a></button>
</fieldset>				
</body>
</html>