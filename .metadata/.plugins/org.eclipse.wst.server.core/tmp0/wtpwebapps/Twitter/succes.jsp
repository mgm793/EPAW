<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<script>
		function deleteUser(id){
			$(".mainCont").load("admin",{deleteUser: id});
		}
		function gotoTweets(id){
			$(".mainCont").load("admin",{gotoTweets: id});
		}
	</script>
	<div class="succes">
		<div class="message">
			<div class="image_succes">
				<div class="insImage"><img class="anoImage" src="imgs/ano.png"></div>
			</div>
			<div class="messTitle"> USERS </div>
			<div class="resTable">
				<table class="usersTable" id="usersTable">
					<tr>
						<th> ID </th>
						<th> Username </th>
						<th> Name </th>
						<th> Email </th>
						<th> Team Name</th>
						<th> Tweets </th>
						<th> Delete </th>
					</tr>
					<c:forEach items="${users}" var="user">
					<c:if test="${'admin' != user.username}">
						<tr>
							<td> ${user.id}  </td> 
							<td> ${user.username}  </td> 
							<td> ${user.name} </td>
							<td> ${user.mail} </td>
							<td> ${user.team} </td>
							<td><i class="material-icons clickable" onclick="gotoTweets(${user.id})">view_list</i></td>
							<td><i class="material-icons clickable" onclick="deleteUser(${user.id})">close</i></td>
						</tr>
					</c:if>				
					</c:forEach>
				</table>
			</div>	
		</div>
	</div>
