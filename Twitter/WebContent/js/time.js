function submitTweet(){
	document.querySelector("#inputTweet").addEventListener("keyup", function(event) {
    		event.preventDefault();
    		if (event.keyCode == 13) {
    			text = $("#inputTweet").val();
    			var regexp = /#([^#]+)[\s,;]*/g;
    			result = text.match(regexp);
    			hashtags = ""
    			if(result != null){
    				for(var i = 0; i < result.length; ++i){
    					hashtags += result[i].substr(1).replace(/\r?\n|\r/, "") + ",";
    				}
    			}
    			else{
    				hashtags = "null";
    			}
    			text = text.replace(/</g, "&lt;").replace(/>/g, "&gt;");
    			text = text.replace(/#(\S*)/g, '<span class="clickable" onclick="goToHashtag(&#39;$1&#39;)"><b>#$1</b></span>');
    			text = text.replace(/@(\S*)/g, '<span class="clickable" onclick="goProfile(&#39;$1&#39;)"><b>@$1</b></span>');
    			text = text.replace("\'", "\\'");
    			text = text.replace(/^\s+|\s+$/g, '');
    	    		id =  $("#inputTweet").attr("name");
    	    		if(text != ""){
	    	        	$.ajax({
	    	        		url: "timeline",
	    	        		type: "post",
	    	        		data: {postBody: text, postId: id , postHash: hashtags} ,
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
    	    	}
    	});
}

function goToHashtag(hash){
	$('.tweets').load("tweets",{"hash":hash},function(){
		$("#inputTweet").val("#"+hash);
	});
}

function deleteTweet(div,tweetId,ret){
	$.ajax({
		  type: "POST",
		  url: "timeline",
		  data: "delete='true'&tweetId="+ tweetId+ "&ret="+ ret,
		  success:function(){
			  div.parentNode.parentNode.remove();
			  $('.stats').load("stats");
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
	if(type != "rep"){
	$("[name='" + type + tweetId + "']").toggleClass(type);
	}
	else{
		$("[name='" + type + tweetId + "']").addClass(type);
	}
	if($("[name='"+type + tweetId + "']").hasClass(type)){
		$("[name='"+ type + tweetId + "'] + p")[0].innerHTML = (parseInt($("[name='"+ type + tweetId + "'] + p")[0].innerHTML) + 1);
	}
	else if($("[name='"+ type + tweetId + "'] + p")[0].innerHTML != 0 && type!="rep"){
		$("[name='"+ type + tweetId + "'] + p")[0].innerHTML = (parseInt($("[name='"+ type +tweetId + "'] + p")[0].innerHTML) - 1);
		add_del = "del";
	}
	d = {type: add_del+type, userId: userId ,tweetId : tweetId};
	if(add_del == "add" && type == "ret"){
		text = $("#"+tweetId)[0].innerText;
		text = text.replace(/</g, "&lt;").replace(/>/g, "&gt;");
		text = text.replace(/#(\S*)/g, '<span class="clickable" onclick="goToHashtag(&#39;$1&#39;)"><b>#$1</b></span>');
		text = text.replace(/@(\S*)/g, '<span class="clickable" onclick="goProfile(&#39;$1&#39;)"><b>@$1</b></span>');
		text = text.replace("\'", "\\'");
		d.text = text;
	}
	$.ajax({
		  type: "POST",
		  url: "timeline",
		  data: d,
		  success: function(){
			  if(add_del == "add" && type == "ret") {
				  $('.tweets').load("tweets");
			  }
		  }
	});
}

function showComment(div){
	$(div).parent().next().toggleClass("visible");
}

function goProfile(name){
	window.location.replace("http://localhost:8080/Twitter/" + name);
}

function submitComment(){
	$(".commentInput").keyup(function(event) {
		tweetId = this[0].id;
    		event.preventDefault();
    		if (event.keyCode == 13) {
    			text = $(".commentInput").val();
    			text = text.replace(/</g, "&lt;").replace(/>/g, "&gt;");
    			text = text.replace(/#(\S*)/g, '<span class="clickable" onclick="goToHashtag(&#39;$1&#39;)"><b>#$1</b></span>');
    			text = text.replace(/@(\S*)/g, '<span class="clickable" onclick="goProfile(&#39;$1&#39;)"><b>@$1</b></span>');
    			text = text.replace("\'", "\\'");
    			text = text.replace(/^\s+|\s+$/g, '');
    	    		//id =  $("#inputTweet").attr("name");
//    	    		if(text != ""){
//	    	        	$.ajax({
//	    	        		url: "timeline",
//	    	        		type: "post",
//	    	        		data: {postBody: text, postId: id , postHash: hashtags} ,
//	    	        		success: function(response, status, request) {
//	    	        			clickOption('rep',$(".commentInput")[0].name,$(".commentInput")[0].id);	
//	    	        			$('.tweets').load("tweets");
//	    	        		},
//	    	        		error: function(xhr) {
//	    	            		console.log(xhr)
//	    	            	}
//	    	        });
//    	    		}
    	    	}
    	});
}
