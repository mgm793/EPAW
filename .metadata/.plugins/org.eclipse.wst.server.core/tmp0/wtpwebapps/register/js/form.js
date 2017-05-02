var FORM = {
	init: function(){
		calendar();
		checkPassword();
	},
	validate: {
		pass: false,
		age: false
	}
}

function calendar(){
	document.querySelector('input[name="birthday"]').onfocus = function(){
		this.type = "date";
		setMinDate();
	};
	document.querySelector('input[name="birthday"]').onblur = function(){
		if(this.value == "") this.type = "text";
	};
}

function checkPassword(){
	document.querySelector('[name="pass2"]').onblur = function(){
		pass1 = document.querySelector('[name="pass1"]');
		if (pass1.value != this.value){
			pass1.style.borderColor = this.style.borderColor = "red";
		}
		else{
			pass1.style.borderColor = this.style.borderColor = "lightGrey";
		}
	};
}

function setMinDate(){
	var now = new Date();
	var year = now.getFullYear() - 16;
	var month = (now.getUTCMonth() + 1 >= 10 ? "" : "0") + (now.getUTCMonth() + 1);
	var day = (now.getDay() >= 10 ? "" : "0") + now.getDay();
	document.querySelector('[name = birthday]').min = year + "-" + month + "-" +  day;
}