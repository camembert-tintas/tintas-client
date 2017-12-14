package core;

import java.util.ArrayList;
import java.util.Vector;

public class Engine {

	private static int id = 0;
	private ArrayList<Intersection> plateau;
	private ArrayList<Player> players;
	private int actualPlayer = 1;
	
	public Engine(){
		plateau = new ArrayList<Intersection>();
		players = new ArrayList<Player>();
		String letter = "ABCDEFGHI";
	    for (int i = 0; i < letter.length(); i++) {
	        for (int j = 1; j <= 9; j++) {
	            Coordinate coordinates = new Coordinate(letter.charAt(i), j);
	            if (coordinates.isValid()) {
	                plateau.add(new Intersection(coordinates));
	            }
	        }
	    }
	    id++;
	}
	
	public void fillEngine(){
		Vector<Integer> tabPiecesColor = new Vector<Integer>();
		for (int a=0; a<7; a++){
			
		}
	}
	
	public void addPlayer(Player player){
		players.add(player);
	}
	
	public ArrayList<Player> getPlayers(){
		return players;
	}
	
	public int actualPlayer(){
		return actualPlayer;
	}
	
	public void changePlayer(){
		actualPlayer = actualPlayer==1?2:1;
	}

}
