package core;

import java.util.ArrayList;

public class Player {
	private static int num = 0;
	private String name;
	private ArrayList<Piece> pieces;
	
	public Player(String name){
		this.name = name;
		pieces = new ArrayList<Piece>(); 
		num++;
	}
	
	public Player(Player player){
		this.num = player.getNum();
		this.name = player.getName();
		this.pieces = player.getPieces();
	}

	public ArrayList<Piece> getPieces() {
		return pieces;
	}
	
	public void addPiece(Piece piece){
		pieces.add(new Piece(piece));
	}

	public int getNum() {
		return num;
	}

	public String getName() {
		return name;
	}

}
