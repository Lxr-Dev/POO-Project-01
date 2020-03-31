/**
 * 
 */

window.onload = socketSimulator;

//Función para simular un "socket" entre ambos dispositivos
function socketSimulator(){
	load();
	running = setTimeout(listener,1000);
}

//listener lee constantemente un archivo para verificar el turno del jugador
function listener(){

	$.post("Services/changeTurn.jsp",{"cookies":document.cookie},function(data){
		data = JSON.parse(`${data}`);
		if(data.yourTurn){
			document.getElementById("player").style.opacity = "1"; 
		}else{
			document.getElementById("player").style.opacity = "0.5"; 
		}
		load();
		socketSimulator();
	});
}

//Detiene el "socket"
function stopSocket(){
	clearTimeout(running);
}

//Función que carga dinámicamente las imágenes de las cartas
function load() {
	var cookies = document.cookie;
	$.post("Services/getCard.jsp",{"cookies":cookies},function(data){
		
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
		}
		document.getElementById("colorSelect").style.visibility = "hidden";
	});
	
	return false;	
}

//Función para lanzar las cartas del jugador
function Throw(imgButton){

	var cookies = document.cookie;
	var color = document.querySelector("canvas#currentColor").getAttribute('data-value');
	var currentValue = document.querySelector("img#graveyard").getAttribute('data-value');
	
	if(imgButton.src == "http://localhost:8080/UNO/Resources/wild.png"){
		document.getElementById("colorSelect").style.visibility = "visible";
		$.post("Services/Validator.jsp",{"cookies":cookies,"index":imgButton.getAttribute('data-value'),"currentColor":color,"currentValue":currentValue,"option":"throw"},function(data){
			data = JSON.parse(`${data}`);
			
			if (data.winner){
				location = "Winner.jsp"
			}
			
			if(data.status){
				stopSocket();
			}else{
				document.getElementById("colorSelect").style.visibility = "hidden";
				alert(data.message);
			}
			
		});
	}
	else{		
		$.post("Services/Validator.jsp",{"cookies":cookies,"index":imgButton.getAttribute('data-value'),"currentColor":color,"currentValue":currentValue,"option":"throw"},function(data){
			data = JSON.parse(`${data}`);
			
			if (data.winner){
				location = "Winner.jsp"
			}
			
			if(data.status){
				load();				
			}
			else {
				alert(data.message);
			}
		});
	}
}

//Función para robar cartas
function Draw(imgButton){

	var cookies = document.cookie;
	var color = document.querySelector("canvas#currentColor").getAttribute('data-value');
	var currentValue = document.querySelector("img#graveyard").getAttribute('data-value');
	$.post("Services/Validator.jsp",{"cookies":cookies,"currentColor":color,"currentValue":currentValue,"option":"draw"},function(data){
		data = JSON.parse(`${data}`);
		if(data.status){
			load();
		}
		else {
			alert(data.message);
		}
	});
}

//Función especial para el cambio de color
function changeColor(selectedColor){
	if (selectedColor.value == "0"){
		document.querySelector("canvas#currentColor").style.backgroundColor = "green";
	}else if (selectedColor.value == "1"){
		document.querySelector("canvas#currentColor").style.backgroundColor = "orange";
	}else if (selectedColor.value == "2"){
		document.querySelector("canvas#currentColor").style.backgroundColor = "pink";
	}else if (selectedColor.value == "3"){
		document.querySelector("canvas#currentColor").style.backgroundColor = "gray";
	}
	
	var cookies = document.cookie;
	var color = selectedColor.value
	
	$.post("Services/Validator.jsp",{"cookies":cookies,"currentColor":color,"option":"changeColor"},function(data){
		data = JSON.parse(`${data}`);
		if(data.status){	
			document.getElementById("colorSelect").style.visibility = "hidden";
			socketSimulator();
		}
		else {
			alert(data.message);
		}
	});
}
