package core;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Engine e = new Engine();
		e.setPawn(new Coordinate('A',7));
		e.printTableau();
	}

}
