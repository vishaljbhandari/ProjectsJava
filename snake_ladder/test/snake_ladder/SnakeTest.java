package snake_ladder;

import static org.junit.Assert.*;

import org.junit.Test;

public class SnakeTest {
	//Test Snake(Position, Position) Constructor When : head > tail
	@Test
	public void testSnakePositionPositionWhenHeadGreaterThanTail() throws SnakeAndLadderException {
		int head = 10;
		int tail = 6;
		Snake snake = new Snake(new Position(head), new Position(tail));
		assertTrue(snake.getHeadValue()==head && snake.getTailValue()==tail);
	}

	//Test Snake(Position, Position) Constructor When : head == tail :Exception	
	@Test (expected = SnakeAndLadderException.class)
	public void testSnakePositionPositionWhenHeadIsEqualToTail() throws SnakeAndLadderException {
		int head = 10;
		int tail = 10;
		Snake snake = new Snake(new Position(head), new Position(tail));
		assertTrue(snake.getHeadValue()==head && snake.getTailValue()==tail);
	}
	
	//Test Snake(Position, Position) Constructor When : head == tail :Exception	
	@Test (expected = SnakeAndLadderException.class)
	public void testSnakePositionPositionWhenHeadLessThanTail() throws SnakeAndLadderException {
		int head = 10;
		int tail = 15;
		Snake snake = new Snake(new Position(head), new Position(tail));
		assertTrue(snake.getHeadValue()==head && snake.getTailValue()==tail);
	}

	//Test Snake(Position, Position) Constructor When : head == 0 :Exception
	@Test (expected = SnakeAndLadderException.class)
	public void testSnakePositionPositionWhenHeadIsZero() throws SnakeAndLadderException {
		int head = 0;
		int tail = 15;
		Snake snake = new Snake(new Position(head), new Position(tail));
		assertTrue(snake.getHeadValue()==head && snake.getTailValue()==tail);
	}
	
	//Test Snake(Position, Position) Constructor When : head == 1 :Exception
	@Test (expected = SnakeAndLadderException.class)
	public void testSnakePositionPositionWhenHeadIsOne() throws SnakeAndLadderException {
		int head = 1;
		int tail = 15;
		Snake snake = new Snake(new Position(head), new Position(tail));
		assertTrue(snake.getHeadValue()==head && snake.getTailValue()==tail);
	}
	
	//Test Snake(Position, Position) Constructor When : head == MaxValue OR Size :Exception
	@Test (expected = SnakeAndLadderException.class)
	public void testSnakePositionPositionWhenHeadIsAtEndFinishPoint() throws SnakeAndLadderException {
		int dim = 10;
		Board.setBoardDimension(dim);
		int head = Board.getSizeOfBoard();
		int tail = 15;
		Snake snake = new Snake(new Position(head), new Position(tail));
		assertTrue(snake.getHeadValue()==head && snake.getTailValue()==tail);
	}
	
	//Test Snake(Position, Position) Constructor When : tail == MaxValue OR Size :Exception
	@Test (expected = SnakeAndLadderException.class)
	public void testSnakePositionPositionWhenTailIsAtEndFinishPoint() throws SnakeAndLadderException {
		int dim = 10;
		Board.setBoardDimension(dim);
		int head = 24;
		int tail = Board.getSizeOfBoard();
		Snake snake = new Snake(new Position(head), new Position(tail));
		assertTrue(snake.getHeadValue()==head && snake.getTailValue()==tail);
	}

	//Test Snake(Position, Position) Constructor When : tail == MaxValue-1 :Exception
	@Test (expected = SnakeAndLadderException.class)
	public void testSnakePositionPositionWhenTailIsAtOneBeforeEndFinishPoint() throws SnakeAndLadderException {
		int dim = 10;
		Board.setBoardDimension(dim);
		int head = 24;
		int tail = Board.getSizeOfBoard()-1;
		Snake snake = new Snake(new Position(head), new Position(tail));
		assertTrue(snake.getHeadValue()==head && snake.getTailValue()==tail);
	}

	//Test Snake(Position, Position) Constructor When : tail == 0 :Exception
	@Test (expected = SnakeAndLadderException.class)
	public void testSnakePositionPositionWhenTailIsZero() throws SnakeAndLadderException {
		int head = 10;
		int tail = 0;
		Snake snake = new Snake(new Position(head), new Position(tail));
		assertTrue(snake.getHeadValue()==head && snake.getTailValue()==tail);
	}

	//Test Snake() Constructor When : tail == Max-1 AND head == 1 :Exception
	@Test
	public void testSnake() throws SnakeAndLadderException {
		int dim = 10;
		Board.setBoardDimension(dim);	
		Snake snake = new Snake();
		assertTrue(snake.getHeadValue()==Board.getSizeOfBoard() - 1 && snake.getTailValue()==1);
	}

	@Test
	public void testGetHead() throws SnakeAndLadderException {
		Snake snake = new Snake(new Position(10), new Position(5));
		assertEquals("Result", 10, snake.getHead().getValue());
	}

	@Test
	public void testGetHeadValueWhenSetAValidHeadValue() throws SnakeAndLadderException {
		Snake snake = new Snake(new Position(10), new Position(5));
		snake.setHeadValue(7);
		assertTrue(snake.validateSnake()==true);
	}	

	@Test (expected = SnakeAndLadderException.class)
	public void testSetHeadValueWhenSetAInValidTHeadValue() throws SnakeAndLadderException {
		Snake snake = new Snake(new Position(10), new Position(5));
		snake.setHeadValue(3);
	}
	
	@Test (expected = SnakeAndLadderException.class)
	public void testSetHeadValueWhenSetAInValidTHeadValueAsZero() throws SnakeAndLadderException {
		Snake snake = new Snake(new Position(10), new Position(5));
		snake.setHeadValue(0);
	}
	
	@Test (expected = SnakeAndLadderException.class)
	public void testSetHeadValueWhenSetAInValidTHeadValueAsMax() throws SnakeAndLadderException {
		int dim = 10;
		Board.setBoardDimension(dim);
		Snake snake = new Snake(new Position(10), new Position(5));
		snake.setHeadValue(Board.getSizeOfBoard());
	}
	
	@Test (expected = SnakeAndLadderException.class)
	public void testSetHeadValueWhenSetAInValidTHeadValueAsOne() throws SnakeAndLadderException {
		int dim = 10;
		Board.setBoardDimension(dim);
		Snake snake = new Snake(new Position(10), new Position(5));
		snake.setHeadValue(1);
	}

	@Test
	public void testSetHeadWhenSetAValidHead() throws SnakeAndLadderException {
		Snake snake = new Snake(new Position(10), new Position(5));
		snake.setHead(new Position(7));
		assertTrue(snake.validateSnake()==true);
	}

	@Test (expected = SnakeAndLadderException.class)
	public void testSetHeadWhenSetAInValidTHeadValue() throws SnakeAndLadderException {
		Snake snake = new Snake(new Position(10), new Position(5));
		snake.setHead(new Position(3));
	}
	
	@Test (expected = SnakeAndLadderException.class)
	public void testSetHeadWhenSetAInValidTHeadValueAsZero() throws SnakeAndLadderException {
		Snake snake = new Snake(new Position(10), new Position(5));
		snake.setHead(new Position(0));
	}
	
	@Test (expected = SnakeAndLadderException.class)
	public void testSetHeadWhenSetAInValidTHeadValueAsMax() throws SnakeAndLadderException {
		int dim = 10;
		Board.setBoardDimension(dim);
		Snake snake = new Snake(new Position(10), new Position(5));
		snake.setHead(new Position(Board.getSizeOfBoard()));
	}
	
	@Test (expected = SnakeAndLadderException.class)
	public void testSetHeadWhenSetAInValidTHeadValueAsOne() throws SnakeAndLadderException {
		int dim = 10;
		Board.setBoardDimension(dim);
		Snake snake = new Snake(new Position(10), new Position(5));
		snake.setHead(new Position(1));
	}

	@Test
	public void testGetTail() throws SnakeAndLadderException {
		Snake snake = new Snake(new Position(10), new Position(5));
		assertEquals("Result", 5, snake.getTail().getValue());
	}

	@Test
	public void testGetTailValue() throws SnakeAndLadderException {
		Snake snake = new Snake(new Position(10), new Position(5));
		assertEquals("Result", 5, snake.getTailValue());
	}

	@Test (expected = SnakeAndLadderException.class)
	public void testSetTailWhenSetAInValidTailValue() throws SnakeAndLadderException {
		Snake snake = new Snake(new Position(10), new Position(5));
		snake.setTail(new Position(15));
	}
	
	@Test (expected = SnakeAndLadderException.class)
	public void testSetTailWhenSetAInValidTailValueAsZero() throws SnakeAndLadderException {
		Snake snake = new Snake(new Position(10), new Position(5));
		snake.setTail(new Position(0));
	}
	
	@Test (expected = SnakeAndLadderException.class)
	public void testSetTailWhenSetAInValidTailValueAsMax() throws SnakeAndLadderException {
		int dim = 10;
		Board.setBoardDimension(dim);
		Snake snake = new Snake(new Position(10), new Position(5));
		snake.setTail(new Position(Board.getSizeOfBoard()));
	}
	
	@Test (expected = SnakeAndLadderException.class)
	public void testSetTailWhenSetAInValidTailValueAsMaxMinusOne() throws SnakeAndLadderException {
		int dim = 10;
		Board.setBoardDimension(dim);
		Snake snake = new Snake(new Position(10), new Position(5));
		snake.setTail(new Position(Board.getSizeOfBoard()-1));
	}
	
	@Test
	public void testSetTailWhenSetAValidTail() throws SnakeAndLadderException {
		Snake snake = new Snake(new Position(10), new Position(5));
		snake.setTail(new Position(6));
		assertTrue(snake.validateSnake()==true);
	}

	@Test (expected = SnakeAndLadderException.class)
	public void testSetTailValueWhenSetAInValidTailValue() throws SnakeAndLadderException {
		Snake snake = new Snake(new Position(10), new Position(5));
		snake.setTailValue(15);
	}
	
	@Test (expected = SnakeAndLadderException.class)
	public void testSetTailValueWhenSetAInValidTailValueAsZero() throws SnakeAndLadderException {
		Snake snake = new Snake(new Position(10), new Position(5));
		snake.setTailValue(0);
	}
	
	@Test (expected = SnakeAndLadderException.class)
	public void testSetTailValueWhenSetAInValidTailValueAsMax() throws SnakeAndLadderException {
		int dim = 10;
		Board.setBoardDimension(dim);
		Snake snake = new Snake(new Position(10), new Position(5));
		snake.setTailValue(Board.getSizeOfBoard());
	}
	
	@Test (expected = SnakeAndLadderException.class)
	public void testSetTailValueWhenSetAInValidTailValueAsMaxMinusOne() throws SnakeAndLadderException {
		int dim = 10;
		Board.setBoardDimension(dim);
		Snake snake = new Snake(new Position(10), new Position(5));
		snake.setTailValue(Board.getSizeOfBoard()-1);
	}
		
	@Test
	public void testSetTailValueWhenSetAValidTailValue() throws SnakeAndLadderException {
		Snake snake = new Snake(new Position(10), new Position(5));
		snake.setTailValue(6);
		assertTrue(snake.validateSnake()==true);
	}

	@Test
	public void testSnakeBiteWhenBite() throws SnakeAndLadderException {
		Snake snake = new Snake(new Position(10), new Position(5));
		assertTrue(snake.snakeBite().getValue()==5);
	}

	@Test
	public void testSnakeBiteWhenNoBite() throws SnakeAndLadderException {
		Snake snake = new Snake(new Position(10), new Position(5));
		assertTrue(snake.snakeBite().getValue()!=11);
	}
	
	@Test
	public void testIsBiteWhenBite() throws SnakeAndLadderException {
		Snake snake = new Snake(new Position(10), new Position(5));
		assertTrue(snake.isBite(new Position(10))==true);
	}

	@Test
	public void testIsBiteWhenNoBite() throws SnakeAndLadderException {
		Snake snake = new Snake(new Position(10), new Position(5));
		assertTrue(snake.isBite(new Position(6))==false);
	}
	
	@Test
	public void testValidateSnakeSuccessfully() throws SnakeAndLadderException {
		Snake snake = new Snake(new Position(10), new Position(5));
		assertTrue(snake.validateSnake()==true);
	}

	@Test (expected = SnakeAndLadderException.class)
	public void testValidateSnakeFailedWhenHeadLessThanTail() throws SnakeAndLadderException {
		Snake snake = new Snake(new Position(5), new Position(10));
		assertTrue(snake.validateSnake()==true);	
	}

	@Test (expected = SnakeAndLadderException.class)
	public void testValidateSnakeFailedWhenHeadIsAtZero() throws SnakeAndLadderException {
		Snake snake = new Snake(new Position(0), new Position(10));
		assertTrue(snake.validateSnake()==true);	
	}

	@Test (expected = SnakeAndLadderException.class)
	public void testValidateSnakeFailedWhenHeadIsAtOne() throws SnakeAndLadderException {
		Snake snake = new Snake(new Position(1), new Position(10));
		assertTrue(snake.validateSnake()==true);	
	}

	@Test (expected = SnakeAndLadderException.class)
	public void testValidateSnakeFailedWhenHeadIsAtEnd() throws SnakeAndLadderException {
		int dim = 10;
		Board.setBoardDimension(dim);
		Snake snake = new Snake(new Position(Board.getSizeOfBoard()), new Position(10));
		assertTrue(snake.validateSnake()==true);	
	}

	@Test (expected = SnakeAndLadderException.class)
	public void testValidateSnakeFailedWhenTailIsAtZero() throws SnakeAndLadderException {
		int dim = 10;
		Board.setBoardDimension(dim);
		Snake snake = new Snake(new Position(5), new Position(0));
		assertTrue(snake.validateSnake()==true);	
	}

	@Test (expected = SnakeAndLadderException.class)
	public void testValidateSnakeFailedWhenTailIsAtEnd() throws SnakeAndLadderException {
		int dim = 10;
		Board.setBoardDimension(dim);
		Snake snake = new Snake(new Position(5), new Position(Board.getSizeOfBoard()));
		assertTrue(snake.validateSnake()==true);	
	}

	@Test (expected = SnakeAndLadderException.class)
	public void testValidateSnakeFailedWhenTailIsAtOneBeforeTheEnd() throws SnakeAndLadderException {
		int dim = 10;
		Board.setBoardDimension(dim);
		Snake snake = new Snake(new Position(5), new Position(Board.getSizeOfBoard()-1));
		assertTrue(snake.validateSnake()==true);	
	}

}
