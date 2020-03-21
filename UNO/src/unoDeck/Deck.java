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
				this.deck.add(new Card(i,0,"Carta Verde","numeric"));
				this.deck.add(new Card(i,1,"Carta Roja","numeric"));
				this.deck.add(new Card(i,2,"Carta Azul","numeric"));
				this.deck.add(new Card(i,3,"Carta Amarilla","numeric"));
			}
			
			//Generando las cartas de +2, Cambio de Dirección, Pierde Turno de 4 colores distintos
			for (int i=10;i<13;i++) {
				this.deck.add(new Card(i,0,"Carta Verde","special"));
				this.deck.add(new Card(i,1,"Carta Roja","special"));
				this.deck.add(new Card(i,2,"Carta Azul","special"));
				this.deck.add(new Card(i,3,"Carta Amarilla","special"));
			}
			
			//Generando las cartas especiales +4 y cambio de color
			for (int i=0;i<2;i++) {
				this.deck.add(new Card(13,4,"Carta Especial +4","special"));
				this.deck.add(new Card(14,4,"Carta Especial Cambio de Color","special"));
			}
			
			count ++;
		}
		
	}
	
	/**
	 * Reparte las cartas
	 * @return Devuelve una Lista de Listas enlazadas de Cartas
	 * */
	public Card deal() {
		
		return this.deck.remove(Random(this.deck.size()));
		
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
