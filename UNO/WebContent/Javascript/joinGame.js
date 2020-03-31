/**
 * 
 */
function join(){
	$.post("Services/seek.jsp",{"code":code.value},function (data){
		
		console.log(data);
		
		data = JSON.parse(`${data}`.trim());
		
		if (data.status){
			
			//Redirigir al usuario a la siguiente pantalla
			document.cookie = `code=${code.value};max-age:7200`;
			document.cookie = `player=2`;
			location = `OneScreen.jsp`;
			
		}else{
			//var abrir2 = document.getElementById('abrir2');
			
			var em = new ErrorManager();
			var body = document.getElementById("message");
			var errorTag = em.insertTag(body);
			em.show(errorTag,data.message);
			
			setTimeout(function(){
				em.hide(errorTag);
			},3000);
		}
	});
	
	return false;
}