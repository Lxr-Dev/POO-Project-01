/**
 * 
 */

function start(){
	$.post("generate.jsp",{"gamerTag":gamerTag.value},function (data){
		data = data.toString().trim();
		console.log(data);
		document.querySelector("body").innerHTML += data;
	});
	return false;
}