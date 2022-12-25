package snake_ladder;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class BoardTest {

	@Test
	public void testGetInstance() {
		Board myBoard = Board.getInstance();		
		assertTrue(myBoard.getClass()==Board.class);
		assertTrue(myBoard instanceof Board == true);		
	}

	@Test
	public void testGetBoardDimension() {
		Board myBoard = Board.getInstance();	
		assertTrue(myBoard.getClass()==Board.class);
		assertTrue(Board.getBoardDimension() == 10);		
	}
	
	@Test
	public void testGetSizeOfBoard() {
		Board myBoard = Board.getInstance();	
		assertTrue(myBoard.getClass()==Board.class);
		assertTrue(Board.getSizeOfBoard() == Board.getBoardDimension()*Board.getBoardDimension());	
	}
	
	@Test
	public void testGetDifficultyLevel() {
		Board myBoard = Board.getInstance();	
		assertTrue(myBoard.getClass()==Board.class);
		assertTrue(Board.getDifficultyLevel()==5);	
	}
	
	@Test(expected = SnakeAndLadderException.class)
	public void testSetBoardDimensionAsNegative() throws SnakeAndLadderException {
		Board myBoard = Board.getInstance();	
		assertTrue(myBoard.getClass()==Board.class);
		Board.setBoardDimension(-1);
	}

	@Test(expected = SnakeAndLadderException.class)
	public void testSetBoardDimensionAsZero() throws SnakeAndLadderException {
		Board myBoard = Board.getInstance();	
		assertTrue(myBoard.getClass()==Board.class);
		Board.setBoardDimension(0);
	}

	@Test(expected = SnakeAndLadderException.class)
	public void testSetBoardDimensionAsOne() throws SnakeAndLadderException {
		Board myBoard = Board.getInstance();	
		assertTrue(myBoard.getClass()==Board.class);
		Board.setBoardDimension(1);
	}

	@Test(expected = SnakeAndLadderException.class)
	public void testSetBoardDimensionAsNine9() throws SnakeAndLadderException {
		Board myBoard = Board.getInstance();	
		assertTrue(myBoard.getClass()==Board.class);
		Board.setBoardDimension(9);
	}

	@Test(expected = SnakeAndLadderException.class)
	public void testSetBoardDimensionAs51() throws SnakeAndLadderException {
		Board myBoard = Board.getInstance();	
		assertTrue(myBoard.getClass()==Board.class);
		Board.setBoardDimension(51);
	}

	@Test(expected = SnakeAndLadderException.class)
	public void testSetBoardDimensionAs100() throws SnakeAndLadderException {
		Board myBoard = Board.getInstance();	
		assertTrue(myBoard.getClass()==Board.class);
		Board.setBoardDimension(100);
	}

	@Test(expected = SnakeAndLadderException.class)
	public void testSetBoardDimensionAs8() throws SnakeAndLadderException {
		Board myBoard = Board.getInstance();	
		assertTrue(myBoard.getClass()==Board.class);
		Board.setBoardDimension(8);
	}

	@Test(expected = SnakeAndLadderException.class)
	public void testSetBoardDimensionAs1000() throws SnakeAndLadderException {
		Board myBoard = Board.getInstance();	
		assertTrue(myBoard.getClass()==Board.class);
		Board.setBoardDimension(100);
	}

	@Test
	public void testSetBoardDimensionAs10() throws SnakeAndLadderException {
		Board myBoard = Board.getInstance();	
		assertTrue(myBoard.getClass()==Board.class);
		Board.setBoardDimension(10);
		assertTrue(Board.getBoardDimension()==10);
	}

	@Test
	public void testSetBoardDimensionAs11() throws SnakeAndLadderException {
		Board myBoard = Board.getInstance();	
		assertTrue(myBoard.getClass()==Board.class);
		Board.setBoardDimension(11);
		assertTrue(Board.getBoardDimension()==11);
	}

	@Test
	public void testSetBoardDimensionAs15() throws SnakeAndLadderException {
		Board myBoard = Board.getInstance();	
		assertTrue(myBoard.getClass()==Board.class);
		Board.setBoardDimension(15);
		assertTrue(Board.getBoardDimension()==15);
	}

	@Test
	public void testSetBoardDimensionAs50() throws SnakeAndLadderException {
		Board myBoard = Board.getInstance();	
		assertTrue(myBoard.getClass()==Board.class);
		Board.setBoardDimension(50);
		assertTrue(Board.getBoardDimension()==50);
	}

	@Test
	public void testSetBoardDimensionAs49() throws SnakeAndLadderException {
		Board myBoard = Board.getInstance();	
		assertTrue(myBoard.getClass()==Board.class);
		Board.setBoardDimension(49);
		assertTrue(Board.getBoardDimension()==49);
	}

	@Test(expected = SnakeAndLadderException.class)
	public void testSetDifficultyLevelAsZero() throws SnakeAndLadderException {
		Board myBoard = Board.getInstance();	
		assertTrue(myBoard.getClass()==Board.class);
		Board.setDifficultyLevel(0);
	}

	@Test(expected = SnakeAndLadderException.class)
	public void testSetDifficultyLevelAsNegative() throws SnakeAndLadderException {
		Board myBoard = Board.getInstance();	
		assertTrue(myBoard.getClass()==Board.class);
		Board.setDifficultyLevel(-1);
	}

	@Test(expected = SnakeAndLadderException.class)
	public void testSetDifficultyLevelAsNegative5() throws SnakeAndLadderException {
		Board myBoard = Board.getInstance();	
		assertTrue(myBoard.getClass()==Board.class);
		Board.setDifficultyLevel(-5);
	}

	@Test
	public void testSetDifficultyLevelAsNine() throws SnakeAndLadderException {
		Board myBoard = Board.getInstance();	
		assertTrue(myBoard.getClass()==Board.class);
		Board.setDifficultyLevel(9);
		assertTrue(Board.getDifficultyLevel()==9);
	}

	@Test
	public void testSetDifficultyLevelAsOne() throws SnakeAndLadderException {
		Board myBoard = Board.getInstance();	
		assertTrue(myBoard.getClass()==Board.class);
		Board.setDifficultyLevel(1);
		assertTrue(Board.getDifficultyLevel()==1);
	}

	@Test
	public void testSetDifficultyLevelAsFive() throws SnakeAndLadderException {
		Board myBoard = Board.getInstance();	
		assertTrue(myBoard.getClass()==Board.class);
		Board.setDifficultyLevel(5);
		assertTrue(Board.getDifficultyLevel()==5);
	}

	@Test(expected = SnakeAndLadderException.class)
	public void testSetDifficultyLevelAsMoreThan10() throws SnakeAndLadderException {
		Board myBoard = Board.getInstance();	
		assertTrue(myBoard.getClass()==Board.class);
		Board.setDifficultyLevel(11);
	}

	@Test
	public void testSetDifficultyLevelAsTen() throws SnakeAndLadderException {
		Board myBoard = Board.getInstance();	
		assertTrue(myBoard.getClass()==Board.class);
		Board.setDifficultyLevel(10);
		assertTrue(Board.getDifficultyLevel()==10);
	}

	@Test
	public void testGetSnakeCount() {
		Board myBoard = Board.getInstance();		
		assertTrue(myBoard.getSnakeCount()==5);
	}

	@Test
	public void testSetSnakeCount() {
		Board myBoard = Board.getInstance();	
		int count = (int) Math.floor( Board.getBoardDimension() * ( (float) Board.getDifficultyLevel() / 10 ) );
		count = count == 0 ? 1 : count ;
		myBoard.setSnakeCount();
		assertTrue(myBoard.getSnakeCount()==count);
	}

	@Test
	public void testGetLadderCount() {
		Board myBoard = Board.getInstance();	
		myBoard.setSnakeCount();
		int count = Board.getBoardDimension() - myBoard.getSnakeCount();
		count = count == 0 ? 1 : count ;
		myBoard.setLadderCount();
		assertTrue(myBoard.getLadderCount()==count);
	}

	@Test
	public void testSetLadderCount() {
		Board myBoard = Board.getInstance();	
		myBoard.setSnakeCount();
		int count = Board.getBoardDimension() - myBoard.getSnakeCount();
		count = count == 0 ? 1 : count ;
		myBoard.setLadderCount();
		assertTrue(myBoard.getLadderCount()==count);
	}

	@Test
	public void testGetCriticalPositionsWhen10DimAnd10DifficultyLevel() throws SnakeAndLadderException {
		Board myBoard = Board.getInstance();
		Board.setBoardDimension(10);
		Board.setDifficultyLevel(10);
		myBoard.setSnakeLaddetCount();
		int count = myBoard.getSnakeCount() + myBoard.getLadderCount();
		assertTrue(myBoard.getCriticalPositions()==count*2);
	}

	@Test
	public void testGetCriticalPositions() {
		Board myBoard = Board.getInstance();
		myBoard.setSnakeLaddetCount();
		int count = myBoard.getSnakeCount() + myBoard.getLadderCount();
		assertTrue(myBoard.getCriticalPositions()==count*2);
	}
	
	@Test
	public void testGetSafeArea() {
		Board myBoard = Board.getInstance();	
		int count = Board.getSizeOfBoard()-myBoard.getSnakeCount()*2;
		assertTrue(myBoard.getSafeArea()==count);
	}

	@Test
	public void testGetCoverArea() {
		Board myBoard = Board.getInstance();	
		int count = Board.getSizeOfBoard()-2;
		assertTrue(myBoard.getCoverArea()==count);
	}
	
	@Test
	public void testGetSnakeList() throws SnakeAndLadderException {
		Board myBoard = Board.getInstance();	
		myBoard.setSnakeLaddetCount();
		myBoard.getSnakeList().clear();
		List<Snake> snakeList = new ArrayList<Snake>();
		int count = myBoard.getSnakeCount();
		for(int i = 0; i < count; i++){
			snakeList.add(new Snake(new Position(i+30),new Position(i+5)));			
		}
		myBoard.setSnakeList(snakeList);
		for(int i = 0; i < myBoard.getSnakeCount(); i++){
			assertTrue(myBoard.getSnakeList().get(i).getHeadValue()==(i+30));
			assertTrue(myBoard.getSnakeList().get(i).getTailValue()==(i+5));	
		}
		assertTrue(count==myBoard.getSnakeCount());
	}
	
	@Test
	public void testSetSnakeList() throws SnakeAndLadderException {
		Board myBoard = Board.getInstance();	
		myBoard.setSnakeLaddetCount();
		myBoard.getSnakeList().clear();
		List<Snake> snakeList = new ArrayList<Snake>();
		int count = myBoard.getSnakeCount();
		for(int i = 0; i < count; i++){
			snakeList.add(new Snake(new Position(i+30),new Position(i+5)));			
		}
		myBoard.setSnakeList(snakeList);
		for(int i = 0; i < myBoard.getSnakeCount(); i++){
			assertTrue(myBoard.getSnakeList().get(i).getHeadValue()==(i+30));
			assertTrue(myBoard.getSnakeList().get(i).getTailValue()==(i+5));	
		}
		assertTrue(count==myBoard.getSnakeCount());
	}
	
	@Test
	public void testGetLadderList() throws SnakeAndLadderException {
		Board myBoard = Board.getInstance();	
		myBoard.setSnakeLaddetCount();
		myBoard.getLadderList().clear();
		List<Ladder> ladderList = new ArrayList<Ladder>();
		int count = myBoard.getLadderCount();
		for(int i = 0; i < myBoard.getLadderCount() ; i++){
			ladderList.add(new Ladder(new Position(i+30),new Position(i+5)));			
		}
		myBoard.setLadderList(ladderList);
		for(int i = 0; i < myBoard.getLadderList().size(); i++){
			assertTrue(myBoard.getLadderList().get(i).getHeadValue()==i+30);
			assertTrue(myBoard.getLadderList().get(i).getTailValue()==i+5);	
		}
		assertTrue(count==myBoard.getLadderList().size());	
	}
	
	@Test
	public void testSetLadderList() throws SnakeAndLadderException {
		Board myBoard = Board.getInstance();	
		myBoard.setSnakeLaddetCount();
		myBoard.getLadderList().clear();
		List<Ladder> ladderList = new ArrayList<Ladder>();
		int count = myBoard.getLadderCount();
		for(int i = 0; i < myBoard.getLadderCount() ; i++){
			ladderList.add(new Ladder(new Position(i+30),new Position(i+5)));			
		}
		myBoard.setLadderList(ladderList);
		for(int i = 0; i < myBoard.getLadderList().size(); i++){
			assertTrue(myBoard.getLadderList().get(i).getHeadValue()==i+30);
			assertTrue(myBoard.getLadderList().get(i).getTailValue()==i+5);	
		}
		assertTrue(count==myBoard.getLadderList().size());	
	}
	
	@Test
	public void testGenerateCriticalPositions() throws SnakeAndLadderException {
		Board myBoard = Board.getInstance();	
		myBoard.setSnakeLaddetCount();
		List<Position> positionList = myBoard.generateCriticalPositions();
		Integer[] positionArray = new Integer[positionList.size()];
		for(int i = 0; i<positionList.size();i++){
			positionArray[i] = positionList.get(i).getValue();
		}
		Arrays.sort(positionArray);
		assertTrue(positionArray.length==positionList.size());
		for(int i=0; i<positionArray.length-1; i++){
			assertTrue(positionArray[i]!=positionArray[i+1]);
			assertTrue(positionArray[i]!=0);
			assertTrue(positionArray[i]!=1);
			assertTrue(positionArray[i]!=Board.getSizeOfBoard());		
		}		
	}
	
	
}
