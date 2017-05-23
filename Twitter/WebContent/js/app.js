var APP = {
	init: function(){
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

function checkLogout(){
	document.querySelector('.logout').onclick = function(){
		 $.ajax({
				url: "logout",
				type: "get",
				success: function(response, status, request) {
					console.log(response);
					var container = document.querySelector('.mainCont'); 
					container.innerHTML = response;
					str = document.querySelector(".type").innerText.toLowerCase();
					str = str.replace(/\b\w/g, l => l.toUpperCase());
					document.title = str + " - Hackeet";
				},
				error: function(xhr) {
	    			//Do Something to handle error
	    		}
	    	});
	}
}

APP.init();

