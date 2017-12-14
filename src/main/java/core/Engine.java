package core;

import java.util.ArrayList;

public class Engine {

	private static int id = 0;
	private ArrayList<Intersection> plateau;
	
	public Engine(){
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

}
