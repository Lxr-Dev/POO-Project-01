package unoDeck;
import java.util.ArrayList;
import java.util.List;
public class Converter {
	
	public Converter() {}
	
	/**
	 * Convierte una Lista de Cartas a un Arreglo de JSON en forma de Cadena
	 * @param List<Card> list recibe una lista enlazada de Cartas
	 * @return String devuelve una cadena JSON
	 * */
	public String toJSONString(List<Card> list) {
		StringBuilder j = new StringBuilder("[");
		int cardNumber = 0;
		for (Card card : list) {
			if (cardNumber != list.size()-1) {
				j.append("{");
				j.append(String.format("\"value\":%s,\"color\":\"%s\",\"img\":\"%s\",\"type\":\"%s\"},",card.getValue(),card.getColor(),card.getImg(),card.getType()));
			}else {
				j.append("{");
				j.append(String.format("\"value\":%s,\"color\":\"%s\",\"img\":\"%s\",\"type\":\"%s\"}",card.getValue(),card.getColor(),card.getImg(),card.getType()));
			}
			cardNumber++;
		}
		j.append("]");
		return (j.toString());
	}
	
	/**
	 * Convierte una cadena JSON a una Lista enlazada de Cartas
	 * @param String JSON recibe un JSON en forma de Cadena
	 * @return List<Card> Devuelve una lista enlazada de Cartas
	 * */
	public List<Card> toCardList(String JSON){
		List<Card> list = new ArrayList<>();
		String j = JSON.replaceAll("(\\[)|(\\])|(\\{)|(\\})|(\"value\":)|(\"color\":)|(\"img\":)|(\"type\":)|(\")","");
		String[] tempCards = j.split(",");
		for (int i=0; i<tempCards.length; i=i+4) {
			list.add(new Card(Integer.parseInt(tempCards[i]),Integer.parseInt(tempCards[1+i]),tempCards[2+i],tempCards[3+i]));
		}
		return list;
	}
	/**
	 *forma la ruta del archivo json donde se guardan los datos del Jugador
	 * @param player.
	 * @param folderCode.
	 * @return devulve un string con la ruta del archivo del jugador
	 * */
	public String playerPath(int player, String folderCode){
		return String.format("%s/player%s.json", folderCode, player);
	}
	/**
	 * Obtiene el Indentificador del player: 1, 2, 3, 4
	 * @param player.
	 * @return Indentificador del jugador
	 * */
	public int GetPlayerValue(String player){
		return Integer.parseInt(player.replaceAll("\\D",""));
	}
	/**
	 * Obtiene un numero entero en una cadena de texto
	 * @param player.
	 * @return numero entero
	 * */
	public Integer GetIntValue(String value){
		return GetPlayerValue(value);
	}
}
