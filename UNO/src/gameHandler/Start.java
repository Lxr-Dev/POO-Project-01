package gameHandler;

import unoDeck.Deck;
import unoDeck.Player;
import unoDeck.Card;



public class Start {
	private Deck principalDeck;
	private Deck graveyardDeck;
	private Player player1;
	private Player player2;
	
	public Start(Player player1, Player player2) {
		this.principalDeck = new Deck();
		this.graveyardDeck = new Deck();
		this.player1 = player1;
		this.player2 = player2;
		
		createCards(0,0);
		deal(7, player1);
		deal(7,player2);
		this.graveyardDeck.add(this.principalDeck.deal());
		
	}
	
	public Deck getPrincipal() {
		return this.principalDeck;
	}
	
	public Deck getGraveyard(){
		return this.graveyardDeck;
	}
	
	public Player getPlayer1() {
		return this.player1;
	}
	
	public Player getPlayer2() {
		return this.player2;
	}
	
	
	public void createCards(Integer codeCard, Integer colorCard) {
		/*
		 * Esta es una funcion recursiva que crea todas las cartas del Deck Principal
		 */
		
		/*
		 * Divide la creacion en 3 casos:
		 * 		Numericas 0-9
		 * 		Especiales con color 10-12 
		 * 		Especiales sin color 13-14
		 */
		if(codeCard >= 10) {
			//Dentro de este if se crean todas las cartas Especiales
			if(codeCard >= 13) {
				//Dentro de este if se crean las "cartas Especiales sin color"
				if(codeCard > 14) {
					//Caso base de funcion recursiva: solo hay 14 cartas diferentes en el juego
				}else {
					if(colorCard > 3) {
						/*
						 * Son 4 unidades por cada "carta Especial sin color":
						 * 		se empieza contando de 0-3
						 * 		cuando el color card sea mayor a 3 entonces:
						 * 				se cambia el codigo de la "carta Especial sin color"
						 */
						createCards(codeCard + 1, 0);
					}else {
						String img = String.format("%s4.jpg", codeCard);
						Card card1 = new Card(codeCard, 4, img, "special");
						this.principalDeck.setCard(card1);
						createCards(codeCard, colorCard + 1);
					}
				}
			}else {
				//DEntro de este if se crean las "cartas Especiales con color"
				if(colorCard > 3) {
					/*
					 * Son 8 unidades por cada "carta Especial con color"
					 * Son 4 colores y por cada color hay 2 unidades = 8:
					 * 		se empieza contando de 0-3
					 * 		cuando el color card sea mayor a 3 entonces:
					 * 				se cambia el codigo de la "carta Especial con color"
					 */
					createCards(codeCard + 1, 0);
				}else {
					String img = String.format("%s%s.jpg", codeCard, colorCard);
					Card card2 = new Card(codeCard, colorCard, img, "special");
					Card card3 = new Card(codeCard, colorCard, img, "special");
					this.principalDeck.setCard(card2);
					this.principalDeck.setCard(card3);
					createCards(codeCard, colorCard + 1);
				}
			}
		}else {
			//Dentro de este if se crean las "cartas Numericas"
			if(colorCard > 3) {
				/*
				 * Son 8 unidades por cada "carta Numerica":
				 * Son 4 colores y por cada color hay 2 unidades = 8
				 * 		se empieza contando de 0-3
				 * 		cuando el color card sea mayor a 3 entonces:
				 * 				se cambia el codigo de la "carta Numerica"
				 */
				createCards(codeCard + 1, 0);
			}else {
				String img = String.format("%s%s.jpg", codeCard, colorCard);
				Card card4 = new Card(codeCard, colorCard, img, "numeric");
				Card card5 = new Card(codeCard, colorCard, img, "numeric");
				this.principalDeck.setCard(card4);
				this.principalDeck.setCard(card5);
				createCards(codeCard, colorCard + 1);
			}
		}
	}
	
	public void deal(Integer num, Player player) {
		//for(int i=0; i<7;i++) {
		if(num <= 0) {
			
		}else {
			player.setCard(this.principalDeck.deal());
			deal(num - 1, player);
		}
			
		
	}	
	

	
	public void print() {
		
	}
}

