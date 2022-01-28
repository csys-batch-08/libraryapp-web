<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Logout</title>
<style>
        #register{
            width: 450px;
            margin-left: 550px;
            margin-top:200px;
            
        }
        body{
            background-image: url(Assets/Rose-flowers-books.jpg);
            background-repeat: no-repeat;
            background-size:cover;
            color:white;
            text-decoration:none;
            font-size:larger;
        }

    </style>
</head>
<body>


<form action="userlogout" method="post" id="register">
<h1> Thanks for visiting us </h1>
<%
request.getSession().invalidate(); %>


</form>
<h2 id="timehead" style="visibility:hidden;"></h2>
</body>
<script>
let th = document.getElementById("timehead");
let time =3;
let i;
window.addEventListener('load', () =>{
	
	 i= setInterval(() => {
		if(time > 0){
			if(time >= 10){
				
		th.innerHTML = "00 : " + time--;
		
			}else{
				th.style.color = "red";
				th.innerHTML = "00 : 0" + time--;
			}
		}else{
			clearInterval(i);
			window.location.assign("index.jsp");
		}
	},1000);
	
});
</script>
</html>