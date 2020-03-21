package unoDeck;

import java.util.ArrayList;


public class PlayerManager {
	private ArrayList <Player> players;
	
	public PlayerManager(){
		this.players = new ArrayList<Player>();
	}
	
	
	public void addPlayer(Player player){
        if(this.players.size() <= 4)
		    this.players.add(player);
	}
	
	public Player Winner(){
		for(var a : this.players){
			if(a.DeckCount() == 0)
				return a;
		}		
		return null;
	}
}