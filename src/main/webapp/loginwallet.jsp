<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.library.dao.impl.*" import="com.library.model.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Wallet</title>
<link rel="stylesheet" href="assets/css/loginwallet.css">
</head>
<body>





<fieldset id="register">
<legend></legend>
<form>			
<label>Card Number</label><br>
<input type="text" id="card1" required pattern="[0-9]{16}" oninvalid="setCustomValidity('Card number must have 16 digits')" onchange="try{setCustomValidity('')}catch(e){}"  ><br><br>
<label>CVV</label><br>
<input type="text" id="card2" required pattern="[0-9]{3}" oninvalid="setCustomValidity('cvv contains only three digits')" onchange="try{setCustomValidity('')}catch(e){}"  ><br><br>
<label>Expiry Date</label><br>
<input type="month" id="card3" required min="2022-02" max="2030-12" ><br><br>
<button type="submit"><a href="WalletRecharge">Pay</a></button>
</form>			
	</fieldset>	
</body>
</html>