<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
	$(document).ready(function(){
		submitTweet();
	});
</script>
<div class="bodyLeft">
	<div class="profileSide">
		<div class ="profileInfo">
			<div class="head"></div>
			<div class="infoProfile">
				<img class="fotoGran"src="imgs/${userInfo.image}" alt="icon">
			</div>
			<div class="name_descr">
				<c:choose>
				<c:when test="${userInfo.id != sessionScope.user.id && sessionScope.user != null}">
				<div class="follow clickable" onclick="follow(${sessionScope.user.id},${userInfo.id})">
					<i class="material-icons">person_add</i><p>Follow</p>
				</div>
				</c:when>
				<c:otherwise>
					
				</c:otherwise>
				</c:choose>
				
				<div class="nameInfo">
					<p><b>${userInfo.name}</b> <span class="smallLink">@${userInfo.username}</span></p>
				</div>
				<div class="descr">
					<p>${userInfo.description}</p>
				</div>
			</div>
			<div class="stats">
				<div><p>TWEETS</p><p class="num">${userInfo.tweets}</p></div>
				<div><p>FOLLOWING</p><p class="num">${userInfo.following}</p></div>
				<div><p>FOLLOWERS</p><p class="num">${userInfo.followers}</p></div>
			</div>
		</div>
	</div>
</div>
<div class="bodyCenter">
	<p class="type" style="display: none"> Timeline </p>
	<c:if test="${sessionScope.user != null}">
	<div class="input">
		<img src="imgs/logo_user.png" alt="img">
		<textarea id="inputTweet" maxlength="140" placeholder="What a hack?"></textarea>
	</div>
	</c:if>
	<div class="tweets">
		<jsp:include page="Tweets.jsp" />
	</div>
</div>
<div class="bodyRight">
	<div class="usersSide">
		<div class ="usersInfo">
			<p class="title">MVP Users</p>
			<c:forEach var="mvp" items="${MVP}">
			<div class="userBlock clickable" onclick="goProfile('${mvp}')">		
					<img alt="user image" src="imgs/logo_user.png">
					<div class="info">
						<p class="user">@${mvp}</p>
					</div>
			</div>
			</c:forEach>
		</div>
</div>

