//genera una ventana modal para cada boton pero hay que hacer que muestre distinto contenido dependiendo del boton que se presione

let modal = document.getElementById('miModal');
let flex = document.getElementById('flex');
let abrir1 = document.getElementById('abrir1');
let abrir2 = document.getElementById('abrir2');
let abrir3 = document.getElementById('abrir3');
let abrir4 = document.getElementById('abrir4');
let cerrar = document.getElementById('close');
//funcion para generar codigo
var message1='<h4 id="codeS">CÓDIGO ACCESO</h4><p></p><br><form><button type="button" onclick="generateCode();" class="btn-submit">Generar Código</button>&nbsp;&nbsp;&nbsp;<button type="button" onclick="Start();" class="btn-submit">Iniciar Partida</button></form>';
var message2='<div id="exception"></div><h4>INGRESE CÓDIGO ACCESO</h4><form onsubmit="return join();"><input id="code" type="text" placeholder="Ingrese código de acceso"><br><button type="submit" class="btn-submit">Unirse</button></form>';
var message3='<div id="scoreTable" class="container-table"><div class="table-title">Tabla de Ganadores</div><br><br><br><br><br><div id="tablita"></div>';
var message4='<div id="credits" class="container-table"><div class="table-title">Integrantes</div>'
+'<div class="table-header">Nombre </div><div class="table-header">#Cta.</div>'
+'<div class="table-item">name1</div><div class="table-item">20201515963</div><div class="table-item">name2</div>'
+'<div class="table-item">20201515963</div><div class="table-item">name3</div><div class="table-item">20201515963</div>'
+'<div class="table-item">name4</div><div class="table-item">20201515963</div><div class="table-footer">POO &copy;</div></div>';

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
	
	$.post("Services/table.jsp",{},function(data){
		data = JSON.parse(`${data}`.trim());	
		if (data.status){
			document.querySelector("div#tablita").innerHTML = data.tablita;
		}
	});
	
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
