//genera una ventana modal para cada boton pero hay que hacer que muestre distinto contenido dependiendo del boton que se presione

let modal = document.getElementById('miModal');
let flex = document.getElementById('flex');
let abrir1 = document.getElementById('abrir1');
let abrir2 = document.getElementById('abrir2');
let abrir3 = document.getElementById('abrir3');
let abrir4 = document.getElementById('abrir4');
let cerrar = document.getElementById('close');
//funcion para generar codigo
var message1='<h4 id="codeS">CÓDIGO ACCESO</h4><p></p><br><form onsubmit="return generateCode();"><button type="submit" class="btn-submit">Generar Código</button>&nbsp;&nbsp;&nbsp;<button onclick="Start();" class="btn-submit">Iniciar Partida</button></form>';
var message2='<div id="exception"></div><h4>INGRESE CÓDIGO ACCESO</h4><form onsubmit="return join();"><input id="code" type="text" placeholder="Ingrese código de acceso"><br><button type="submit" class="btn-submit">Unirse</button></form>';
var message3='<table><tr><td>Name</td><td>Score</td></tr><tr><td>player1</td><td>50</td></tr></table>';
var message4='<p><h4>INTEGRANTES:</h4><h4>name1<br>name2<br>name3<br>name4</h4><br>POO &copy| 1PAC 2020</p>';

abrir1.addEventListener('click',function(){
	document.getElementById("message").innerHTML = message1;
    modal.style.display = 'block';
});
abrir2.addEventListener('click',function(){
	document.getElementById("message").innerHTML = message2;
    modal.style.display = 'block';
});
abrir3.addEventListener('click',function(){
	document.getElementById("message").innerHTML = message3;
    modal.style.display = 'block';
});
abrir4.addEventListener('click',function(){
	document.getElementById("message").innerHTML = message4;
    modal.style.display = 'block';
});

cerrar.addEventListener('click',function(){
    modal.style.display = 'none';
});

window.addEventListener('click',function(e){
    if(e.target == flex){
        modal.style.display = 'none';
    }
});
