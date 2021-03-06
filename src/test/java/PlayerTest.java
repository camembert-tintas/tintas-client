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

}
