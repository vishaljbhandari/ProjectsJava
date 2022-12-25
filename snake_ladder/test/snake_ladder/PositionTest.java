package snake_ladder;

import static org.junit.Assert.*;

import org.junit.Test;

public class PositionTest {

	@Test
	public void testPositionConstructorIntIsZero() throws SnakeAndLadderException {
		Position position = new Position(0);
	    assertEquals("Result", 0, position.getValue());
	}

	@Test
	public void testPositionConstructorIntIsOne() throws SnakeAndLadderException {
		Position position = new Position(1);
	    assertEquals("Result", 1, position.getValue());
	}

	@Test
	public void testPositionConstructorIntIsPositive() throws SnakeAndLadderException {
		Position position = new Position(5);
	    assertEquals("Result", 5, position.getValue());
	}

	@Test(expected = SnakeAndLadderException.class)
	public void testPositionConstructorIntIsNegative() throws SnakeAndLadderException {
		Position position = new Position(-1);
	    assertEquals("Result",0 , position.getValue());
	}

	@Test
	public void testPositionConstructorIntIsOnBoardOuterRange() throws SnakeAndLadderException {
		Board.setBoardDimension(10);
		Position position = new Position(100);
	    assertEquals("Result", 100, position.getValue());
	}
	
	@Test(expected = SnakeAndLadderException.class)
	public void testPositionConstructorIntIsOutOfBoard() throws SnakeAndLadderException {
		Board.setBoardDimension(10);
		Position position = new Position(101);
	    assertEquals("Result", 0, position.getValue());
	}

	@Test
	public void testPositionConstructor() {
		Position position = new Position();
	    assertEquals("Result", 0, position.getValue());
	}

	@Test
	public void testGetValue() throws SnakeAndLadderException {
		Position position = new Position(10);
	    assertEquals("Result", 10, position.getValue());
	}

	@Test
	public void testSetValueIntIsZero() throws SnakeAndLadderException {
		Position position = new Position(10);
		position.setValue(0);
	    assertEquals("Result", 0, position.getValue());
	}

	@Test
	public void testSetValueIntIsOne() throws SnakeAndLadderException {
		Position position = new Position(10);
		position.setValue(1);
	    assertEquals("Result", 1, position.getValue());
	}

	@Test
	public void testSetValueIntIsPositive() throws SnakeAndLadderException {
		Position position = new Position(10);
		position.setValue(6);
	    assertEquals("Result", 6, position.getValue());
	}

	@Test(expected = SnakeAndLadderException.class)
	public void testSetValueIntIsNegative() throws SnakeAndLadderException {
		Position position = new Position(10);
		position.setValue(-9);
	    assertEquals("Result", -9, position.getValue());
	}

	@Test(expected = SnakeAndLadderException.class)
	public void testSetValueIntIsOutOfBoardRange() throws SnakeAndLadderException {
		Board.setBoardDimension(10);
		Position position = new Position(10);
		position.setValue(101);
	    assertEquals("Result", 101, position.getValue());
	}

	@Test
	public void testSetValueIntIsOnOuterRange() throws SnakeAndLadderException {
		Board.setBoardDimension(10);
		Position position = new Position(10);
		position.setValue(100);
	    assertEquals("Result", 100, position.getValue());
	}

	@Test
	public void testEqualPositionsWhenEqual() throws SnakeAndLadderException {
		Position positionOne = new Position(10);
		Position positionTwo = new Position(10);
		assertTrue(positionTwo.getValue()==positionOne.getValue());
	}
	
	@Test
	public void testEqualPositionsWhenNotEqual() throws SnakeAndLadderException {
		Position positionOne = new Position(10);
		Position positionTwo = new Position(11);
		assertTrue(positionTwo.getValue()!=positionOne.getValue());	
	}

}
