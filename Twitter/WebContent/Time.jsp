<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="bodyLeft">
	<div class="profileSide">
		<div class ="profileInfo">
			<div class="head"></div>
			<div class="info">
				<img src="imgs/${sessionScope.user.image}" alt="icon">
				<div class="name">
				<p class="clickable" onclick="goProfile('${sessionScope.user.username}')"><b>${sessionScope.user.name}</b></p>
				<p class="clickable smallLink" onclick="goProfile('${sessionScope.user.username}')">@${sessionScope.user.username}</p>
				</div>
			</div>
			<div class="stats">
			<div><p>TWEETS</p><p class="num">${sessionScope.user.tweets}</p></div>
			<div><p>FOLLOWING</p><p class="num">${sessionScope.user.following}</p></div>
			<div><p>FOLLOWERS</p><p class="num">${sessionScope.user.followers}</p></div>
			</div>
		</div>
	</div>
	<div class="TTSide">
		<div class ="TTcontent">
			<p class="title">Trending Topics</p>
			<p class="hashtag clickable">#Barcelona</p>
			<p class="hashtag clickable">#Lund</p>
			<p class="hashtag clickable">#CacatuasPower</p>
			<p class="hashtag clickable">#Reticulos</p>
			<p class="hashtag clickable">#DoItForYourLover</p>
		</div>
	</div>
</div>
<div class="bodyCenter">
	<p class="type" style="display: none"> Timeline </p>
	<div class="input">
		<img src="imgs/logo_user.png" alt="img">
		<textarea id="inputTweet" maxlength="140" name="${sessionScope.user.id}" placeholder="What a hack?"></textarea>
	</div>
	<div class="tweets">
	<c:forEach var="tweet" items="${tweets}">
		<div class="tweet">
			<img src="imgs/${tweet.userInfo.image}" alt="img">
			<p class="header">
				<span class="bold clickable" onclick="goProfile('${tweet.userInfo.username}')">${tweet.userInfo.name}</span>
				<span class="grey clickable" onclick="goProfile('${tweet.userInfo.username}')">@${tweet.userInfo.username}</span>
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
	</div>
</div>
<div class="bodyRight">
	<div class="usersSide">
		<div class ="usersInfo">
			<p class="title">MVP Users</p>
			<div class="userBlock clickable">		
					<img alt="user image" src="imgs/logo_user.png">
					<div class="info">
						<p class="user">@mgm793</p>
					</div>
			</div>	
			<div class="userBlock clickable">		
					<img alt="user image" src="imgs/logo_user.png">
					<div class="info">
						<p class="user">@mgm793</p>
					</div>
			</div>	
			<div class="userBlock clickable">		
					<img alt="user image" src="imgs/logo_user.png">
					<div class="info">
						<p class="user">@mgm793</p>
					</div>
			</div>	
		</div>
	</div>
</div>