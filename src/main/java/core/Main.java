package core;

import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//e.setPawn(c);
		//e.printTableau();
		Scanner sc = new Scanner(System.in);
		Engine jeu = new Engine();
		jeu.addPlayer(new Player("Player 1"));
		jeu.addPlayer(new Player("Player 2"));
		jeu.setPawn(new Coordinate('A',7));
		jeu.printTableau();
		while(!jeu.getPlayers().get(jeu.actualPlayer()).check7PiecesSameColor()){
			System.out.println(jeu.getPlayers().get(jeu.actualPlayer()).getName());
			System.out.print("Entrer une coordonnée(exemple: B6): ");
			String coord = sc.nextLine();
			jeu.move(new Coordinate(Character.toUpperCase(coord.charAt(0)), Character.getNumericValue(coord.charAt(1))));
			jeu.printTableau();
		}
	}
}
