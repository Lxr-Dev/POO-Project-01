//genera una ventana modal para cada boton pero hay que hacer que muestre distinto contenido dependiendo del boton que se presione

let modal = document.getElementById('miModal');
let flex = document.getElementById('flex');
let abrir1 = document.getElementById('abrir1');
let abrir2 = document.getElementById('abrir2');
let abrir3 = document.getElementById('abrir3');
let abrir4 = document.getElementById('abrir4');
let cerrar = document.getElementById('close');
//funcion para generar codigo
var message1='<h4>CODIGO ACCESO</h4><p></p><br><form action="OneScreen.jsp"><button class="btn-submit">Entrar</button></form>';
var message2='<h4>INGRESE CODIGO ACCESO</h4><form action="OneScreen.jsp"><input id="contenedor-input" type="text" placeholder="ingrese codigo de acceso"><br><button class="btn-submit">Entrar</button></form>';
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
