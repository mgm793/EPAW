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
      <input type="checkbox" id="c1" name="cb">
      <label for="c1">Remember me</label>
    </div>
	<button class="btn-submit" id="send">Submit</button>
</form>
</div>
