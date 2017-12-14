import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import core.Coordinate;

public class CoordinateTest {

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
		Coordinate c = new Coordinate('A',1);
		assertTrue(c.getColumn() == 'A');
		assertTrue(c.getLine() == 1);
		assertTrue(c.toString().equals("A1"));
		assertTrue(c.isValid() == false);
	}

}
