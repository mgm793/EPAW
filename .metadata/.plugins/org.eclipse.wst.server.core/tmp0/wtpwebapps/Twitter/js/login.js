function submitLogin(form){
	event.preventDefault();
	$.ajax({
		url: "login",
		type: "post",
		data: $( form ).serialize(),
		success: function(response, status, request) {
			var container = document.querySelector('.mainCont'); 
			container.innerHTML = response;
			$.ajaxSetup({ cache: false }); // Avoids Internet Explorer caching!
			$('.right').load('header');
			str = document.querySelector(".type").innerText.toLowerCase();
			str = str.replace(/\b\w/g, l => l.toUpperCase());
			document.title = str + " - Hackeet";
		},
		error: function(xhr) {
    			//Do Something to handle error
    	}
    });
}