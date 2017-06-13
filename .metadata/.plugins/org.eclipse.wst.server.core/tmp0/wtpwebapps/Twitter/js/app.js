var APP = {
	init: function(){
		checkClick();
		$('.right').load('header');
	}
}

function goTo(str){
	$('.mainCont').load(str, function(){
		if(str == "register")
			REGISTER.init();
		str = str.replace(/\b\w/g, l => l.toUpperCase());
		document.title = str + " - Hackeet";
	});
}

function checkClick(){
	document.querySelector('.left').onclick = function(){
		window.location.replace("http://localhost:8080/Twitter/");
		goTo("home");	
	}
}


APP.init();

