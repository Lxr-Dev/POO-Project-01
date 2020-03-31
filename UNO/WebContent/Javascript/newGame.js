/**
 * 
 */

//Función para hacer una petición de un código aleatorio
function generateCode(){
	$.post("Services/generate.jsp",{},function (data){
		data = data.toString().trim();
		document.querySelector("h4#codeS").innerHTML = data;
	});
	return false;
}