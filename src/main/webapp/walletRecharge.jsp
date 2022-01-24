<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.library.dao.impl.*" import="com.library.model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Recharge Wallet</title>
<style>
        #register{
        background-image:linear-gradient(rgba(0,0,0,0.5),rgba(0,0,0,0.5));
            background-repeat: no-repeat;
            width: 350px;
            margin-top:50px;
            margin-left: 600px;
            
        }

       html
        {
          background-image:url(Assets/Bgimage.jpeg);
            background-repeat: no-repeat;
            background-size:cover;
            color:white;
            font-size:larger;
        }
        button,a{
        font-size:medium;
        text-decoration:none;
        color:black;
        }

h3 {
	text-transform: capitalize;
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
<%int walletold=(int)session.getAttribute("oldwallet");
String name=session.getAttribute("user").toString();
int newWallet=walletold+500;
session.setAttribute("userWalletLogin", newWallet); %>
	<p><h3><%=name %></h3> your walletamount is <%=walletold%> .It is very low</p>
	<p>You have to recharge your wallet with rs.500 to enter in to library</p>
	<p>Are you ready to pay </p>
	<button type="submit"><a href="loginwallet.jsp">Pay now</a></button>&emsp;
	<button type="submit"><a href="index.jsp">Pay later</button>&emsp;
	<button><a href="Logout.jsp">Logout</a></button>
			

</body>
<script>

function fieldhid(){
let field = document.getElementById("card");
field.style.visibility = "visibile";
}
</script>
</html>