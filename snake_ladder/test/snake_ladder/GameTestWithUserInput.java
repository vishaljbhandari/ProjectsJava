package snake_ladder;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class GameTestWithUserInput {

	
	@Test
	public void testGatherPlayers() throws SnakeAndLadderException {
		Game myGame = Game.getInstance();	
		myGame.setPlayerCount(1);
		List<Player> myPlayerList = myGame.gatherPlayers();
		/*
		 	ID 	:	0	
		 Name	:	vishal

		 */
		assertTrue(myPlayerList.get(myPlayerList.size()-1).getPlayerName()=="vishal");
		assertTrue(myPlayerList.get(myPlayerList.size()-1).getPlayerId()==1);
		assertTrue(myPlayerList.get(myPlayerList.size()-1).isWon()==false);
	}
	
	
	
	@Test
	public void testTakeInputOfNumberOfPlayers() throws SnakeAndLadderException {
		Game myGame = Game.getInstance();
		
		//Input Values :  1
		//Input Values :  2
		//Input Values :  0
		//Input Values :  50
		//Input Values :  51
		//Input Values :  String		
		myGame.takeInputOfNumberOfPlayers();
		assertTrue(myGame.getPlayerCount()==2);
	}
	
	@Test
	public void testTakeInputOfDiceRange() throws SnakeAndLadderException {
		Game myGame = Game.getInstance();
		Board.setBoardDimension(10);
		//Input Values :  (int) (100 * 0.25f ) : 25
		//Input Values :  26
		//Input Values :  1
		//Input Values :  -1
		//Input Values :  6
		//Input Values :  5
		//Input Values :  String		
		myGame.takeInputOfDiceRange();
		assertTrue(Dice.getDiceRange()==25);
	}
	
	@Test
	public void testTakeIntegerInputWhenStringInput() throws SnakeAndLadderException {
		Game myGame = Game.getInstance();
		assertTrue(myGame.takeIntegerInput()==0);
	}
	
	@Test
	public void testTakeIntegerInputWhenNegativeNumber() throws SnakeAndLadderException {
		Game myGame = Game.getInstance();
		assertTrue(myGame.takeIntegerInput()==-1);
	}

	@Test
	public void testTakeIntegerInputWhenPositiveNumber() throws SnakeAndLadderException {
		Game myGame = Game.getInstance();
		assertTrue(myGame.takeIntegerInput()==1);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
