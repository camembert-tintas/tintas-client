package core;

public class Coordinate {
	private int line;
	private char column;
	
	public int getLine() {
		return line;
	}

	public char getColumn() {
		return column;
	}

	public Coordinate(char column, int line){
		this.line = line;
		this.column = column;
	}
	
	public Coordinate(Coordinate c){
		this.line = c.getLine();
		this.column = c.getColumn();
	}
	
	public boolean isValid(){	
		String[] valid = {"A6","A7","B5","B6","B7","B8","B9",
				"C3","C4","C5","C6","C7","C8","C9","D2","D3",
				"D4","D5","D6","D7","D8","E2","E3","E4","E5",
				"E6","E7","E8","F2","F3","F4","F5","F6","F7",
				"F8","G1","G2","G3","G4","G5","G6","G7","H1",
				"H2","H3","H4","H5","I3","I4"};
		for(int i = 0; i < valid.length; i++){
			if(this.toString().equals(valid[i])){
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return column + "" + line;
	}

}
