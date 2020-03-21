package unoDeck;

import java.util.ArrayList;
import java.util.List;

public class Player {
	
	private String name;
	private List<Card> deck;
	private int score = 0;
	
	public Player(String name ,List<Card> deck,int score) {
		this.setName(name);
		this.setDeck(deck);
		this.setScore(score);
	}
	
	public Player(String name ,List<Card> deck) {
		this.setName(name);
		this.setDeck(deck);
	}
	
	public Player(String name) {
		this.setName(name);
		this.deck = new ArrayList<Card>();
	}

	public List<Card> getDeck() {
		return deck;
	}

	public int DeckCount(){
		return deck.size();
	}

	public void setDeck(List<Card> deck) {
		this.deck = deck;
	}
	
	public void setCard(Card card) {
		//System.out.println(String.format("objeto = %s", card));
		this.deck.add(card);
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
		
	
}
