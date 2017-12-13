package core;

public class Coordinate {
	private char line;
	private int column;
	
	public char getLine() {
		return line;
	}

	public int getColumn() {
		return column;
	}

	public Coordinate(char line, int column){
		this.line = line;
		this.column = column;
	}

	@Override
	public String toString() {
		return line + "" + column;
	}
	
	

}
