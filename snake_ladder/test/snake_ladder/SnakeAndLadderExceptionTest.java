package snake_ladder;

import static org.junit.Assert.*;

import org.junit.Test;

public class SnakeAndLadderExceptionTest {

	@Test
	public void testSnakeAndLadderException() {
		SnakeAndLadderException exceptionObject = new SnakeAndLadderException();
	    assertEquals("Result", null, exceptionObject.getExceptionMessage());
	}

	@Test
	public void testSnakeAndLadderExceptionString() {
		SnakeAndLadderException exceptionObject = new SnakeAndLadderException("Hello");
	    assertEquals("Result", "Hello", exceptionObject.getExceptionMessage());
	}

	@Test
	public void testGetExceptionMessage() {
		SnakeAndLadderException exceptionObject = new SnakeAndLadderException();
		exceptionObject.setExceptionMessage("Hello");
	    assertEquals("Result", "Hello", exceptionObject.getExceptionMessage());
	}

	@Test
	public void testSetExceptionMessage() {
		SnakeAndLadderException exceptionObject = new SnakeAndLadderException();
		exceptionObject.setExceptionMessage("Hello");
		assertTrue(exceptionObject.getExceptionMessage()==exceptionObject.getExceptionMessage());
	}

}
