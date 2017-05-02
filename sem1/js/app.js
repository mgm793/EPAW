var APP = {
	init: function(){
		calendar();
	}
}

function calendar(){
	document.querySelector('input[name="birthday"]').onfocus = function(){
		this.type = "date";
	};
	document.querySelector('input[name="birthday"]').onblur = function(){
		this.type = "text";
	};
}

APP.init();

