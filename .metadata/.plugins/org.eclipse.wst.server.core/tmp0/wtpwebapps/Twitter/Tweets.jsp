<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:forEach var="tweet" items="${tweets}">
		<div class="tweet">
			<img src="imgs/${tweet.userInfo.image}" alt="img">
			<p class="header">
				<span class="bold clickable" onclick="goProfile('${tweet.userInfo.name}')">${tweet.userInfo.name}</span>
				<span class="grey clickable" onclick="goProfile('${tweet.userInfo.name}')">@${tweet.userInfo.username}</span>
				<span class="grey"> · </span>
				<span class="grey">${tweet.date}</span>
				<c:if test = "${tweet.userInfo.id == sessionScope.user.id}">
				<span class="delete clickable"><i class="material-icons">close</i></span>
				</c:if>
			</p>
			<p class="bodytweet">
				${tweet.text}
			</p>
			<c:if test="${sessionScope.user != null}">
			<div class="options no-select">
				<i class="material-icons<c:if test="${tweet.isComment == true}"> rep</c:if>" onclick="clickOption('rep',${sessionScope.user.id},'${tweet.id}')" id="reply" name="rep${tweet.id}">reply</i><p>${tweet.comments}</p>
				<i class="material-icons" onclick="clickOption('ret',${sessionScope.user.id},'${tweet.id}')" id="retuit" name="ret${tweet.id}">autorenew</i><p>${tweet.retweets}</p>
				<i class="material-icons<c:if test="${tweet.isLove == true}"> fav</c:if>" onclick="clickOption('fav',${sessionScope.user.id},'${tweet.id}')" id="fav" name="fav${tweet.id}">favorite</i><p>${tweet.loves}</p>
			</div>
			</c:if>
		</div>
	</c:forEach>