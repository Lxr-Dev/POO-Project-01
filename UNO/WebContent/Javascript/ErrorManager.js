/**
 * 
 */

function ErrorManager(){
	this.errorTag = null;
	this.insertTag = function(tag){
			
		var errorTag = "<div id = 'error'></div>";
		tag.innerHTML = `${errorTag}${tag.innerHTML}`;
		
		this.errorTag = document.querySelector("div#error");
		
		return this.errorTag;
	};
	
	this.show = function(tag,message="Error."){
		tag.style.border = "1px solid red";
		tag.style.color = "red";
		tag.innerHTML = message;
	};
	
	this.hide = function(tag){
		tag.style.border = "0px solid transparent";
		tag.style.color = "transparent";
		tag.innerHTML = "";
	};
}