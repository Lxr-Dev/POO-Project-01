/**
 * 
 */

function generateCode(){
	$.post("generate.jsp",{},function (data){
		data = data.toString().trim();
		document.querySelector("h4#codeS").innerHTML = data;
	});
	return false;
}