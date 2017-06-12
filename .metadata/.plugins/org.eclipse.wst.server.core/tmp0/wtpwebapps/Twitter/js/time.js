var TIME = {
		init: function(){
			submitTweet();
		}
}

function submitTweet(){
	$("#inputTweet").on('keyup', function (e) {
		that = this;
		text = this.value;
		id = this.name;
	    if (e.keyCode == 13) {
	    	$.ajax({
	    		url: "timeline",
	    		type: "post",
	    		data: "postBody="+ text +"&postId=" + id  ,
	    		success: function(response, status, request) {
	    			that.value = "";
	    			location.reload(); // canviar molt fort 
	    		},
	    		error: function(xhr) {
	        			//Do Something to handle error
	        	}
	        });
	    }
	});
}

function goProfile(user){
	$.ajax({
		url: "profile",
		type: "get",
		data: "user=" + user ,
		success: function(response, status, request) {
			var container = document.querySelector('.mainCont'); 
			container.innerHTML = response;
			$.ajaxSetup({ cache: false });
			document.title = user + " - Hackeet";
		},
		error: function(xhr) {
    			//Do Something to handle error
    	}
    });
}

TIME.init();
