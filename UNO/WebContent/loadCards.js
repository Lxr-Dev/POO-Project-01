/**
 * 
 */

window.onload = load;

function load() {
	var cookies = document.cookie;
	$.post("getCard.jsp",{"cookies":cookies},function(data){
		
		data = JSON.parse(`${data}`.trim());
		
		var images="";
		
		for (i in data){
			images +=`<button><img src="${data[i].img}" height="130vw"></button>`; 
			console.log(data[i].img);
		}
		document.querySelector("div#scrollmenu").innerHTML=images;
		
	});
	
	return false;
	
}