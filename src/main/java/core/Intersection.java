package core;

import utility.State;

public class Intersection {
	private int state;
	private Piece piece;
	private Coordinate coord;

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}

	public Coordinate getCoord() {
		return coord;
	}

	public void setCoord(Coordinate coord) {
		this.coord = coord;
	}

	public Intersection(Coordinate c) {
		this.state = State.LIBRE.getState();
		this.coord = new Coordinate(c);
	}
}
