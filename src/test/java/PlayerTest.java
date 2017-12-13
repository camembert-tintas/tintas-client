import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

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
		assertTrue(p.getNum() == 1);
		assertTrue(p.getName().equals("Marcus"));
		assertTrue(p.getPieces().length == 0);
		
		Player q = new Player("Michou");
		assertTrue(p.getNum() == 2);
		assertTrue(p.getName().equals("Michou"));
		assertTrue(p.getPieces().length == 0);
	}

}
