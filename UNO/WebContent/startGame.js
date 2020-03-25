/**
 * 
 */

function Start(){
	var codeS = document.querySelector("h4#codeS").innerHTML;
	document.cookie = `code=${codeS};max-age:7200`;
	document.cookie = `player=1`;
	location = `OneScreen.jsp`;
}