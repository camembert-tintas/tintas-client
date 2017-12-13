import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import core.*;

public class PawnTest {

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
	public void test() {
		Pawn p = new Pawn(new Coordinate('A',1));
		assertTrue(p.toString().Equals("A1"));
		p.setCoordinate(new Coordinate('B',5));
		assertTrue(p.toString().Equals("B5"));
	}

}
