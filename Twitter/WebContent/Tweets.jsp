<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
	$(document).ready(function(){
		submitComment();
	});
</script>
<c:forEach var="tweet" items="${tweets}">
		<div class="tweet">
			<c:if test="${tweet.isretweet != 0}">
			<div class="retweet">
				<i class="material-icons">autorenew</i>
				<c:choose>
				<c:when test="${tweet.nameRET != sessionScope.user.name or sessionScope.user == null}">${tweet.nameRET} has retweeted</c:when>
				<c:otherwise>You have retweeted</c:otherwise>
				</c:choose>
			</div>
			</c:if>
			<img src="${tweet.userInfo.image}" alt="img">
			<p class="header">
				<span class="bold clickable" onclick="goProfile('${tweet.userInfo.username}')">${tweet.userInfo.name}</span>
				<span class="grey clickable" onclick="goProfile('${tweet.userInfo.username}')">@${tweet.userInfo.username}</span>
				<span class="grey"> · </span>
				<span class="grey">${tweet.date}</span>
				<c:if test = "${sessionScope.user != null && ((tweet.userInfo.id == sessionScope.user.id && tweet.isretweet == 0) || tweet.nameRET == sessionScope.user.username)}">
				<span class="delete clickable" onclick="deleteTweet(this,'${tweet.id}', ${tweet.isretweet})"><i class="material-icons">close</i></span>
				</c:if>
			</p>
			<p class="bodytweet" id="${tweet.id}">
				${tweet.text}
			</p>
			<c:if test="${sessionScope.user != null}">
			<div class="options no-select">
				<i class="material-icons<c:if test="${tweet.isComment == true}"> rep</c:if>" onclick="showComment(this)" id="reply" name="rep${tweet.id}">reply</i><p>${tweet.comments}</p>
				<i class="material-icons<c:if test="${tweet.isRet == true}"> ret</c:if>" onclick="clickOption('ret',${sessionScope.user.id},'${tweet.id}')" id="retuit" name="ret${tweet.id}">autorenew</i><p>${tweet.retweets}</p>
				<i class="material-icons<c:if test="${tweet.isLove == true}"> fav</c:if>" onclick="clickOption('fav',${sessionScope.user.id},'${tweet.id}')" id="fav" name="fav${tweet.id}">favorite</i><p>${tweet.loves}</p>
			</div>
			</c:if>
			<div class="commentSection">
			<c:forEach var="comment" items="${tweet.commList}">
				<div class="comment">
					<p class="Comtitle"><b>${comment.name}</b> says:</p>
					<c:if test="${comment.userId == sessionScope.user.id}">
					<i class="material-icons clickable" onclick="delComment(this,${comment.userId},${tweet.id},'${comment.text}')">close</i>
					</c:if>
					<p class="textCom">${comment.text}</p>
				</div>
			</c:forEach>
				<form class="commentInput tweet${tweet.id}" name="${sessionScope.user.id}" title ="${sessionScope.user.name}" id="${tweet.id}">
					<textarea placeholder="Write the comment here..." maxlength="140"></textarea>
				</form>
			</div>
		</div>
	</c:forEach>