package core;

import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Engine jeu = new Engine();
		jeu.addPlayer(new Player("Player 1"));
		while(!jeu.getPlayers().get(0).check7PiecesSameColor() && 
				!jeu.getPlayers().get(0).check7PiecesSameColor()){
			System.out.print("Entrer une coordonnée(exemple: B6): ");
			String coord = sc.nextLine();
			jeu.move(new Coordinate(Character.toUpperCase(coord.charAt(0)), Character.getNumericValue(coord.charAt(1))));
		}
	}
}
