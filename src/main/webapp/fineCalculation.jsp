<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
        button{
        font-size:medium;
        }
        body{
            background-image: url(Assets/Bgimage.jpeg);
            background-repeat: no-repeat;
            background-size:cover;
            color:springgreen;
            font-size:larger;
        }
        #para{
        text-transform:capitalize;
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
int fineOf=Integer.parseInt(session.getAttribute("fineamount").toString());
String user_name=null;
if (fineOf > 0) {
	user_name=session.getAttribute("user").toString();
%>
	<p id="para"><%=user_name %></p><p>you have fine of rs</p><%=fineOf %>
	<p>	You have to pay now</p>
	<button type="submit"><a href="returnSuccess.jsp">Pay now</a></button>
	<%}else{
	response.sendRedirect("returnSuccess.jsp");} %>
</fieldset>							
</body>
</html>