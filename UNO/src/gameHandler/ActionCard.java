package gameHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import unoDeck.Card;
import unoDeck.Converter;

public class ActionCard {
	private FileManager fm = new FileManager();
	private Converter c = new Converter();
	
	public void plusTwo(String currentPlayer, String path, int index){	
		
		String player = "";
		String enemy = "";
		
		if (currentPlayer.equals("1")) {
			player = String.format("%s/player1.json", path);
			enemy = String.format("%s/player2.json", path);
		}
		else {
			player = String.format("%s/player2.json", path);
			enemy = String.format("%s/player1.json", path);
		}
		
		List<Card> mainDeck = new ArrayList<>();
		List<Card> playerDeck = new ArrayList<>();
		List<Card> enemyDeck = new ArrayList<>();
		List<Card> graveyard = new ArrayList<>();

		mainDeck = c.toCardList(fm.Read(String.format("%s/Deck.json",path)));
		playerDeck = c.toCardList(fm.Read(player));
		enemyDeck = c.toCardList(fm.Read(enemy));
		graveyard.add(playerDeck.remove(index));
		
		for(int i = 0; i<2;i++) {			
			int j = Random(mainDeck.size());
			enemyDeck.add(mainDeck.remove(j));
		}	
		

		fm.Write(String.format("%s/Deck.json", path),c.toJSONString(mainDeck));
		fm.Write(String.format("%s/graveyard.json", path),c.toJSONString(graveyard));
		fm.Write(player,c.toJSONString(playerDeck));  
		fm.Write(enemy,c.toJSONString(enemyDeck));  
	}
	
	private int Random(int n) {
		Random rand = new Random();
		if (n!=0) {
			return rand.nextInt(n);
		}
		return 0;		    
	}
	
	
	public void ThrowNumericCard(String currentPlayer, String path, int index) {
		
		String player = "";
		player = String.format("%s/player%s.json", path, currentPlayer);

		List<Card> playerDeck = new ArrayList<>();
		playerDeck = c.toCardList(fm.Read(player));
		
		
		
		List<Card> graveyard = new ArrayList<>();
		graveyard.add(playerDeck.get(index));
		playerDeck.remove(index);

		fm.Write(String.format("%s/graveyard.json", path),c.toJSONString(graveyard));
		fm.Write(player,c.toJSONString(playerDeck));
	}
	
	
	public void plusFour(String currentPlayer, String path, int index){
		plusTwo(currentPlayer, path, index);
		plusTwo(currentPlayer, path, index);
	}
	
	public void changePlayer(String player, String path) {
		if (player.equals("1")) {
			fm.Write(String.format("%s/turn.txt",path),"2");
		}else {
			fm.Write(String.format("%s/turn.txt",path), "1");
		}
	}
	
	public boolean verifyTurn(String player, String code) {
		if(player.equals(fm.Read(String.format("%s/turn.txt",code)).toString().replaceAll("\n", ""))){			
			return true;
		}
		else{
			return false;
		}
	}
	
	public String draw(String player,String path, String currentColor, String currentValue) {
		List<Card> mainDeck = new ArrayList<>();
		List<Card> playerDeck = new ArrayList<>();
		boolean status = false;
		
		mainDeck = c.toCardList(fm.Read(String.format("%s/Deck.json",path)));	
		

		if (player.equals("1")){			    			
    		playerDeck = c.toCardList(fm.Read(String.format("%s/player1.json",path)));
    		
    		boolean canDraw = true;
    		
    		for (Card card : playerDeck) {
    			if(
    				card.getValue()==Integer.parseInt(currentValue) ||
    				card.getColor()==Integer.parseInt(currentColor)
    			){
    				canDraw = false;
    				break;
    			}
    		}
    		
    		if (canDraw) {
    			
    			int i = Random(mainDeck.size());
    			Card drawCard = mainDeck.get(i);
    			mainDeck.remove(i);
    			
    			playerDeck.add(drawCard);
    			fm.Write(String.format("%s/player1.json", path),c.toJSONString(playerDeck));
    			fm.Write(String.format("%s/Deck.json", path),c.toJSONString(mainDeck));
    			status = true;
    		}
    			
		}
		else{
			
			playerDeck = c.toCardList(fm.Read(String.format("%s/player2.json",path)));
    		
    		boolean canDraw = true;
    		
    		for (Card card : playerDeck) {
    			if(
    				card.getValue()==Integer.parseInt(currentValue) ||
    				card.getColor()==Integer.parseInt(currentColor)
    			){
    				canDraw = false;
    				break;
    			}
    		}
    		
    		if (canDraw) {
    			
    			int i = Random(mainDeck.size());
    			Card drawCard = mainDeck.get(i);
    			mainDeck.remove(i);
    			
    			playerDeck.add(drawCard);
    			fm.Write(String.format("%s/player2.json", path),c.toJSONString(playerDeck));
    			fm.Write(String.format("%s/Deck.json", path),c.toJSONString(mainDeck));
    			status = true;
    		}
		}

		//Operador Ternario
		return status?"{\"status\":true}":"{\"status\":false}";
	}

}
