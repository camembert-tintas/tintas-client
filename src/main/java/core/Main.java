package core;

import gui.TintasUserInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import utility.DataBaseConnection;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {		
		TintasUserInterface gui = TintasUserInterface.start();
		Scanner sc = new Scanner(System.in);
		Engine e = new Engine();
		System.out.print("Entrer le même login que celui de l'inscription: ");
		String name = sc.nextLine();
		e.addPlayer(new Player(name));
		e.addPlayer(new Player("IA manuel"));
		e.setPawn(new Coordinate('A',6));
		e.printTableau();
		do{						
			System.out.println(e.getPlayers().get(e.actualPlayer()).getName());
			System.out.print("Entrer une coordonnee(exemple: B6): ");
			//String coord = sc.nextLine();
			//e.move(new Coordinate(Character.toUpperCase(coord.charAt(0)), Character.getNumericValue(coord.charAt(1))));
			e.randomMove();
			e.printTableau();
		}while(!e.hasWinner());
		System.out.println("FIN!");
		
		try{
			Connection connexion;
			PreparedStatement preparedStatement;
			
			connexion = DataBaseConnection.connect();
			
			String subRequestRes = "SELECT id FROM player WHERE login =\""+name+"\"";
			preparedStatement = connexion.prepareStatement(subRequestRes);
			ResultSet resultId = preparedStatement.executeQuery();
			resultId.next();
			int playerId = resultId.getInt("id");
			
			int gameId = e.getId(), score = e.getScore(name), isWinner = e.getWinner().equals(name)?1:0;
			String request = "INSERT INTO games(games_id,player_id,player_score,player_win) VALUES("+
					gameId + "," + playerId + "," + score + "," + isWinner +")";
			
			PreparedStatement preparedStatementSec = connexion.prepareStatement(request);
			preparedStatementSec.executeUpdate();
			
			preparedStatement.close();
			connexion.close();
			
		} catch (SQLException e1) {
			e1.printStackTrace();
			System.out.println("Veulliez vous inscrire sur le site.");
		}
	}
}
