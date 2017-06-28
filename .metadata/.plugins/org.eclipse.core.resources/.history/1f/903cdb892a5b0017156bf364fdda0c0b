function closeError(){
	$(".error").hide();
}


function submitLogin(form){
	event.preventDefault();
	if($( "#c1:checked" ).val() != undefined) {
		var check = "true";
	}
	else check = "false";
	$('.mainCont').load("login",$( form ).serialize() + "&check=" + check, function(){
		$('.right').load('header');
		str = document.querySelector(".type").innerText.toLowerCase();
		str = str.replace(/\b\w/g, l => l.toUpperCase());
		document.title = str + " - Hackeet";
	});
}