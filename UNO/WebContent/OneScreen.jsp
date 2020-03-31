<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>UNO</title>
		<meta name="author" content="Alexis">
		<meta name="author" content="Andrés">
		<meta name="author" content="Alexandra">
		<meta name="author" content="Marco">
		<meta name="description" content="Tablero del Juego">
		<link rel="shortcut icon" href="Resources/favicon.png"/>
		<link rel='stylesheet' type='text/css' href='CSS/OneScreen.css'>
	</head>
	<body>
		<div id="contenedor">
			
			<div id = "enemy">
				<div class="scroll" id="enemyCards"></div>
			</div>
			
			<div id = "table">
				<img class="mazo" onclick="Draw(this);" id="gameDeck" src="Resources/BackCard.png" height="115vw">
				<img id="graveyard" data-value="" height="115vw">
				<canvas id ="currentColor"></canvas>
				<div id = "colorSelect">
					<button class="btn_color" value="0" onclick="changeColor(this);" style='background-color:green;'>Green</button>
					<button class="btn_color" value="1" onclick="changeColor(this);" style='background-color:orange;'>Orange</button>
					<button class="btn_color" value="2" onclick="changeColor(this);" style='background-color:pink;'>Pink</button>
					<button class="btn_color" value="3" onclick="changeColor(this);" style='background-color:gray;'>Gray</button>
				</div>
			</div>
			
			<div id = "player">
    			<div class="scroll" id="scrollmenu"></div>
    		</div>	    		
		</div>
		<script src="Javascript/jquery.js"></script>
		<script src="Javascript/loadCards.js"></script>
	</body>
</html>