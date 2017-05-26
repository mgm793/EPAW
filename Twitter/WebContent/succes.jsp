<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<div class="succes">
		<div class="message">
			<div class="image_succes">
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
					<c:forEach items="${users}" var="user">
						<tr>
							<td> ${user.getUser()}  </td> 
							<td> ${user.getMail()} </td>
							<td> ${user.getPass()} </td>
							<td> ${user.getBirthD()} </td>
							<td> ${user.getTeam()} </td>
						</tr>					
					</c:forEach>
				</table>
			</div>	
		</div>
	</div>
