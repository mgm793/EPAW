<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:choose>
<c:when test="${sessionScope.user==null}">
<div class="tab register">Register</div>
<div class="tab login">Login</div>
<script type="text/javascript">
	$(document).ready(function() {
		$(".tab").click(function(event) {
			goTo($(this).attr('class').split(' ')[1]);
		});
	});
</script>
</c:when>
<c:otherwise>
<div class="nameshow clickable" onclick="goProfile('${sessionScope.user.username}')"> ${sessionScope.user.username} </div>
<div class="logout">Logout</div>
<script type="text/javascript">
	$(document).ready(function() {
		$(".logout").click(function(event) {
			$.ajax({
				url: "logout",
				type: "get",
				success: function(response, status, request) {
					var container = document.querySelector('.mainCont'); 
					container.innerHTML = response;
					str = document.querySelector(".type").innerText.toLowerCase();
					str = str.replace(/\b\w/g, l => l.toUpperCase());
					document.title = str + " - Hackeet";
	    			$.ajaxSetup({ cache: false }); // Avoids Internet Explorer caching!
	    			$('.right').load('header');
				},
				error: function(xhr) {
	    			//Do Something to handle error
	    		}
	    	});
		});
	});
</script>
</c:otherwise>
</c:choose>