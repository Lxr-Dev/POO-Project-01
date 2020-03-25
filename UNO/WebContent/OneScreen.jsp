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
			  background-color: #333;
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
				height:10vh;
				width:49.3vw;
				top:65vh;
				left:20.35vw;
				background-color:green;
				border-radius:8px;
			}
			
			div.cards{
				display:block;
				float:left;
			}
		</style>
	</head>
	<body>
		<div id="contenedor">
			<div id = "player">
    			<div class="scroll" id="scrollmenu"></div>
    		</div>	
		</div>
		<script src="jquery.js"></script>
		<script src="loadCards.js"></script>
	</body>
</html>