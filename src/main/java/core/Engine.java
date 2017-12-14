package core;

import java.util.ArrayList;
import java.util.Collections;
import utility.Color;

public class Engine {

	private static int id = 0;
	private ArrayList<Intersection> plateau;
	private ArrayList<Player> players;
	private int actualPlayer = 1;
	
	public ArrayList<Intersection> getPlateau() {
		return this.plateau;
	}
	
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
		ArrayList<Piece> tabPiecesColor = new ArrayList<Piece>();
		Piece pWhite = new Piece(Color.WHITE.getColor());
		Piece pBlue = new Piece(Color.BLUE.getColor());
		Piece pYellow = new Piece(Color.YELLOW.getColor());
		Piece pOrange = new Piece(Color.ORANGE.getColor());
		Piece pPurple = new Piece(Color.PURPLE.getColor());
		Piece pGreen = new Piece(Color.GREEN.getColor());
		Piece pRed = new Piece(Color.RED.getColor());
		for (int a=0; a<7; a++){
			tabPiecesColor.add(pWhite);
			tabPiecesColor.add(pBlue);
			tabPiecesColor.add(pYellow);
			tabPiecesColor.add(pOrange);
			tabPiecesColor.add(pPurple);
			tabPiecesColor.add(pGreen);
			tabPiecesColor.add(pRed);
		}
		for(Piece p: tabPiecesColor){
			System.out.print(p.getColor());
		}
		System.out.println();
		Collections.shuffle(tabPiecesColor);
		for(Piece p: tabPiecesColor){
			System.out.print(p.getColor());
		}
		System.out.println();
		for(int i=0; i<this.plateau.size(); i++){
			this.plateau.get(i).addPiece(tabPiecesColor.get(i));
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
