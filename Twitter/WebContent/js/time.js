function submitTweet(){
	document.querySelector("#inputTweet").addEventListener("keyup", function(event) {
    		event.preventDefault();
    		if (event.keyCode == 13) {
    			text = $("#inputTweet").val();
    			text = text.replace(/#([^ ]+)/, '<span class="clickable"><b>#$1</b></span>');
    	    		id =  $("#inputTweet").attr("name");
    	        	$.ajax({
    	        		url: "timeline",
    	        		type: "post",
    	        		data: "postBody="+ text +"&postId=" + id  ,
    	        		success: function(response, status, request) {
    	        			$("#inputTweet").val("");	
    	        			$('.tweets').load("tweets",function(){
    	        				
    	        			});
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
			document.title = "Hackeet";
		},
		error: function(xhr) {
    			//Do Something to handle error
    	}
    });
}
