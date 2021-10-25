<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div align="center">
		<h1>staff Register </h1>
		
		
		<%String  error=(String)request.getAttribute("error") ;
if(error==null)
	error = "";
else
	error=(String)request.getAttribute("errror");
%>	
		<form action="register" method="post">
		
 <label for ="firstname">FirstName</label>
 <input type="text" id="firstname" name="firstName"><br><br>
 <label for="lastname">LastName</label>
 <input type="text" id="lastname" name="lastName"><br><br>
 <label for="email">Email</label>
 <input type="email" id="email" name="email"><br><br>
 <label for="phoneNumber">PhoneNumber</label>
 <input type="number" id="PhoneNumber" name="phoneNumber"><br><br>
 <label for ="username">UserName</label>
 <input type="text" id="username" name="username"><br><br>
 <label for ="password">Password</label>
 <input type="password" id="password" name="password"><br><br>
 
 <label for ="confirmPassword">ConfirmPassword</label>
 <input type="password" id="firstname" name="confirmationPassword" required ="required"><br><br>
 
 
 <% if(error==null)error = "";%>
<%if( error!=null)error=(String)request.getAttribute("error"); 
out.println("<font color=red size=4px>"+error+"</font>");
%> 
 <tr><td><input type="submit" name ="register" value="register"></td>
    
 <td><a href ="http://localhost:8080/RegistrationForm/login.jsp"></a></td></tr>
		</form>
	</div>



</body>
</html>