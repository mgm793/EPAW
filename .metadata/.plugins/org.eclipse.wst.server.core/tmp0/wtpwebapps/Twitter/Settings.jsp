<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="form" >
<form onsubmit="submitSettings(this)" >
	<div class="header">
		<div class="img-head">
			<img src="imgs/ano.png" alt="img">
		</div>
		<p class="type">SETTINGS</p>
	</div>
	<input type="text" name="userName" placeholder="Name" autofocus minlength=4 maxlength=10 value="${sessionScope.user.name}">
	<input type="email" name="mail" placeholder="Email" value="${sessionScope.user.mail}">
	<input type="password" name="pass" placeholder="New Password">
	<input type="password" name="pass2" placeholder="Repeat Password">
	<input type="text" name="img" placeholder="New Image Url">
	<textarea type="text" class="descrSet" name="descr" placeholder="Descrition">${sessionScope.user.description}</textarea>
	<input list="teams" name="team" placeholder="Team Name" value="${sessionScope.user.team}">
	<datalist id ="teams">
		<c:forEach items="${teams}" var="team">
			<option value="${team}"></option>
		</c:forEach>
	</datalist>
	<button class="btn-submit" id="send">Submit</button>
</form>
</div>
