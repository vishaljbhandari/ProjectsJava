package snake_ladder;

import static org.junit.Assert.*;

import org.junit.Test;

public class LadderTest {
	//Test Ladder(Position, Position) Constructor When : head > tail
	@Test
	public void testLadderPositionPositionWhenHeadGreaterThanTail() throws SnakeAndLadderException {
		int head = 10;
		int tail = 6;
		Ladder ladder = new Ladder(new Position(head), new Position(tail));
		assertTrue(ladder.getHeadValue()==head && ladder.getTailValue()==tail);
	}

	//Test Ladder(Position, Position) Constructor When : head == tail :Exception	
	@Test (expected = SnakeAndLadderException.class)
	public void testLadderPositionPositionWhenHeadIsEqualToTail() throws SnakeAndLadderException {
		int head = 10;
		int tail = 10;
		Ladder ladder = new Ladder(new Position(head), new Position(tail));
		assertTrue(ladder.getHeadValue()==head && ladder.getTailValue()==tail);
	}
	
	//Test Ladder(Position, Position) Constructor When : head == tail :Exception	
	@Test (expected = SnakeAndLadderException.class)
	public void testLadderPositionPositionWhenHeadLessThanTail() throws SnakeAndLadderException {
		int head = 10;
		int tail = 15;
		Ladder ladder = new Ladder(new Position(head), new Position(tail));
		assertTrue(ladder.getHeadValue()==head && ladder.getTailValue()==tail);
	}

	//Test Ladder(Position, Position) Constructor When : head == 0 :Exception
	@Test (expected = SnakeAndLadderException.class)
	public void testLadderPositionPositionWhenHeadIsZero() throws SnakeAndLadderException {
		int head = 0;
		int tail = 15;
		Ladder ladder = new Ladder(new Position(head), new Position(tail));
		assertTrue(ladder.getHeadValue()==head && ladder.getTailValue()==tail);
	}
	
	//Test Ladder(Position, Position) Constructor When : head == 1 :Exception
	@Test (expected = SnakeAndLadderException.class)
	public void testLadderPositionPositionWhenHeadIsOne() throws SnakeAndLadderException {
		int head = 1;
		int tail = 15;
		Ladder ladder = new Ladder(new Position(head), new Position(tail));
		assertTrue(ladder.getHeadValue()==head && ladder.getTailValue()==tail);
	}
	
	//Test Ladder(Position, Position) Constructor When : head == MaxValue OR Size :Exception
	@Test (expected = SnakeAndLadderException.class)
	public void testLadderPositionPositionWhenHeadIsAtEndFinishPoint() throws SnakeAndLadderException {
		int dim = 10;
		Board.setBoardDimension(dim);
		int head = Board.getSizeOfBoard();
		int tail = 15;
		Ladder ladder = new Ladder(new Position(head), new Position(tail));
		assertTrue(ladder.getHeadValue()==head && ladder.getTailValue()==tail);
	}
	
	//Test Ladder(Position, Position) Constructor When : tail == MaxValue OR Size :Exception
	@Test (expected = SnakeAndLadderException.class)
	public void testLadderPositionPositionWhenTailIsAtEndFinishPoint() throws SnakeAndLadderException {
		int dim = 10;
		Board.setBoardDimension(dim);
		int head = 24;
		int tail = Board.getSizeOfBoard();
		Ladder ladder = new Ladder(new Position(head), new Position(tail));
		assertTrue(ladder.getHeadValue()==head && ladder.getTailValue()==tail);
	}

	//Test Ladder(Position, Position) Constructor When : tail == MaxValue-1 :Exception
	@Test (expected = SnakeAndLadderException.class)
	public void testLadderPositionPositionWhenTailIsAtOneBeforeEndFinishPoint() throws SnakeAndLadderException {
		int dim = 10;
		Board.setBoardDimension(dim);
		int head = 24;
		int tail = Board.getSizeOfBoard()-1;
		Ladder ladder = new Ladder(new Position(head), new Position(tail));
		assertTrue(ladder.getHeadValue()==head && ladder.getTailValue()==tail);
	}

	//Test Ladder(Position, Position) Constructor When : tail == 0 :Exception
	@Test (expected = SnakeAndLadderException.class)
	public void testLadderPositionPositionWhenTailIsZero() throws SnakeAndLadderException {
		int head = 10;
		int tail = 0;
		Ladder ladder = new Ladder(new Position(head), new Position(tail));
		assertTrue(ladder.getHeadValue()==head && ladder.getTailValue()==tail);
	}

	//Test Ladder() Constructor When : tail == Max-1 AND head == 1 :Exception
	@Test
	public void testLadder() throws SnakeAndLadderException {
		int dim = 10;
		Board.setBoardDimension(dim);	
		Ladder ladder = new Ladder();
		assertTrue(ladder.getHeadValue()==Board.getSizeOfBoard() - 1 && ladder.getTailValue()==1);
	}

	@Test
	public void testGetHead() throws SnakeAndLadderException {
		Ladder ladder = new Ladder(new Position(10), new Position(5));
		assertEquals("Result", 10, ladder.getHead().getValue());
	}

	@Test
	public void testGetHeadValueWhenSetAValidHeadValue() throws SnakeAndLadderException {
		Ladder ladder = new Ladder(new Position(10), new Position(5));
		ladder.setHeadValue(7);
		assertTrue(ladder.validateLadder()==true);
	}
	
	@Test (expected = SnakeAndLadderException.class)
	public void testGetHeadValueWhenSetAInValidHeadValue() throws SnakeAndLadderException {
		Ladder ladder = new Ladder(new Position(10), new Position(5));
		ladder.setHeadValue(2);
		assertTrue(ladder.validateLadder()==true);
	}

	@Test
	public void testSetHeadWhenSetAValidHead() throws SnakeAndLadderException {
		Ladder ladder = new Ladder(new Position(10), new Position(5));
		ladder.setHead(new Position(7));
		assertTrue(ladder.validateLadder()==true);
	}

	@Test (expected = SnakeAndLadderException.class)
	public void testSetHeadWhenSetAInValidHead() throws SnakeAndLadderException {
		Ladder ladder = new Ladder(new Position(10), new Position(5));
		ladder.setHead(new Position(4));
		assertTrue(ladder.validateLadder()==true);
	}
	
	@Test (expected = SnakeAndLadderException.class)
	public void testSetHeadWhenSetAInValidHeadAsMaxAsZero() throws SnakeAndLadderException {
		int dim = 10;
		Board.setBoardDimension(dim);
		int head = 24;
		int tail = 20;
		Ladder ladder = new Ladder(new Position(head), new Position(tail));
		ladder.setHead(new Position(0));
	}	
	
	@Test (expected = SnakeAndLadderException.class)
	public void testSetHeadWhenSetAInValidHeadAsMaxAsOne() throws SnakeAndLadderException {
		int dim = 10;
		Board.setBoardDimension(dim);
		int head = 24;
		int tail = 20;
		Ladder ladder = new Ladder(new Position(head), new Position(tail));
		ladder.setHead(new Position(1));
	}	
	
	@Test (expected = SnakeAndLadderException.class)
	public void testSetHeadWhenSetAInValidHeadAsMax() throws SnakeAndLadderException {
		int dim = 10;
		Board.setBoardDimension(dim);
		int head = 24;
		int tail = 20;
		Ladder ladder = new Ladder(new Position(head), new Position(tail));
		ladder.setHead(new Position(Board.getSizeOfBoard()));
	}
	

	@Test
	public void testGetTail() throws SnakeAndLadderException {
		Ladder ladder = new Ladder(new Position(10), new Position(5));
		assertEquals("Result", 5, ladder.getTail().getValue());
	}

	@Test
	public void testGetTailValue() throws SnakeAndLadderException {
		Ladder ladder = new Ladder(new Position(10), new Position(5));
		assertEquals("Result", 5, ladder.getTailValue());
	}

	@Test (expected = SnakeAndLadderException.class)
	public void testSetTailWhenSetAInValidTailAsZero() throws SnakeAndLadderException {
		Ladder ladder = new Ladder(new Position(10), new Position(5));
		ladder.setTail(new Position(0));
		assertTrue(ladder.validateLadder()==true);
	}
	
	@Test (expected = SnakeAndLadderException.class)
	public void testSetTailWhenSetAInValidTailAsMax() throws SnakeAndLadderException {
		int dim = 10;
		Board.setBoardDimension(dim);
		int head = 24;
		int tail = 20;
		Ladder ladder = new Ladder(new Position(head), new Position(tail));
		ladder.setTail(new Position(Board.getSizeOfBoard()));
	}
	
	@Test (expected = SnakeAndLadderException.class)
	public void testSetTailWhenSetAInValidTailAsMaxMinusOne() throws SnakeAndLadderException {
		int dim = 10;
		Board.setBoardDimension(dim);
		int head = 24;
		int tail = 20;
		Ladder ladder = new Ladder(new Position(head), new Position(tail));
		ladder.setTail(new Position(Board.getSizeOfBoard()-1));
	}
	
	@Test
	public void testSetTailWhenSetAValidTail() throws SnakeAndLadderException {
		Ladder ladder = new Ladder(new Position(10), new Position(5));
		ladder.setTail(new Position(6));
		assertTrue(ladder.validateLadder()==true);
	}

	@Test (expected = SnakeAndLadderException.class)
	public void testSetTailValueWhenSetAInValidTailValueAsZero() throws SnakeAndLadderException {
		Ladder ladder = new Ladder(new Position(10), new Position(5));
		ladder.setTailValue(0);
	}

	@Test (expected = SnakeAndLadderException.class)
	public void testSetTailValueWhenSetAInValidTailValueAsMax() throws SnakeAndLadderException {
		int dim = 10;
		Board.setBoardDimension(dim);
		int head = 24;
		int tail = 20;
		Ladder ladder = new Ladder(new Position(head), new Position(tail));
		ladder.setTailValue(Board.getSizeOfBoard());
	}

	@Test (expected = SnakeAndLadderException.class)
	public void testSetTailValueWhenSetAInValidTailValueAsMaxMinusOne() throws SnakeAndLadderException {
		int dim = 10;
		Board.setBoardDimension(dim);
		int head = 24;
		int tail = 20;
		Ladder ladder = new Ladder(new Position(head), new Position(tail));
		ladder.setTailValue(Board.getSizeOfBoard()-1);
	}

	@Test
	public void testSetTailValueWhenSetAValidTailValue() throws SnakeAndLadderException {
		Ladder ladder = new Ladder(new Position(10), new Position(5));
		ladder.setTailValue(6);
		assertTrue(ladder.validateLadder()==true);
	}

	@Test
	public void testLadderLeadWhenLead() throws SnakeAndLadderException {
		Ladder ladder = new Ladder(new Position(10), new Position(5));
		assertTrue(ladder.ladderLead().getValue()==10);
	}

	@Test
	public void testLadderLeadWhenNoLead() throws SnakeAndLadderException {
		Ladder ladder = new Ladder(new Position(10), new Position(5));
		assertTrue(ladder.ladderLead().getValue()!=11);
	}
	
	@Test
	public void testIsLeadWhenLead() throws SnakeAndLadderException {
		Ladder ladder = new Ladder(new Position(10), new Position(5));
		assertTrue(ladder.isLead(new Position(5))==true);
	}

	@Test
	public void testIsLeadWhenNoLead() throws SnakeAndLadderException {
		Ladder ladder = new Ladder(new Position(10), new Position(5));
		assertTrue(ladder.isLead(new Position(6))==false);
	}
	
	@Test
	public void testValidateLadderSuccessfully() throws SnakeAndLadderException {
		Ladder ladder = new Ladder(new Position(10), new Position(5));
		assertTrue(ladder.validateLadder()==true);
	}

	@Test (expected = SnakeAndLadderException.class)
	public void testValidateLadderFailedWhenHeadLessThanTail() throws SnakeAndLadderException {
		Ladder ladder = new Ladder(new Position(5), new Position(10));
		assertTrue(ladder.validateLadder()==true);	
	}

	@Test (expected = SnakeAndLadderException.class)
	public void testValidateLadderFailedWhenHeadIsAtZero() throws SnakeAndLadderException {
		Ladder ladder = new Ladder(new Position(0), new Position(10));
		assertTrue(ladder.validateLadder()==true);	
	}

	@Test (expected = SnakeAndLadderException.class)
	public void testValidateLadderFailedWhenHeadIsAtOne() throws SnakeAndLadderException {
		Ladder ladder = new Ladder(new Position(1), new Position(10));
		assertTrue(ladder.validateLadder()==true);	
	}

	@Test (expected = SnakeAndLadderException.class)
	public void testValidateLadderFailedWhenHeadIsAtEnd() throws SnakeAndLadderException {
		int dim = 10;
		Board.setBoardDimension(dim);
		Ladder ladder = new Ladder(new Position(Board.getSizeOfBoard()), new Position(10));
		assertTrue(ladder.validateLadder()==true);	
	}

	@Test (expected = SnakeAndLadderException.class)
	public void testValidateLadderFailedWhenTailIsAtZero() throws SnakeAndLadderException {
		int dim = 10;
		Board.setBoardDimension(dim);
		Ladder ladder = new Ladder(new Position(5), new Position(0));
		assertTrue(ladder.validateLadder()==true);	
	}

	@Test (expected = SnakeAndLadderException.class)
	public void testValidateLadderFailedWhenTailIsAtEnd() throws SnakeAndLadderException {
		int dim = 10;
		Board.setBoardDimension(dim);
		Ladder ladder = new Ladder(new Position(5), new Position(Board.getSizeOfBoard()));
		assertTrue(ladder.validateLadder()==true);	
	}

	@Test (expected = SnakeAndLadderException.class)
	public void testValidateLadderFailedWhenTailIsAtOneBeforeTheEnd() throws SnakeAndLadderException {
		int dim = 10;
		Board.setBoardDimension(dim);
		Ladder ladder = new Ladder(new Position(5), new Position(Board.getSizeOfBoard()-1));
		assertTrue(ladder.validateLadder()==true);	
	}

}
