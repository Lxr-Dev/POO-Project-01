/**
 * 
 */

window.onload = calculateScore;

function add(){
	$.post("Services/winnerCalls.jsp",{"option":"add","gamerTag":gamerTag.value, "score":score.innerHTML},function(data){
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