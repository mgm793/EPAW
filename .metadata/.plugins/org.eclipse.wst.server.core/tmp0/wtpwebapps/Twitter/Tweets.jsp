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
			</p>
			<p class="bodytweet">
				${tweet.text}
			</p>
			<div class="options">
				<i class="material-icons" id="reply">reply</i><p>${tweet.comments}</p>
				<i class="material-icons" id="retuit">repeat</i><p>${tweet.retweets}</p>
				<i class="material-icons" id="fav">favorite</i><p>${tweet.loves}</p>
			</div>
		</div>
	</c:forEach>