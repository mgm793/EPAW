function submitTweet(){
	document.querySelector("#inputTweet").addEventListener("keyup", function(event) {
    		event.preventDefault();
    		if (event.keyCode == 13) {
    			text = $("#inputTweet").val();
    			var regexp = /\B\#\w\w+\b/g
    			result = text.match(regexp);
    			if(result != null){
    				for(var i = 0; i < result.length; ++i){
    					result[i] = result[i].substr(1);
    				}
    			}
    			else result = "null";
    			text = text.replace(/</g, "&lt;").replace(/>/g, "&gt;");
    			text = text.replace(/#(\S*)/g, '<span class="clickable"><b>#$1</b></span>');
    			text = text.replace("\'", "\\'");
    			console.log(result);
    	    		id =  $("#inputTweet").attr("name");
    	        	$.ajax({
    	        		url: "timeline",
    	        		type: "post",
    	        		data: {postBody: text, postId: id , postHash: result.toString()} ,
    	        		success: function(response, status, request) {
    	        			$("#inputTweet").val("");	
    	        			$('.tweets').load("tweets");
    	        			$('.stats').load("stats");
    	        		},
    	        		error: function(xhr) {
    	            			console.log(xhr)
    	            	}
    	        });
    	    	}
    	});
}

function clickOption(type,userId, tweetId){
	switch(type){
		case 'fav': 
			color = 'red';
			break;
		case 'ret': 
			color = '#4CAF50'; 
			break;
		case 'rep': 
			color = '#1B5E20'; 
			break;
	}
	add_del = "add";
	$("[name='" + type + tweetId + "']").toggleClass(type);
	if($("[name='"+type + tweetId + "']").hasClass(type)){
		$("[name='"+ type + tweetId + "'] + p")[0].innerHTML = (parseInt($("[name='"+ type + tweetId + "'] + p")[0].innerHTML) + 1);
	}
	else if($("[name='"+ type + tweetId + "'] + p")[0].innerHTML != 0){
		$("[name='"+ type + tweetId + "'] + p")[0].innerHTML = (parseInt($("[name='"+ type +tweetId + "'] + p")[0].innerHTML) - 1);
		add_del = "del";
	}
	$.ajax({
		  type: "POST",
		  url: "timeline",
		  data: "type="+add_del+type+"&userId="+userId+"&tweetId="+tweetId,
	});
}

function goProfile(name){
	window.location.replace("http://localhost:8080/Twitter/" + name);
}
