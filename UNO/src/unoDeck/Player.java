package unoDeck;

import java.util.ArrayList;
import java.util.List;

public class Player {
	
	private String name;
	private List<Card> deck;
	private Float score;
	
	public Player(String name ,List<Card> deck,Float score) {
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

	public Float getScore() {
		return score;
	}

	public void setScore(Float score) {
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
		
	
}
