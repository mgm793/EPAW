<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="form" >
<form onsubmit="submitRegister(this)" >
	<div class="header">
		<div class="img-head">
			<img src="imgs/ano.png" alt="img">
		</div>
		<p class="type">REGISTER</p>
	</div>
	<input type="text" name="user" placeholder="Username*" autofocus required minlength=4 maxlength=10>
	<input type="email" name="mail" placeholder="Email*" required>
	<input type="password" name="pass" placeholder="Password*" required>
	<input type="password" name="pass2" placeholder="Repeat Password" required>
	<input type="text" name="birthD" placeholder="Birthday*" required>
	<input list="teams" name="team" placeholder="Team Name">
	<datalist id ="teams">
		<c:forEach items="${teams}" var="team">
			<option value="${team}"></option>
		</c:forEach>
	</datalist>
	<h5>*Required</h5>
	<button class="btn-submit" id="send">Submit</button>
</form>
</div>
<script src="js/register.js"></script>
