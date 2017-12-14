package core;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Engine e = new Engine();
		e.addPlayer(new Player("Marcus"));
		e.addPlayer(new Player("Romulus"));
		e.setPawn(new Coordinate('D',5));
		e.printTableau();
		do{
			e.randomMove();
			e.printTableau();
		}while(!e.hasWinner());
	}

}
