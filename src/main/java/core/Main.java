package core;

import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		Scanner sc = new Scanner(System.in);
		Engine jeu = new Engine();
		jeu.addPlayer(new Player("Player 1"));
		jeu.addPlayer(new Player("Player 2"));
		jeu.setPawn(new Coordinate('A',7));
		jeu.printTableau();
		while(!jeu.getPlayers().get(jeu.actualPlayer()).check7PiecesSameColor()){
			System.out.println(jeu.getPlayers().get(jeu.actualPlayer()).getName());
			System.out.print("Entrer une coordonn�e(exemple: B6): ");
			String coord = sc.nextLine();
			jeu.move(new Coordinate(Character.toUpperCase(coord.charAt(0)), Character.getNumericValue(coord.charAt(1))));
			jeu.printTableau();
		}
		*/
		Engine e = new Engine();
		e.addPlayer(new Player("Marcus"));
		e.addPlayer(new Player("Romulus"));
		e.setPawn(new Coordinate('A',6));
		e.printTableau();
		do{
			e.randomMove();
			e.printTableau();
		}while(!e.hasWinner());
	}
}
