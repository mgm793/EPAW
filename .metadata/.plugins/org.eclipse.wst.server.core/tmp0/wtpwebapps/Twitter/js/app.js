var APP = {
	init: function(){
		goTo("home");
		checkClick();
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
	document.querySelector('.register').onclick = function(){
		goTo("register");
	}
	document.querySelector('.login').onclick = function(){
		goTo("login");	
	}
	document.querySelector('.left').onclick = function(){
		goTo("home");	
	}
}

APP.init();

