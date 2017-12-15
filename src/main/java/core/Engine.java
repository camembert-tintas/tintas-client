package core;

import utility.*;
import java.util.ArrayList;
import java.util.Collections;
import utility.Color;

public class Engine {

	private static int id = 0;
	private ArrayList<Intersection> plateau;
	private ArrayList<Player> players;
	private int actualPlayer = (int) (Math.random()*1);
	private Pawn pawn;
	
	public ArrayList<Intersection> getPlateau() {
		return this.plateau;
	}
	
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
	    fillEngine();
	}
	
	public void fillEngine(){
		ArrayList<Piece> tabPiecesColor = new ArrayList<Piece>();
		Piece pWhite = new Piece(Color.WHITE.getColor());
		Piece pBlue = new Piece(Color.BLUE.getColor());
		Piece pYellow = new Piece(Color.YELLOW.getColor());
		Piece pOrange = new Piece(Color.ORANGE.getColor());
		Piece pPurple = new Piece(Color.PURPLE.getColor());
		Piece pGreen = new Piece(Color.GREEN.getColor());
		Piece pRed = new Piece(Color.RED.getColor());
		for (int a=0; a<7; a++) {
			tabPiecesColor.add(pWhite);
			tabPiecesColor.add(pBlue);
			tabPiecesColor.add(pYellow);
			tabPiecesColor.add(pOrange);
			tabPiecesColor.add(pPurple);
			tabPiecesColor.add(pGreen);
			tabPiecesColor.add(pRed);
		}
		
		Collections.shuffle(tabPiecesColor);

		for(int i=0; i<this.plateau.size(); i++){
			this.plateau.get(i).addPiece(tabPiecesColor.get(i));
		}
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
		actualPlayer = actualPlayer==0?1:0;
	}
	
	public void setPawn(Coordinate c){
		if(pawn==null){
			pawn = new Pawn(c);
			Intersection intersect = getIntersection(c.toString());
			players.get(actualPlayer).addPiece(new Piece(intersect.getPiece()));
			intersect.removePiece();
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
	
	public void randomMove(){
		ArrayList<Coordinate> valCoord = possibleMovePawn();
		
		int randInd, count=0;
		do{
			randInd = (int) (Math.random()*valCoord.size());
			System.out.print("rand : " + randInd + "\n");
			count++;
		}while(possibleMove(valCoord.get(randInd)));		
		
		doMove(valCoord.get(randInd));
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
			
			if(valCoord.get(i).toString().equals(coordTo.toString())){
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
	}
	
	public void doMove(Coordinate coord){
		Intersection intersect = getIntersection(coord.toString());
		intersect.setState(utility.State.LIBRE.getState());
		Piece piece = new Piece(intersect.getPiece());
		intersect.removePiece();
		players.get(actualPlayer).addPiece(piece);
		setPawn(coord);
		changePlayer();
	}
	
	public boolean possibleMove(Coordinate coordinate){
		String coordFrom = pawn.getCoordinate().toString();
		String coordTo = coordinate.toString();
		
		if(coordFrom.equals(coordTo) || getIntersection(coordTo).getState() == utility.State.LIBRE.getState()){
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
		System.out.println(pawn.getCoordinate().toString());
		Coordinate coordPawn = new Coordinate(pawn.getCoordinate());
		
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
        	lineMin = Character.getNumericValue(coordTo.charAt(1));
        	lineMax = Character.getNumericValue(coordFrom.charAt(1));
        }else{
        	lineMax = Character.getNumericValue(coordTo.charAt(1));
        	lineMin = Character.getNumericValue(coordFrom.charAt(1));
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
		
		while(!coordFrom.equals(coordTo)){
			char newCol = coordFrom.charAt(0);
			newCol+=diff;
			int newLine = Character.getNumericValue(coordFrom.charAt(1));
			newLine+=diff;
			coordFrom = newCol + "" + newLine;
			if(!(coordFrom.equals(coordTo)) && getIntersection(coordFrom).getState() != State.LIBRE.getState()){
				return false;
			}
		}
		
		return true;
    }

	public void printTableau(){
		String letter = "ABCDEFGHI";
		for (int j = 1; j <= 9; j++) {
			for (int i = 0; i < letter.length(); i++) {
	            Coordinate coordinates = new Coordinate(letter.charAt(i), j);
	            if(this.pawn!=null && this.pawn.getCoordinate().toString().equals(coordinates.toString())){
	            	System.out.print(" X ");
	            }else{
	            	if (coordinates.isValid()) {
	            		System.out.print(" "+getIntersection(coordinates.toString()).printIntersect()+" ");
	            	}else{
	            		System.out.print("   ");
	            	}
	            }
	        }
	        System.out.print("\n");
	    }
	}

	public boolean hasWinner(){
		for(int i = 0; i<players.size(); i++){
			if(players.get(i).hasWin()){
				return true;
			}
		}
		return false;
	}
}
