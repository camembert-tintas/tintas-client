import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import core.*;

public class EngineTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testConstructor() {
		int count = 0;
	    String letter = "ABCDEFGHI";
	    for (int i = 0; i < letter.length(); i++) {
	        for (int j = 1; j <= 9; j++) {
	            Coordinate coordinates = new Coordinate(letter.charAt(i), j);
	            if (coordinates.isValid()) {
	                count++;
	            }
	        }
	    }
	    assertTrue(count == 49);
	}
	
	@Test
	public void testPlayer() {
		Engine e = new Engine();
		e.addPlayer(new Player("Marcus"));
		e.addPlayer(new Player("Romulus"));
		ArrayList<Player> players = e.getPlayers();
		assertTrue(players.get(0).getName().equals("Marcus"));
		assertTrue(players.get(1).getName().equals("Romulus"));
		assertTrue(e.actualPlayer() == 1);
		e.changePlayer();
		assertTrue(e.actualPlayer() == 2);
	}
	
	@Test
	public void testColors() {
		Engine e = new Engine();
		e.fillEngine();
		int nbWhite = 0;
		int nbBlue = 0;
		int nbYellow = 0;
		int nbOrange = 0;
		int nbPurple = 0;
		int nbGreen = 0;
		int nbRed = 0;
		for(int i=0; i<e.getPlateau().size(); i++) {
			switch(e.getPlateau().get(i).getPiece().getColor()){
			case 1:
				nbWhite++; break;
			case 2:
				nbBlue++; break;
			case 3:
				nbYellow++; break;
			case 4:
				nbOrange++; break;
			case 5:
				nbPurple++; break;
			case 6:
				nbGreen++; break;
			case 7:
				nbRed++; break;
			}
		}
		assertTrue(nbWhite == 7);
		assertTrue(nbBlue == 7);
		assertTrue(nbYellow == 7);
		assertTrue(nbOrange == 7);
		assertTrue(nbPurple == 7);
		assertTrue(nbGreen == 7);
		assertTrue(nbRed == 7);
	}
	
	@Test
	public void testPawn() {
		Engine e = new Engine();
		e.setPawn(new Coordinate('A',1));
		assertTrue(e.getPawn().getCoordinate().toString().equals("A1"));
	}

}
