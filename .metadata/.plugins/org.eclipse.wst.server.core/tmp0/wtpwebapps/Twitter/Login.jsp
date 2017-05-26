<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container_login">
<form onsubmit="submitLogin(this)">
	<div class="header">
		<div class="img-head">
			<img src="imgs/ano.png" alt="img">
		</div>
		<p class="type">LOGIN</p>
	</div>
	<input type="text" name="user" placeholder="Username" autofocus required minlength=4 maxlength=10>
	<input type="password" name="pass" placeholder="Password" required>
	
	<div class="check no-select">
      <input type="checkbox" id="c1" name="cb" value="1">
      <label for="c1">Remember me</label>
    </div>
	<button class="btn-submit" id="send">Submit</button>
</form>
</div>
<c:if test='${error == "true"}'>
	<div class="error">
		<div class="errorContainer">
		<p>The username or the password do not exist, nice try!</p>
		<div class="closeBtn" onclick="closeError()">Close</div>
		</div>
	</div>
</c:if>
