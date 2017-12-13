package core;

import utility.Color;

public class Piece {

	private int color;
	
	public Piece(){
		color = randomColor();
		System.out.println(color);
	}
	
	private int randomColor(){
		color = (int)( Math.random()*( Color.values().length ));
		return color;
	}
	
	public int getColor(){
		return color;
	}
};
