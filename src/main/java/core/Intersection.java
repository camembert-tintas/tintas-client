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

	public Coordinate getCoord() {
		return coord;
	}

	public void setCoord(Coordinate coord) {
		this.coord = new Coordinate(coord);
	}

	public Intersection(Coordinate c) {
		this.state = State.LIBRE.getState();
		this.coord = new Coordinate(c);
	}
	
	//METHODS
	public void addPiece(Piece p){
		this.piece = new Piece(p);
		this.state = State.PIECE.getState();
	}
	
	public void removePiece() {
		this.state = State.LIBRE.getState();
	}
	
	public String printIntersect(){
		if(this.state == State.LIBRE.getState()){
			return "-";
		}else{
			return String.valueOf(this.piece.getColor());
		}
	}
}
