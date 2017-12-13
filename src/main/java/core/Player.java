package core;

import java.util.AbstractCollection;
import java.util.AbstractList;
import java.util.ArrayList;

public class Player {
	private static int num = 0;
	private String name;
	private ArrayList<Piece> pieces;
	
	public Player(String name){
		this.name = name;
		num++;
	}

	public Piece[] getPieces() {
		return pieces;
	}

	public void setPieces(Piece[] pieces) {
		this.pieces = pieces;
	}
	
	public void addPieces(Piece piece){
		pieces.add(piece);
	}

	public static int getNum() {
		return num;
	}

	public String getName() {
		return name;
	}
	
	

}
