package core;

import java.util.ArrayList;

import utility.Color;

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

	public boolean check7PiecesSameColor(){
		int nbWhite = 0;
		int nbBlue = 0;
		int nbYellow = 0;
		int nbOrange = 0;
		int nbPurple = 0;
		int nbGreen = 0;
		int nbRed = 0;
		for(int i=0; i<this.pieces.size(); i++) {
			switch(this.pieces.get(i).getColor()){
			case 1:
				nbWhite++; break;
			case 2:
				nbBlue++; break;
			case 3:
				nbYellow++; break;
			case 4:
				nbOrange++; break;
			case 5:
				nbPurple++; break;
			case 6:
				nbGreen++; break;
			case 7:
				nbRed++; break;
			}
			if (nbWhite == 7 || nbBlue == 7 || nbYellow == 7 || nbOrange == 7 || nbPurple == 7 
					|| nbGreen == 7 || nbRed == 7) {
				return true;
			}
		}
		return false;
	}
	
	public boolean check4PiecesFor4DifferentColor(){
		int nbWhite = 0;
		int nbBlue = 0;
		int nbYellow = 0;
		int nbOrange = 0;
		int nbPurple = 0;
		int nbGreen = 0;
		int nbRed = 0;
		
		int count = 0;
		for(int i=0; i<this.pieces.size(); i++) {
			switch(this.pieces.get(i).getColor()){
			case 1:
				nbWhite++; break;
			case 2:
				nbBlue++; break;
			case 3:
				nbYellow++; break;
			case 4:
				nbOrange++; break;
			case 5:
				nbPurple++; break;
			case 6:
				nbGreen++; break;
			case 7:
				nbRed++; break;
			}
		}
		if (nbWhite >= 4) {
			count++;
		}
		if (nbBlue >= 4) {
			count++;
		}
		if (nbYellow >= 4) {
			count++;
		}
		if (nbOrange >= 4) {
			count++;
		}
		if (nbPurple >= 4) {
			count++;
		}
		if (nbGreen >= 4) {
			count++;
		}
		if (nbRed >= 4) {
			count++;
		}
		
		if (count >= 4) {
			return true;
		}
		return false;
	}
}
