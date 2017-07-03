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
			<div class="head">
					<c:if test="${userInfo.id == sessionScope.user.id && sessionScope.user != null}">
						<i class="material-icons settings clickable" onclick="settings()">settings</i>
					</c:if></div>
			<div class="infoProfile">
				<img class="fotoGran"src="${userInfo.image}" alt="icon">
			</div>
			<div class="name_descr">
				<c:if test="${userInfo.id != sessionScope.user.id && sessionScope.user != null}">
				<div class="follow clickable<c:if test="${isFollow == true}"> following</c:if>" onclick="follow(${sessionScope.user.id},${userInfo.id})">
					<i class="material-icons">person_add</i>
					<p>
						<c:choose>
							<c:when test="${isFollow == true}">Unfollow</c:when>
							<c:otherwise>Follow</c:otherwise>
						</c:choose>
					</p>
				</div>
				</c:if>
				<div class="nameInfo">
					<p><b>${userInfo.name}</b> <span class="smallLink">@${userInfo.username}</span></p>
				</div>
				<div class="descr">
					<p>${userInfo.description}</p>
				</div>
				<div><b>Team:</b> <span class="clickable" onclick="gotoTeam('${userInfo.team}')">${userInfo.team}</span></div>
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
		<img src="${userInfo.image}" alt="img">
		<textarea id="inputTweet" maxlength="140" <c:if test="${sessionScope.user.id != userInfo.id}">style="background-color: lightgrey;"</c:if>name="${userInfo.id}" placeholder="What a hack?" <c:if test="${sessionScope.user.id != userInfo.id}">disabled</c:if>></textarea>
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
			<div class="userBlock clickable" onclick="goProfile('${mvp.name}')">		
					<img alt="user image" src="${mvp.image}">
					<div class="info">
						<p class="user">@${mvp.name}</p>
					</div>
			</div>
			</c:forEach>
		</div>
	</div>
</div>

