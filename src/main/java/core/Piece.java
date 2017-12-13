package core;

import utility.Color;

public class Piece {

	private String color;
	
	public Piece(){
		color = Color.Blue.toString();
		System.out.println(color);
		//color = Color.randomColor()
	}
	
	private int randomColor(){
		color = (int)( Math.random()*( Color.values().length + 1 ));
		return color;
	}
	
	public String getColor(){
		return color;
	}
};
