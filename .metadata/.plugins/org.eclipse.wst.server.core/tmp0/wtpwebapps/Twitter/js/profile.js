function follow(id1,id2){
	type = "follow";
	$(".follow").toggleClass("following");
	if($(".follow").hasClass("following")){
		$(".following p")[0].innerHTML = "Unfollow";
	}
	else{
		type = "unfollow"
		$(".follow p")[0].innerHTML = "Follow";
	}
	$.ajax({
		type: "POST",
		url: "profile",
		data: "type="+ type +"&id1=" + id1 + "&id2=" + id2
	});
}

function gotoTeam(team){
	$('.mainCont').load("timeline", function(){
		window.history.pushState(null, "", "/Twitter/");
		$('.tweets').load("tweets",{team:team});
	});
}

function settings(){
	$('.mainCont').load('setting');
}