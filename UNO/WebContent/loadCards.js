/**
 * 
 */

window.onload = load;

function load() {
	var cookies = document.cookie;
	$.post("getCard.jsp",{"cookies":cookies},function(data){
		
		data = JSON.parse(`${data}`.trim());
		
		var images="";
		
		for (i in data.deck){
			images += `<button onclick="Throw(this);" value="${i}"><img src="${data.deck[i].img}" height="115vw"></button>`; 
			console.log(data.deck[i].img);
		}
		document.querySelector("div#scrollmenu").innerHTML=images;
		
		images="";
		for (i = 0;i<data.enemy;i++){
			images +=`<img src="Resources/BackCard.png" height="115vw">`;
		}
		document.querySelector("div#enemyCards").innerHTML=images;

		document.querySelector("img#graveyard").src = data.graveyard[0].img;
		document.querySelector("img#graveyard").dataset.value = data.graveyard[0].value;
		
		if (data.graveyard[0].color == 0){
			document.querySelector("canvas#currentColor").style.backgroundColor = "green";
		}else
		if(data.graveyard[0].color == 1){
			document.querySelector("canvas#currentColor").style.backgroundColor = "orange";
		}else
		if(data.graveyard[0].color == 2){
			document.querySelector("canvas#currentColor").style.backgroundColor = "pink";
		}else
		if(data.graveyard[0].color == 3){
			document.querySelector("canvas#currentColor").style.backgroundColor = "gray";
		}else{
			document.querySelector("canvas#currentColor").style.backgroundColor = "green";
		}
		
	});
	
	return false;
	
}