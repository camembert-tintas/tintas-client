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

	public ArrayList<Piece> getPieces() {
		return pieces;
	}

	public void setPieces(ArrayList<Piece> pieces) {
		this.pieces = pieces;
	}
	
	public void addPieces(Piece piece){
		pieces.add(piece);
	}

	public int getNum() {
		return num;
	}

	public String getName() {
		return name;
	}

}
