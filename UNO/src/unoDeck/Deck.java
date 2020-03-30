package unoDeck;

import java.util.ArrayList;
import java.util.List;
import java.util.Random; 

public class Deck {
	
private List<Card> deck;
	
	public Deck() {
		this.deck = new ArrayList<Card>();
		//generateDeck();
	}
	
	public List<Card> getCard() {
		return this.deck;
	}
	
	public void setCard(Card card) {
		this.deck.add(card);
	}
	/**
	 * Pobla a la lista enlazada deck con todas las instancias de nuevas cartas
	 * */
	public void generateDeck() {
		int count = 0;
		
		while (count < 2) {
		
			//Generando las cartas del 0 al 9 de 4 colores distintos
			for (int i=0; i<10; i++) {
				//numero, color, imágen, tipo
				this.deck.add(new Card(i,0,String.format("Resources/green%s.png",i),"numeric"));
				this.deck.add(new Card(i,1,String.format("Resources/orange%s.png",i),"numeric"));
				this.deck.add(new Card(i,2,String.format("Resources/rose%s.png",i),"numeric"));
				this.deck.add(new Card(i,3,String.format("Resources/white%s.png",i),"numeric"));
			}
			
			//Generando las cartas de +2, Cambio de Dirección, Bloqueo
			for (int i=10;i<13;i++) {
				this.deck.add(new Card(i,0,String.format("Resources/green%s.png",i),"special"));
				this.deck.add(new Card(i,1,String.format("Resources/orange%s.png",i),"special"));
				this.deck.add(new Card(i,2,String.format("Resources/rose%s.png",i),"special"));
				this.deck.add(new Card(i,3,String.format("Resources/white%s.png",i),"special"));
			}
			
			//Generando las cartas especiales +4 y cambio de color
			for (int i=0;i<2;i++) {
				this.deck.add(new Card(13,4,"Resources/+4.png","special"));
				this.deck.add(new Card(14,4,"Resources/wild.png","special"));
			}
			
			count ++;
		}
		
	}
	
	/**
	 * Reparte las cartas
	 * @return Devuelve una Lista de Listas enlazadas de Cartas
	 * */
	public List<List<Card>> deal() {
		
		List<List<Card>> list = new ArrayList<List<Card>>();
		List<Card> player1 = new ArrayList<Card>();
		List<Card> player2 = new ArrayList<Card>();
		List<Card> graveyard = new ArrayList<Card>();

		for(int i=0; i<7;i++) {
			player1.add(this.deck.remove(Random(this.deck.size())));
			player2.add(this.deck.remove(Random(this.deck.size())));
		}
		
		
		while(true) {
			int i = Random(this.deck.size());
			if(this.deck.get(i).getValue()<10) {				
				graveyard.add(this.deck.remove(i));
				break;
			}
			
		}

		list.add(player1);
		list.add(player2);
		list.add(graveyard);
		list.add(this.deck);

		return list;
		
	}
	
	/**
	 * Genera un número Aleatorio dentro de un rango
	 * @param int n recibe un valor entero que será el valor máximo del rango
	 * @return int devuelve un valor entero aleatorio entre 0 y n
	 * */
	private int Random(int n) {
		Random rand = new Random();
		if (n!=0) {
			return rand.nextInt(n);
		}
		return 0;
		    
	}
	
	public void add(Card card) {
		this.deck.add(card);
	}
		
}
