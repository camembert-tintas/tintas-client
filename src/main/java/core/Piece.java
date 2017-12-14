package core;

import utility.Color;

public class Piece {

	private int color;
	
	public Piece(){
		color = randomColor();
	}
	
	public Piece(int c){
		this.color = c;
	}
	
	public Piece(Piece p){
		this.color = p.getColor();
	}
	
	private int randomColor(){
		color = (int)( Math.random()*( Color.values().length-1 )+1);
		return color;
	}
	
	public int getColor(){
		return color;
	}
};
