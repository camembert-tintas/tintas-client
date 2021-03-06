package core;

public class Pawn {
	
	private Coordinate coordinate;
	
	public Pawn(Coordinate coordinate){
		this.coordinate = new Coordinate(coordinate);
	}

	public Coordinate getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = new Coordinate(coordinate);
	}
	
	@Override
	public String toString() {
		return this.coordinate.toString();
	}

}
