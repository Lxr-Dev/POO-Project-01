package gameHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import unoDeck.Card;
import unoDeck.Converter;

public class ActionCard {
	private FileManager fm = new FileManager();
	private Converter c = new Converter();
	
	
	/**
	 * Permite lanzar una carta numero si su color o valor coincide con la ultima carta en el cementerio
	 * @param player.
	 * @param gameId.
	 * @param index.
	 * @return devulve true si la jugada se realizo, de lo contrario devuelve false
	 * */
	public boolean ThrowNumericCard(String player, String gameId, int index) {
		boolean playedState = false;
		String p = player;
		player = c.playerPath(c.GetPlayerValue(player), gameId);
		List<Card> playerDeck = c.toCardList(fm.Read(player));
		List<Card> graveyard = c.toCardList(fm.Read(String.format("%s/graveyard.json", gameId)));
		
		boolean color = playerDeck.get(index).getColor() == graveyard.get(0).getColor()? true: false;
		boolean value = playerDeck.get(index).getValue() == graveyard.get(0).getValue()? true: false;
		if(color || value){
			graveyard.clear();			   
			graveyard.add(playerDeck.remove(index));
			fm.Write(String.format("%s/graveyard.json", gameId),c.toJSONString(graveyard));
			fm.Write(player,c.toJSONString(playerDeck));
			changePlayer(p, gameId);
			playedState = true;
		}		
		return playedState;
	}	
	
	/**
	 * Cambiar el flujo de juego si su color o valor coincide con la ultima carta en el cementerio
	 * @param player.
	 * @param gameId.
	 * @param index.
	 * @return devulve true si la jugada se realizo, de lo contrario devuelve false
	 * */
	public boolean Reverse(String player, String gameId, int index) {
		boolean playedState = false;
		player = c.playerPath(c.GetPlayerValue(player), gameId);
		List<Card> playerDeck = c.toCardList(fm.Read(player));
		List<Card> graveyard = c.toCardList(fm.Read(String.format("%s/graveyard.json", gameId)));
		
		boolean color = playerDeck.get(index).getColor() == graveyard.get(0).getColor()? true: false;
		boolean value = playerDeck.get(index).getValue() == graveyard.get(0).getValue()? true: false;
		if(color || value){
			graveyard.clear();			   
			graveyard.add(playerDeck.remove(index));	
			fm.Write(String.format("%s/graveyard.json", gameId),c.toJSONString(graveyard));
			fm.Write(player,c.toJSONString(playerDeck));
			playedState = true;
		}	
		return playedState;	
	}	
	
	/**
	 * Bloquea el turno del siguiente jugador si su color o valor coincide con la ultima carta en el cementerio
	 * @param player.
	 * @param gameId.
	 * @param index.
	 * @return devulve true si la jugada se realizo, de lo contrario devuelve false
	 * */
	public boolean Block(String player, String gameId, int index) {
		boolean playedState = false;
		player = c.playerPath(c.GetPlayerValue(player), gameId);
		List<Card> playerDeck = c.toCardList(fm.Read(player));
		List<Card> graveyard = c.toCardList(fm.Read(String.format("%s/graveyard.json", gameId)));
		
		boolean color = playerDeck.get(index).getColor() == graveyard.get(0).getColor()? true: false;
		boolean value = playerDeck.get(index).getValue() == graveyard.get(0).getValue()? true: false;
		if(color || value){
			graveyard.clear();			   
			graveyard.add(playerDeck.remove(index));	
			fm.Write(String.format("%s/graveyard.json", gameId),c.toJSONString(graveyard));
			fm.Write(player,c.toJSONString(playerDeck));
			playedState = true;
		}		
		return playedState;
	}

	/**
	 * Funcion de la Carta +2, agrega 2 cartas del mazo a la baraja del enemigo
	 * @param player.
	 * @param gameId.
	 * @param path.
	 * */
	public void plusTwo(String currentPlayer, String gameId, int index){	
		
		String player = c.playerPath(c.GetPlayerValue(currentPlayer), gameId);
		String enemy = c.playerPath(c.GetPlayerValue(currentPlayer)==1? 2:1, gameId);
		
		List<Card> mainDeck ,playerDeck, enemyDeck, graveyard = new ArrayList<>();
		graveyard = c.toCardList(fm.Read(String.format("%s/graveyard.json", gameId)));		
		playerDeck = c.toCardList(fm.Read(player));
		
		boolean color = playerDeck.get(index).getColor() == graveyard.get(0).getColor()? true: false;
		boolean value = playerDeck.get(index).getValue() == graveyard.get(0).getValue()? true: false;
		if(color || value){
			mainDeck = c.toCardList(fm.Read(String.format("%s/Deck.json",gameId)));
			enemyDeck = c.toCardList(fm.Read(enemy));
			graveyard.clear();
			graveyard.add(playerDeck.remove(index));
			
			for(int i = 0; i<2;i++) {			
				enemyDeck.add(mainDeck.remove(Random(mainDeck.size())));
			}			

			fm.Write(String.format("%s/Deck.json", gameId),c.toJSONString(mainDeck));
			fm.Write(String.format("%s/graveyard.json", gameId),c.toJSONString(graveyard));
			fm.Write(player,c.toJSONString(playerDeck));  
			fm.Write(enemy,c.toJSONString(enemyDeck));
			changePlayer(currentPlayer, gameId);
		}	
	}

	/**
	 * Funcion de la Carta +4, agrega 4 cartas del mazo a la baraja del enemigo
	 * @param player.
	 * @param gameId.
	 * @param path.
	 * */
	public void plusFour(String currentPlayer, String gameId, int index){

		String player = c.playerPath(c.GetPlayerValue(currentPlayer), gameId);
		String enemy = c.playerPath(c.GetPlayerValue(currentPlayer)==1? 2:1, gameId);
		
		List<Card> mainDeck ,playerDeck, enemyDeck, graveyard = new ArrayList<>();

		mainDeck = c.toCardList(fm.Read(String.format("%s/Deck.json",gameId)));
		playerDeck = c.toCardList(fm.Read(player));
		enemyDeck = c.toCardList(fm.Read(enemy));
		graveyard = c.toCardList(fm.Read(String.format("%s/graveyard.json", gameId)));		
		
		for(int i = 0; i<4;i++) {			
			enemyDeck.add(mainDeck.remove(Random(mainDeck.size())));
		}			
		
		Card card = playerDeck.remove(index);
		card.ChangeColor(graveyard.get(0).getColor());

		graveyard.clear();
		graveyard.add(card);

		fm.Write(String.format("%s/Deck.json", gameId),c.toJSONString(mainDeck));
		fm.Write(String.format("%s/graveyard.json", gameId),c.toJSONString(graveyard));
		fm.Write(player,c.toJSONString(playerDeck));  
		fm.Write(enemy,c.toJSONString(enemyDeck));
		changePlayer(currentPlayer, gameId);
	}
	
	/**
	 * el jugador elige el color de la siguiente carta a tirar despues de esta
	 * @param player.
	 * @param gameId.
	 * @param index.
	 * @param newColor.
	 * */
	public void changeColor(String player, String gameId, int index){
		
		player = c.playerPath(c.GetPlayerValue(player), gameId);
		
		List<Card> playerDeck = c.toCardList(fm.Read(player));
		List<Card> graveyard = c.toCardList(fm.Read(String.format("%s/graveyard.json", gameId)));
		Card card = playerDeck.remove(index);
		graveyard.clear();			   
		graveyard.add(card);
		fm.Write(String.format("%s/graveyard.json", gameId),c.toJSONString(graveyard));
		fm.Write(player,c.toJSONString(playerDeck));
	}
	
	public void newColor(String player, String newColor, String gameId) {
		String p = player;
		List<Card> graveyard = c.toCardList(fm.Read(String.format("%s/graveyard.json",gameId)));
		graveyard.get(0).ChangeColor(c.GetIntValue(newColor));
		
		fm.Write(String.format("%s/graveyard.json",gameId),c.toJSONString(graveyard));
		changePlayer(p,gameId);
	}

	/**
	 * Funcion para verificar si el jugador ya gano
	 * @param player.
	 * @param gameId.
	 * @return retorna true si el jugador no tiene mas cartas en mi mano
	 * */
	public boolean WinnerPlayer(String player, String gameId){
		player = c.playerPath(c.GetPlayerValue(player), gameId);
		List<Card> playerDeck = c.toCardList(fm.Read(player));
		return playerDeck == null || playerDeck.size() == 0? true: false;
	}

	/**
	 * Funcion numero aleatorio
	 * @param n.
	 * @return retorna un numero aleatorio en un rango de 0 a n
	 * */
	private int Random(int n) {
		Random rand = new Random();
		if (n!=0) {
			return rand.nextInt(n);
		}
		return 0;		    
	}

	/**
	 * Cede el turno al siguiente jugador
	 * @param player.
	 * @param gameId.
	 * */
	private void changePlayer(String player, String gameId) {			
		String playerTurn = c.GetPlayerValue(player) == 1? "2":"1";
		fm.Write(String.format("%s/turn.txt",gameId), playerTurn);
	}

	/**
	 * Verificar Turno del Jugador
	 * @param player.
	 * @param gameId.
	 * @return devuelve verdadero si es el turno del jugador
	 * */
	public boolean verifyTurn(String player, String gameId) {
		int currentPlayer = c.GetPlayerValue(fm.Read(String.format("%s/turn.txt",gameId)));
		return currentPlayer == c.GetPlayerValue(player)? true: false;		
	}

	
	/**
	 * Funcion Jalar: permite tomar una carta del mazo y agregarla a la baraja del jugador siempre y caundo la necesite
	 * @param player.
	 * @param gameId.
	 * @param currentColor.
	 * @param currentValue.
	 * @return devuelve verdadero el estado de la accion en formato JSON si 
	 * */
	public String draw(String player, String gameId, String currentColor, String currentValue) {
		List<Card> mainDeck, playerDeck = new ArrayList<>();
		boolean status = false;	
		boolean canDraw = true;

		player = c.playerPath(c.GetPlayerValue(player), gameId);
		mainDeck = c.toCardList(fm.Read(String.format("%s/Deck.json", gameId)));	
		playerDeck = c.toCardList(fm.Read(player));
		
		for (Card card : playerDeck) {
			if( card.getValue() == c.GetIntValue(currentValue) || card.getColor() == c.GetIntValue(currentColor)){
				canDraw = false;
				break;
			}
		}

    	if (canDraw) {    					
			playerDeck.add(mainDeck.remove(Random(mainDeck.size())));
			fm.Write(player,c.toJSONString(playerDeck));
			fm.Write(String.format("%s/Deck.json", gameId),c.toJSONString(mainDeck));
			status = true;
		}

		return status?"{\"status\":true,\"message\":\"Se robó una carta\"}":"{\"status\":false,\"message\":\"Tiene Cartas para lanzar en su Mazo\"}"; //Operador Ternario
	}
	
	/**
	 * Función para calcular el puntaje del jugador
	 * @param player.
	 * @param gameId.
	 * @return devuelve el puntaje del jugador 
	 * */
	public String calculateScore(String player, String code) {
		List<Card> loser = c.toCardList(fm.Read(String.format("%s/player%s.json",code, player)));
		
		int score = 0;
		
		for (Card card : loser) {
			if (card.getValue() <10) {
				score+=10;
			}else if (card.getValue() >= 10 && card.getValue() <13) {
				score+=20;
			}else if(card.getValue() == 13 || card.getValue()==14) {
				score+=50;
			}
		}
		
		return Integer.toString(score);
	}

}
