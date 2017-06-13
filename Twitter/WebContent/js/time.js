function submitTweet(){
	document.querySelector("#inputTweet").addEventListener("keyup", function(event) {
    		event.preventDefault();
    		if (event.keyCode == 13) {
    			text = $("#inputTweet").val();
    			text = text.replace(/#(\S*)/g, '<span class="clickable"><b>#$1</b></span>');
    			text = text.replace("\'", "\\'");
    			var regexp = /\B\#\w\w+\b/g
    			result = text.match(regexp);
    			if(result != null){
    				for(var i = 0; i < result.length; ++i){
    					//add(result[i].substr(1));
    				}
    			}
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

function goProfile(name){
	console.log(name);
	window.location.replace("http://localhost:8080/Twitter/" + name);
}
