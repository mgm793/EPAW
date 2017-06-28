<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>
function deleteTweetAdmin(div,tweetId){
	$.ajax({
		  type: "POST",
		  url: "timeline",
		  data: "delete='true'&tweetId="+ tweetId+ "&ret="+ 0,
		  success:function(){
			  div.parentNode.parentNode.remove();
		  }
	});
}
</script>
<div class="succes">
		<div class="message">
			<div class="image_succes">
				<div class="insImage"><img class="anoImage" src="imgs/ano.png"></div>
			</div>
			<div class="messTitle"> TWEETS </div>
			<div class="resTable">
				<table class="usersTable" id="usersTable">
					<tr>
						<th> ID </th>
						<th> Username </th>
						<th> Text </th>
						<th> Delete </th>
					</tr>
					<c:forEach items="${tweets}" var="tweet">
						<tr>
							<td> ${tweet.id}  </td> 
							<td> ${tweet.userInfo.username}  </td> 
							<td> ${tweet.text} </td>
							<td><i class="material-icons clickable" onclick="deleteTweetAdmin(this,${tweet.id})">close</i></td>
						</tr>			
					</c:forEach>
				</table>
			</div>	
		</div>
	</div>