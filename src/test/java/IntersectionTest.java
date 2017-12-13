import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import utility.State;
import core.Coordinate;
import core.Intersection;

public class IntersectionTest {

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
		Coordinate c = new Coordinate('A', 1);
		Intersection inter = new Intersection(c);
		assertEquals(inter.getState(), State.LIBRE.getState());
		assertEquals(inter.getCoord().toString(), c.toString());
		assertEquals(inter.getPiece(), null);
	}

}
