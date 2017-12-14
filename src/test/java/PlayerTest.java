import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import utility.Color;
import core.*;

public class PlayerTest {

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
		Player p = new Player("Marcus");
		assertTrue(p.getName().equals("Marcus"));
		assertTrue(p.getPieces().size() == 0);
		Piece piece = new Piece();
		p.addPiece(piece);
		assertTrue(p.getPieces().size() == 1);
		
		Player q = new Player("Michou");
		assertTrue(q.getName().equals("Michou"));
		assertTrue(q.getPieces().size() == 0);
	}
	
	@Test
	public void testVictoire() {
		Player p = new Player("Marcus");
		Piece piece = new Piece(Color.BLUE.getColor());
		for (int i=0; i<7; i++){
			p.addPiece(piece);
		}
		assertTrue(p.check7PiecesSameColor() == true);
		
		Piece piece2 = new Piece(Color.WHITE.getColor());
		Piece piece3 = new Piece(Color.RED.getColor());
		Piece piece4 = new Piece(Color.GREEN.getColor());
		p.getPieces().clear();
		
		for (int i=0; i<4; i++){
			p.addPiece(piece);
			p.addPiece(piece2);
			p.addPiece(piece3);
			p.addPiece(piece4);
		}
		
		assertTrue(p.check4PiecesFor4DifferentColor() == true);
	}

}
