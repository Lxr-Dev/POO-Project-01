/**
 * 
 */

var running;

window.onload = load;
function load() {
	var cookies = document.cookie;
	$.post("getCard.jsp",{"cookies":cookies},function(data){
		
		data = JSON.parse(`${data}`.trim());
		
		var images="";
		
		for (i in data.deck){
			images += `<img style="margin:5px;" class="deckCards" onclick="Throw(this);" data-value="${i}" src="${data.deck[i].img}" height="115vw"/>`; 
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
			document.querySelector("canvas#currentColor").dataset.value = 0;
		}
		else if(data.graveyard[0].color == 1){
			document.querySelector("canvas#currentColor").style.backgroundColor = "orange";
			document.querySelector("canvas#currentColor").dataset.value = 1;
		}
		else if(data.graveyard[0].color == 2){
			document.querySelector("canvas#currentColor").style.backgroundColor = "pink";
			document.querySelector("canvas#currentColor").dataset.value = 2;
		}
		else if(data.graveyard[0].color == 3){
			document.querySelector("canvas#currentColor").style.backgroundColor = "gray";
			document.querySelector("canvas#currentColor").dataset.value = 3;
		}else{
			document.querySelector("canvas#currentColor").style.backgroundColor = "green";
			document.querySelector("canvas#currentColor").dataset.value = 4;
		}
		
		if(document.querySelector("img#graveyard").getAttribute('data-value')){
			document.getElementById("colorSelect").style.visibility = "visible";
		}
		var running = setTimeout(listener,2500);
	});
	
	return false;	
}

function listener(){
	$.post("changeTurn.jsp",{"cookies":document.cookie},function(data){
		data = JSON.parse(`${data}`);
		if(data.yourTurn){
			console.log("Es tu turno chaval");
		}else{
			console.log("No es tu turno, estoy esperando");
		}
		load();
	});
}

function Throw(imgButton){

	var cookies = document.cookie;
	var color = document.querySelector("canvas#currentColor").getAttribute('data-value');
	var currentValue = document.querySelector("img#graveyard").getAttribute('data-value');
	
	if(imgButton.getAttribute('data-value') == "14"){
		
		document.getElementById("colorSelect").style.visibility = "visible";
		
		$.post("Validator.jsp",{"cookies":cookies,"index":imgButton.getAttribute('data-value'),"currentColor":color,"currentValue":currentValue,"option":"throw"},function(data){
			data = JSON.parse(`${data}`);
			if(data.status){	
				document.querySelector("img#graveyard").src = imgButton.src;
			}
			else {
				alert("No sea tonto, tire otra carta");
			}
		});
	}
	else{		
		$.post("Validator.jsp",{"cookies":cookies,"index":imgButton.getAttribute('data-value'),"currentColor":color,"currentValue":currentValue,"option":"throw"},function(data){
			data = JSON.parse(`${data}`);
			if(data.status){
				load();				
			}
			else {
				alert("No sea tonto, tire otra carta");
			}
		});
	}
	
	
}

function Draw(imgButton){

	var cookies = document.cookie;
	var color = document.querySelector("canvas#currentColor").getAttribute('data-value');
	var currentValue = document.querySelector("img#graveyard").getAttribute('data-value');
	$.post("Validator.jsp",{"cookies":cookies,"currentColor":color,"currentValue":currentValue,"option":"draw"},function(data){
		data = JSON.parse(`${data}`);
		if(data.status){
			load();
		}
		else {
			alert("No sea tonto, se saco");
		}
	});
}

function changeColor(selectedColor){
	if (selectedColor.value == "0"){
		document.querySelector("canvas#currentColor").style.backgroundColor = "pink";
	}else if (selectedColor.value == "1"){
		document.querySelector("canvas#currentColor").style.backgroundColor = "green";
	}else if (selectedColor.value == "2"){
		document.querySelector("canvas#currentColor").style.backgroundColor = "gray";
	}else if (selectedColor.value == "3"){
		document.querySelector("canvas#currentColor").style.backgroundColor = "orange";
	}
}
