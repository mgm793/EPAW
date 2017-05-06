<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" import="models.BeanUser" %>
<%@page import="java.util.List"%>
<%@page import="models.BeanUser" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="css/succes.css">
	<link rel="shortcut icon" type="image/x-icon" href="imgs/ano_white.png">
	<title>Succes</title>
</head>
<body>
	<div class="container">
		
		<div class="message">
			<div class="image">
				<div class="insImage"><img class="anoImage" src="imgs/ano.png"></div>
			</div>
			<div class="messTitle"> USERS </div>
			<div class="resTable">
				<table class="usersTable" id="usersTable">
					<tr>
						<th> Username</th>
						<th> Email </th>
						<th> Password </th>
						<th> Birthday </th>
						<th> Team Name</th>
					</tr>
					<%
					List<BeanUser> users = (List<BeanUser>) request.getAttribute("users");
					if(users!=null){
						for(BeanUser user: users){
							out.println(
								"<tr>" + 
								"<td>" + user.getUser() + "</td>" +
								"<td>" + user.getMail() + "</td>" +
								"<td>" + user.getPass() + "</td>" +
								"<td>" + user.getBirthD() + "</td>" +
								"<td>" + user.getTeam() + "</td>" +
								"</tr>"
							);
						}
					}
					%>
				</table>
			</div>	
		</div>
	</div>
</body>
</html>