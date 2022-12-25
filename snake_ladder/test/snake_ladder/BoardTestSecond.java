package snake_ladder;

import static org.junit.Assert.*;

import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class BoardTestSecond {

	@Test
	public void testGenerateSnakeList() throws SnakeAndLadderException {
		Board myBoard = Board.getInstance();	
		myBoard.setSnakeLaddetCount();
		myBoard.getSnakeList().clear();
		List<Position> positionList = myBoard.generateCriticalPositions();
		Collections.shuffle(positionList);		
		int midPartition = myBoard.getSnakeCount()*2;
		myBoard.setSnakeList(myBoard.generateSnakeList(positionList.subList(0, midPartition)));
		assertTrue(myBoard.getSnakeList().size()==myBoard.getSnakeCount());
		//Snake Head > Tail and Other Validations
		for(int i = 0;i<myBoard.getSnakeCount();i++){
			assertTrue(myBoard.getSnakeList().get(i).validateSnake()==true);
		}
	}

	@Test
	public void testGenerateLadderList() throws SnakeAndLadderException {
		Board myBoard = Board.getInstance();	
		myBoard.setSnakeLaddetCount();
		myBoard.getLadderList().clear();
		List<Position> positionList = myBoard.generateCriticalPositions();
		Collections.shuffle(positionList);		
		int midPartition = myBoard.getLadderCount()*2;
		myBoard.setLadderList(myBoard.generateLadderList(positionList.subList(0, midPartition)));
		assertTrue(myBoard.getLadderList().size()==myBoard.getLadderCount());
		//Snake Head > Tail and Other Validations
		for(int i = 0;i<myBoard.getLadderCount();i++){
			assertTrue(myBoard.getLadderList().get(i).validateLadder()==true);
		}
	}

	// To Change Different Values Just Change
	@Test
	public void testGenerateBoardWhenDimensionIs10DifficultyLevelIs1() throws SnakeAndLadderException {
		int dimInput = 10;
		int diffLevel = 1;
		Board myBoard = Board.getInstance();
		myBoard = myBoard.generateBoard();
		/*Test Suit When
			Dimension : 10   [dimInput]
		 	Difficulty Level : 1   [diffLevel]	
		 */
		assertTrue(Board.getBoardDimension()==dimInput);
		assertTrue(Board.getSizeOfBoard()==(dimInput*dimInput));
		assertTrue(myBoard.getClass()==Board.class);
		assertTrue(myBoard instanceof Board == true);
		assertTrue(Board.getDifficultyLevel() == diffLevel);
		int count = (int) Math.floor( Board.getBoardDimension() * ( (float) Board.getDifficultyLevel() / 10 ) );
		count = count == 0 ? 1 : count ;
		assertTrue(myBoard.getSnakeCount()==count);
		count = Board.getBoardDimension() - myBoard.getSnakeCount();
		count = count == 0 ? 1 : count ;
		assertTrue(myBoard.getLadderCount()==count);
		myBoard.generatorSnakeLadder();		
		for(int i = 0;i<myBoard.getLadderCount();i++){
			assertTrue(myBoard.getLadderList().get(i).validateLadder()==true);
		}
		for(int i = 0;i<myBoard.getSnakeCount();i++){
			assertTrue(myBoard.getSnakeList().get(i).validateSnake()==true);
		}		
	}


	@Test
	public void testGenerateBoardWhenDimensionIs50DifficultyLevelIs10() throws SnakeAndLadderException {
		int dimInput = 50;
		int diffLevel = 10;
		Board myBoard = Board.getInstance();
		myBoard = myBoard.generateBoard();
		/*Test Suit When
			Dimension : 10   [dimInput]
		 	Difficulty Level : 1   [diffLevel]	
		 */
		assertTrue(Board.getBoardDimension()==dimInput);
		assertTrue(Board.getSizeOfBoard()==(dimInput*dimInput));
		assertTrue(myBoard.getClass()==Board.class);
		assertTrue(myBoard instanceof Board == true);
		assertTrue(Board.getDifficultyLevel() == diffLevel);
		int count = (int) Math.floor( Board.getBoardDimension() * ( (float) Board.getDifficultyLevel() / 10 ) );
		count = count == 0 ? 1 : count ;
		assertTrue(myBoard.getSnakeCount()==count);
		count = Board.getBoardDimension() - myBoard.getSnakeCount();
		count = count == 0 ? 1 : count ;
		assertTrue(myBoard.getLadderCount()==count);
		myBoard.generatorSnakeLadder();	
		for(int i = 0;i<myBoard.getLadderCount();i++){
			assertTrue(myBoard.getLadderList().get(i).validateLadder()==true);
		}
		for(int i = 0;i<myBoard.getSnakeCount();i++){
			assertTrue(myBoard.getSnakeList().get(i).validateSnake()==true);
		}		
	}


}
