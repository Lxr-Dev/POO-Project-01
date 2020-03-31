/**
 * 
 */

window.onload = calculateScore;

function add(){
	var meses = new Array ("Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre");
	var f = new Date();
	date = `${f.getDate()}/${meses[f.getMonth()]}/${f.getFullYear()}`;
	time = `${f.getHours()}:${f.getMinutes()}:${f.getSeconds()}`;
	$.post("Services/winnerCalls.jsp",{"option":"add","gamerTag":gamerTag.value, "score":score.innerHTML, "date":date, "time":time},function(data){
		data = JSON.parse(`${data}`.trim());
		if (data.status){
			location = "index.jsp";
		}
	});
	return false;
}

function calculateScore(){
	var cookies = document.cookie;
	$.post("Services/winnerCalls.jsp",{"option":"getScore","cookies":cookies},function(data){
		data = JSON.parse(`${data}`.trim());
		if (data.status){
			document.querySelector("h4#score").innerHTML = data.score
		}
	});
}