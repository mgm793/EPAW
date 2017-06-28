function submitSettings(form){
	event.preventDefault();
	$(".mainCont").load("setting",$(form).serialize());
	$.ajax({
		url: "setting",
		type: "post",
		data: $(form).serialize(),
		success: function(response, status, request) {
			
		},
		error: function(xhr) {
			//Do Something to handle error
		}
	});
}