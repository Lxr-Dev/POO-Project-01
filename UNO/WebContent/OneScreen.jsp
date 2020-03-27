<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>UNO</title>
		<style >
			body{
				height:100vh;
				margin:0;
				padding:0;
			    background-image: linear-gradient(to top right,#16a085,#34495e);
			    background-repeat:no-repeat;
			    background-size:cover;
			    overflow: hidden;
			}
			
			div#contenedor{
				position:relative;
				height:90vh;
				width:90vw;
				top:5vh;
				left:5vw;
				background-color:#f6eeda;
				border-radius:8px;
			}
			div.scroll {
			  
			  overflow: auto;
			  white-space: nowrap;
			}
			
			div.scroll a {
			  display: inline-block;
			  color: white;
			  text-align: center;
			  padding: 14px;
			  text-decoration: none;
			  margin: 20;
			}
			
			div.scroll a:hover {
			  background-color: #777;
			}
			
			div#player{
				position:relative;
				width:44.55vw;
				top:22vh;
				left:22.725vw;
				border-radius:8px;
			}
			
			div#enemy{
				position:relative;
				width:50.55vw;
				top:2vh;
				left:22.725vw;
				border-radius:8px;
			}
			
			div.cards{
				display:block;
				float:left;
			}
			div#table{
				position:relative;
				height:28vh;
				width:30vw;
				top:16.5vh;
				left:36vw;
			}			
			
			canvas#currentColor{
				position:absolute;
				floar:left;
				height:40px;
				width:40px;
				margin-top:40px;
				border:1px solid black;
			}
			
			img#graveyard{
				margin-left:20px;
				margin-right:20px;
			}
			
		</style>
	</head>
	<body>
		<div id="contenedor">
			
			<div id = "enemy">
				<div class="scroll" id="enemyCards"></div>
			</div>
			
			<div id = "table">
				<button class="mazo" id="gameDeck"><img src="Resources/BackCard.png" height="115vw"></button>
				<img id="graveyard" data-value="" height="115vw">
				<canvas id ="currentColor"></canvas>
			</div>
			
			<div id = "player">
    			<div class="scroll" id="scrollmenu"></div>
    		</div>	
    		
		</div>
		<script src="jquery.js"></script>
		<script src="loadCards.js"></script>
	</body>
</html>