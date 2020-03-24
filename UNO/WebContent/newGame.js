/**
 * 
 */

function generateCode(){
	$.post("generate.jsp",{},function (data){
		data = data.toString().trim();
		document.querySelector("input#codeS").disabled = false;
		document.querySelector("input#codeS").value = data;
		document.querySelector("input#codeS").disabled = true;
	});
	return false;
}