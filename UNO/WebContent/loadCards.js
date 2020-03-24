/**
 * 
 */

window.onload = load;

function load() {
	var cookies = document.cookie;
	$.post("getCard.jsp",{"cookies":cookies},function(data){
		
		data = JSON.parse(`${data}`.trim());
		console.log(data);
		document.querySelector("div#Deck").innerHTML=data;
	});
	
	return false;
	
}