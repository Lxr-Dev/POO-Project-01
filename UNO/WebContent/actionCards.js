function Throw(btn){
	var cookies = document.cookie;
	$.post("Validator.jsp",{"cookies":cookies,"index":btn.value},function(data){
		
	});
	return false;
}