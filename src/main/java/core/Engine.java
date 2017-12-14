package core;

import utility.*;
import java.util.ArrayList;
import java.util.Random;

public class Engine {

	private static int id = 0;
	private ArrayList<Intersection> plateau;
	private ArrayList<Player> players;
	private int actualPlayer = (int) (Math.random()*1);
	private Pawn pawn;
	
	public Engine(){
		plateau = new ArrayList<Intersection>();
		players = new ArrayList<Player>();
		String letter = "ABCDEFGHI";
	    for (int i = 0; i < letter.length(); i++) {
	        for (int j = 1; j <= 9; j++) {
	            Coordinate coordinates = new Coordinate(letter.charAt(i), j);
	            if (coordinates.isValid()) {
	                plateau.add(new Intersection(coordinates));
	            }
	        }
	    }
	    id++;
	}
	
	public void addPlayer(Player player){
		players.add(new Player(player));
	}
	
	public ArrayList<Player> getPlayers(){
		return players;
	}
	
	public int actualPlayer(){
		return actualPlayer;
	}
	
	public void changePlayer(){
		actualPlayer = actualPlayer==1?2:1;
	}
	
	public void setPawn(Coordinate c){
		if(pawn==null){
			pawn = new Pawn(c);
		}else{
			pawn.setCoordinate(c);
		}
	}
	
	public Pawn getPawn(){
		return pawn;
	}
	
	public Intersection getIntersection(String coord){
		for(int i = 0; i < plateau.size(); i++){
			if(plateau.get(i).getCoord().toString().equals(coord)){
				return plateau.get(i);
			}
		}
		return null;
	}
	
	public void move(Coordinate coordTo){
		if((!coordTo.isValid()) ||
				(getIntersection(coordTo.toString()).getState() !=
				utility.State.PIECE.getState())){
			return;
		}
		
		int countEmpty = 0;
		ArrayList<Coordinate> valCoord = possibleMovePawn();
		
		for(int i=0; i<valCoord.size(); i++){
			
			if(getIntersection(valCoord.get(i).toString()).getState() == utility.State.LIBRE.getState()){
				countEmpty++;
			}
			
			if(valCoord.get(i).toString() == coordTo.toString()){
				if(possibleMove(coordTo)){
					doMove(coordTo);
					return;
				}else{
					return;
				}
			}
			
		}
		
		if(countEmpty == valCoord.size()){
			doMove(coordTo);
		}
		changePlayer();
	}
	
	public void doMove(Coordinate coord){
		Intersection intersect = getIntersection(coord.toString());
		Piece piece = intersect.getPiece();
		intersect.removePiece();
		players.get(actualPlayer).addPiece(piece);		
	}
	
	public boolean possibleMove(Coordinate coordinate){
		String coordFrom = pawn.getCoordinate().toString();
		String coordTo = coordinate.toString();
		
		if(coordFrom == coordTo){
			return false;
		}
		
		if (coordFrom.charAt(0) != coordTo.charAt(0) && coordFrom.charAt(1) == coordTo.charAt(1)) {
            return this.isLineEmpty(coordFrom, coordTo);
        } else if (coordFrom.charAt(0) == coordTo.charAt(0) && coordFrom.charAt(1) != coordTo.charAt(1)) {
            return this.isColEmpty(coordFrom, coordTo);
        } else {
            return this.isDiagonalEmpty(coordFrom, coordTo);
        }
	}
	
	public ArrayList<Coordinate> possibleMovePawn(){
		ArrayList<Coordinate> possible = new ArrayList<Coordinate>();		
		Coordinate coordPawn = pawn.getCoordinate();
		
		for(int i = 0; i < plateau.size(); i++){
			Coordinate actualCoord = plateau.get(i).getCoord();
			if(!actualCoord.toString().equals(coordPawn.toString())){
				if(actualCoord.toString().charAt(0) == coordPawn.toString().charAt(0) ||
						actualCoord.toString().charAt(1) == coordPawn.toString().charAt(1) ||
						(coordPawn.toString().charAt(0) - actualCoord.toString().charAt(0) ==
						coordPawn.toString().charAt(1) - actualCoord.toString().charAt(1))){
					possible.add(actualCoord);
				}
			}
		}
		
		return possible;
	}
	
	public boolean isLineEmpty(String coordFrom, String coordTo){
		char columnMin, columnMax, line = coordFrom.charAt(1);
        if(coordFrom.charAt(0) > coordTo.charAt(0)){
        	columnMin = coordTo.charAt(0);
        	columnMax = coordFrom.charAt(0);
        }else{
        	columnMax = coordTo.charAt(0);
        	columnMin = coordFrom.charAt(0);
        }
        columnMin++;
        if(columnMin == columnMax){
        	return true;
        }
        
        do{
        	String tempCoord = columnMin + "" + line;            
            if (getIntersection(tempCoord).getState() != State.LIBRE.getState()) {
                return false;
            }
            columnMin++;
        }while(columnMin < columnMax);

        return true;
    }
	
	public boolean isColEmpty(String coordFrom, String coordTo){
		int lineMin, lineMax;
		char column = coordFrom.charAt(0);
		
        if(Character.getNumericValue(coordFrom.charAt(1)) >
        Character.getNumericValue(coordTo.charAt(1))){
        	lineMin = coordTo.charAt(0);
        	lineMax = coordFrom.charAt(0);
        }else{
        	lineMax = coordTo.charAt(0);
        	lineMin = coordFrom.charAt(0);
        }
        lineMin++;
        if(lineMin == lineMax){
        	return true;
        }
        
        do{
        	String tempCoord = column + "" + lineMin;            
            if (getIntersection(tempCoord).getState() != State.LIBRE.getState()) {
                return false;
            }
            lineMin++;
        }while(lineMin < lineMax);

        return true;
    }
	
	public boolean isDiagonalEmpty(String coordFrom, String coordTo){
		int diff = coordFrom.charAt(0)>coordTo.charAt(0)?-1:+1;
		
		while(coordFrom != coordTo){
			char newCol = coordFrom.charAt(0);
			newCol+=diff;
			int newLine = Character.valueOf(coordFrom.charAt(1));
			newLine+=diff;
			coordFrom = newCol + "" + newLine;
			if(coordFrom != coordTo && getIntersection(coordFrom).getState() != State.LIBRE.getState()){
				return false;
			}
		}
		
		return true;
    }

}
