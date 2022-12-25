package snake_ladder;

import static org.junit.Assert.*;

import org.junit.Test;

public class DiceTest {

	@Test
	public void testDice() {
		Dice dice = new Dice();
	    assertEquals("Result", 1, dice.getValue());
	}

	@Test(expected = SnakeAndLadderException.class)
	public void testDiceIntAsZeroNumber() throws SnakeAndLadderException {
		Dice dice = new Dice(0);
	    assertEquals("Result", 0, dice.getValue());
	}

	@Test(expected = SnakeAndLadderException.class)
	public void testDiceIntAsNegativeNumber() throws SnakeAndLadderException {
		Dice dice = new Dice(-1);
	    assertEquals("Result", -1, dice.getValue());
	}
	
	@Test
	public void testDiceIntAsPositiveNumber() throws SnakeAndLadderException {
		Dice dice = new Dice(5);
	    assertEquals("Result", 5, dice.getValue());
	}

	@Test
	public void testDiceIntAsOnUpperBoarderNumber() throws SnakeAndLadderException {
		int range = 6;
		Dice.setDiceRange(range);
		Dice dice = new Dice(range);
	    assertEquals("Result", range, dice.getValue());
	}

	@Test(expected = SnakeAndLadderException.class)
	public void testDiceIntAsOutOfUpperBoarderNumber() throws SnakeAndLadderException {
		int range = 6;
		Dice.setDiceRange(range);
		Dice dice = new Dice(range+1);
	    assertEquals("Result", range+1, dice.getValue());
	}

	@Test
	public void testGetValueAsPositiveNumber() throws SnakeAndLadderException {
		Dice dice = new Dice(1);
	    assertEquals("Result", 1, dice.getValue());
	}

	@Test(expected = SnakeAndLadderException.class)
	public void testGetValueAsNegativeNumber() throws SnakeAndLadderException {
		Dice dice = new Dice(-1);
	    assertEquals("Result", -1, dice.getValue());
	}

	@Test(expected = SnakeAndLadderException.class)
	public void testGetValueAsZeroNumber() throws SnakeAndLadderException {
		Dice dice = new Dice(0);
	    assertEquals("Result", 0, dice.getValue());
	}

	@Test(expected = SnakeAndLadderException.class)
	public void testSetValueAsZeroNumber() throws SnakeAndLadderException {
		Dice dice = new Dice();
		dice.setValue(0);
	    assertEquals("Result", 0, dice.getValue());
	}

	@Test(expected = SnakeAndLadderException.class)
	public void testSetValueAsNegativeNumber() throws SnakeAndLadderException {
		Dice dice = new Dice();
		dice.setValue(-1);
	    assertEquals("Result", -1, dice.getValue());
	}

	@Test
	public void testSetValueAsPositiveNumber() throws SnakeAndLadderException {
		Dice dice = new Dice();
		dice.setValue(4);
	    assertEquals("Result", 4, dice.getValue());
	}

	@Test
	public void testSetValueAsOnUpperBoarderNumber() throws SnakeAndLadderException {
		int range = 6;
		Dice.setDiceRange(range);
		Dice dice = new Dice();
		dice.setValue(range);
	    assertEquals("Result", range, dice.getValue());
	}
	
	@Test (expected = SnakeAndLadderException.class)
	public void testSetValueAsOutOfUpperBoarderNumber() throws SnakeAndLadderException {
		int range = 6;
		Dice.setDiceRange(range);
		Dice dice = new Dice();
		dice.setValue(range+1);
	    assertEquals("Result", range+1, dice.getValue());
	}

	@Test
	public void testGetDiceRange() throws SnakeAndLadderException {
		int range = 6;
		Dice.setDiceRange(range);
	    assertEquals("Result", range, Dice.getDiceRange());
	}

	@Test(expected = SnakeAndLadderException.class)
	public void testSetDiceRangeAsLowerBoundSix() throws SnakeAndLadderException {
		int dim = 6;
		Board.setBoardDimension(dim);		
		assertTrue( Dice.getDiceRange() >= 6  && Dice.getDiceRange() <= (int) (Board.getSizeOfBoard() * 0.25f ));
	}

	@Test(expected = SnakeAndLadderException.class)
	public void testSetDiceRangeAsZero() throws SnakeAndLadderException {
		int dim = 0;
		Board.setBoardDimension(dim);		
		assertTrue( Dice.getDiceRange() >= 6  && Dice.getDiceRange() <= (int) (Board.getSizeOfBoard() * 0.25f ));
	}
	
	@Test
	public void testSetDiceRangeAsUpperBound() throws SnakeAndLadderException {
		int dim = (int) (Board.getSizeOfBoard() * 0.25f );
		Board.setBoardDimension(dim);		
		assertTrue( Dice.getDiceRange() >= 6  && Dice.getDiceRange() <= (int) (Board.getSizeOfBoard() * 0.25f ));
	}
	
	@Test(expected = SnakeAndLadderException.class)
	public void testSetDiceRangeAsMoreThanUpperBound() throws SnakeAndLadderException {
		int dim = (int) (Board.getSizeOfBoard() * 0.25f );
		dim++;
		Board.setBoardDimension(dim);		
		assertTrue( Dice.getDiceRange() >= 6  && Dice.getDiceRange() <= (int) (Board.getSizeOfBoard() * 0.25f ));
	}

	@Test
	public void testRollDice() throws SnakeAndLadderException {
		int range = 6;
		Dice.setDiceRange(range);
		Dice dice = new Dice(1);
		dice.rollDice();
	    assertTrue(dice.getValue() >= 1 && dice.getValue() <= Dice.getDiceRange());
	}

}
