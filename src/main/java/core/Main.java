package core;

import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Engine e = new Engine();
		e.addPlayer(new Player("Marcus"));
		e.addPlayer(new Player("Romulus"));
		e.setPawn(new Coordinate('A',6));
		e.printTableau();
		do{						
			System.out.println(e.getPlayers().get(e.actualPlayer()).getName());
			System.out.print("Entrer une coordonn�e(exemple: B6): ");
			//String coord = sc.nextLine();
			//e.move(new Coordinate(Character.toUpperCase(coord.charAt(0)), Character.getNumericValue(coord.charAt(1))));
			e.randomMove();
			e.printTableau();
		}while(!e.hasWinner());
	}
}
