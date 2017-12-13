package core;

import utility.Color;

public class Piece {

	private int color;
	
	public Piece(){
		color = randomColor();
	}
	
	private int randomColor(){
		color = (int)( Math.random()*( Color.values().length-1 )+1);
		return color;
	}
	
	public int getColor(){
		return color;
	}
};
