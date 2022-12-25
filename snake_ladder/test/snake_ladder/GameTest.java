package snake_ladder;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class GameTest {	

	@Test
	public void testGame() throws SnakeAndLadderException {
		Game myGame = Game.getInstance();		
		assertTrue(Game.getInstance()!=null);
		assertTrue(myGame.getPlayerCount()==2);
		assertTrue(myGame.isFinished()==false);	
	}

	@Test
	public void testGetInstance() throws SnakeAndLadderException {
		Game myGame = Game.getInstance();		
		assertTrue(myGame.getClass()==Game.class);
		assertTrue(myGame instanceof Game == true);		
	}

	@Test
	public void testIsWonWhenNoOneWonCaseOne() throws SnakeAndLadderException {
		Game myGame = Game.getInstance();
		Board.setBoardDimension(10);
		Player player = new Player(Board.getSizeOfBoard()-1, new String("vishal"));
		assertTrue(myGame.isWon(player)==false);
	}

	@Test
	public void testIsWonWhenNoOneWonCaseTwo() throws SnakeAndLadderException {
		Game myGame = Game.getInstance();
		Board.setBoardDimension(10);
		Player player = new Player(1, new String("vishal"));
		player.setPlayerPositionValue(Board.getSizeOfBoard()-1);
		assertTrue(myGame.isWon(player)==false);
	}

	
	@Test
	public void testIsWonWhenOneWon() throws SnakeAndLadderException {
		Game myGame = Game.getInstance();
		Board.setBoardDimension(10);
		Player player = new Player(1, new String("vishal"));
		player.setPlayerPositionValue(Board.getSizeOfBoard());
		assertTrue(myGame.isWon(player)==true);
	}
	
	@Test
	public void testLeadGainer() throws SnakeAndLadderException {
		Game myGame = Game.getInstance();
		List<Player> playerList = new ArrayList<Player>();
		Player player = new Player(25, new String("Vishal"));
		player.setPlayerPositionValue(20);
		playerList.add(player);
		myGame.setPlayerList(playerList);
		Ladder ladder = new Ladder(new Position(50),new Position(20));
		myGame.leadGainer(myGame.getPlayerList().get(myGame.getPlayerList().size()-1), ladder);
		assertTrue(myGame.getPlayerList().get(myGame.getPlayerList().size()-1).getPlayerPositionValue()==50);
	}

	@Test
	public void testIsLeadPositionWhenNoLead() throws SnakeAndLadderException {
		Game myGame = Game.getInstance();
		Board myBoard = Board.getInstance();
		myBoard.getLadderList().add(new Ladder(new Position(10), new Position(5)));
		myBoard.getLadderList().add(new Ladder(new Position(15), new Position(3)));
		myBoard.getLadderList().add(new Ladder(new Position(19), new Position(14)));
		myBoard.getLadderList().add(new Ladder(new Position(80), new Position(7)));
		myBoard.getLadderList().add(new Ladder(new Position(50), new Position(25)));
		myGame.setMyBoard(myBoard);
		assertTrue(myGame.isLead(new Position(37))==false);
		assertTrue(myGame.isLead(new Position(87))==false);
		assertTrue(myGame.isLead(new Position(77))==false);
		assertTrue(myGame.isLead(new Position(57))==false);
		assertTrue(myGame.isLead(new Position(47))==false);		
	}
	
	@Test
	public void testIsLeadPositionWhenLead() throws SnakeAndLadderException {
		Game myGame = Game.getInstance();
		//Ladders Already Added In Previous Function
		assertTrue(myGame.isLead(new Position(5))==true);
		assertTrue(myGame.isLead(new Position(3))==true);
		assertTrue(myGame.isLead(new Position(14))==true);
		assertTrue(myGame.isLead(new Position(25))==true);
	}
	
	@Test
	public void testwhoLeadWhenLead() throws SnakeAndLadderException {
		Game myGame = Game.getInstance();
		assertTrue(myGame.whoLead(new Position(5))==0);
		assertTrue(myGame.whoLead(new Position(3))==1);
		assertTrue(myGame.whoLead(new Position(14))==2);
		assertTrue(myGame.whoLead(new Position(7))==3);
		assertTrue(myGame.whoLead(new Position(25))==4);
	}
	
	@Test
	public void testwhoLeadWhenNoOneLead() throws SnakeAndLadderException {
		Game myGame = Game.getInstance();
		assertTrue(myGame.whoLead(new Position(16))==-1);
		assertTrue(myGame.whoLead(new Position(75))==-1);
		assertTrue(myGame.whoLead(new Position(35))==-1);
		assertTrue(myGame.whoLead(new Position(24))==-1);
		assertTrue(myGame.whoLead(new Position(84))==-1);
	}

	@Test
	public void testBiteVictim() throws SnakeAndLadderException {
		Game myGame = Game.getInstance();
		List<Player> playerList = new ArrayList<Player>();
		Player player = new Player(25, new String("Vishal"));
		player.setPlayerPositionValue(50);
		playerList.add(player);
		myGame.setPlayerList(playerList);
		Snake snake = new Snake(new Position(50),new Position(20));
		myGame.biteVictim(myGame.getPlayerList().get(myGame.getPlayerList().size()-1), snake);
		assertTrue(myGame.getPlayerList().get(myGame.getPlayerList().size()-1).getPlayerPositionValue()==20);
	}

	@Test
	public void testIsBitePositionWhenNoBite() throws SnakeAndLadderException {
		Game myGame = Game.getInstance();
		Board myBoard = Board.getInstance();
		myBoard.getSnakeList().add(new Snake(new Position(10), new Position(5)));
		myBoard.getSnakeList().add(new Snake(new Position(15), new Position(3)));
		myBoard.getSnakeList().add(new Snake(new Position(19), new Position(14)));
		myBoard.getSnakeList().add(new Snake(new Position(80), new Position(7)));
		myBoard.getSnakeList().add(new Snake(new Position(50), new Position(25)));
		myGame.setMyBoard(myBoard);
		assertTrue(myGame.isBite(new Position(37))==false);
		assertTrue(myGame.isBite(new Position(87))==false);
		assertTrue(myGame.isBite(new Position(77))==false);
		assertTrue(myGame.isBite(new Position(57))==false);
		assertTrue(myGame.isBite(new Position(47))==false);		
	}
	
	@Test
	public void testIsBitePositionWhenBite() throws SnakeAndLadderException {
		Game myGame = Game.getInstance();
		//Snakes Already Added In Previous Function
		assertTrue(myGame.isBite(new Position(80))==true);
		assertTrue(myGame.isBite(new Position(10))==true);
		assertTrue(myGame.isBite(new Position(19))==true);
		assertTrue(myGame.isBite(new Position(50))==true);
		assertTrue(myGame.isBite(new Position(15))==true);
		
	}
	
	@Test
	public void testwhoBiteWhenBite() throws SnakeAndLadderException {
		Game myGame = Game.getInstance();
		assertTrue(myGame.whoBite(new Position(10))==0);
		assertTrue(myGame.whoBite(new Position(15))==1);
		assertTrue(myGame.whoBite(new Position(19))==2);
		assertTrue(myGame.whoBite(new Position(80))==3);
		assertTrue(myGame.whoBite(new Position(50))==4);
	}
	
	@Test
	public void testwhoBiteWhenNoOneBite() throws SnakeAndLadderException {
		Game myGame = Game.getInstance();
		assertTrue(myGame.whoBite(new Position(18))==-1);
		assertTrue(myGame.whoBite(new Position(24))==-1);
		assertTrue(myGame.whoBite(new Position(65))==-1);
		assertTrue(myGame.whoBite(new Position(78))==-1);
	}

	@Test
	public void testSetPlayerList() throws SnakeAndLadderException {
		Game myGame = Game.getInstance();
		List<Player> playerList = new ArrayList<Player>();
		playerList.add(new Player());
		myGame.setPlayerList(playerList);
		assertTrue(myGame.getPlayerList().size()==1);
		myGame.getPlayerList().remove(0);
		assertTrue(myGame.getPlayerList().size()==0);		
	}
	
	@Test
	public void testGetPlayerList() throws SnakeAndLadderException {
		Game myGame = Game.getInstance();
		assertTrue(myGame.getPlayerList().size()==0);
		myGame.getPlayerList().add(new Player());
		assertTrue(myGame.getPlayerList().size()==1);
		myGame.getPlayerList().remove(0);
		assertTrue(myGame.getPlayerList().size()==0);		
	}

	@Test
	public void testSetFinished() throws SnakeAndLadderException {
		Game myGame = Game.getInstance();
		myGame.setFinished(true);
		assertTrue(myGame.isFinished()==true);
		myGame.setFinished(false); // Reset For further Tests		
	}

	@Test
	public void testIsFinised() throws SnakeAndLadderException {
		Game myGame = Game.getInstance();
		assertTrue(myGame.isFinished()==false);	
	}
		
	@Test
	public void testSetPlayerCount() throws SnakeAndLadderException {
		Game myGame = Game.getInstance();
		myGame.setPlayerCount(5);
		assertTrue(myGame.getPlayerCount()==5);	
	}
		
	@Test
	public void testGetPlayerCount() throws SnakeAndLadderException {
		Game myGame = Game.getInstance();
		assertTrue(myGame.getPlayerCount()==5);	
	}

	@Test
	public void testSetMyDice() throws SnakeAndLadderException {
		Game.setMyDice(new Dice(5));
		assertTrue(Game.getMyDice().getValue()==5);	
	}
		
	@Test
	public void testGetMyDice() throws SnakeAndLadderException {
		assertTrue(Game.getMyDice().getValue()==5);	
	}
	
	@Test
	public void testsetMyBoardBoard() throws SnakeAndLadderException {
		Game myGame = Game.getInstance();
		myGame.setMyBoard(Board.getInstance());
		assertTrue(myGame.getMyBoard().getSnakeCount()==5);	
		assertTrue(myGame.getMyBoard().getLadderCount()==5);		
	}

	@Test
	public void testGetMyBoard() throws SnakeAndLadderException {
		Game myGame = Game.getInstance();
		assertTrue(myGame.getMyBoard().getSnakeCount()==5);	
	}
	
	
	@Test
	public void testMakeLead() throws SnakeAndLadderException {
		Game myGame = Game.getInstance();
		List<Ladder> ladderList = new ArrayList<Ladder>();
		int ladderHead = 50;
		int ladderTail = 25;
		ladderList.add(new Ladder(new Position(ladderHead), new Position(ladderTail)));
		myGame.getMyBoard().setLadderList(ladderList);
		List<Player> playerList = new ArrayList<Player>();
		playerList.add(new Player());
		myGame.setPlayerCount(playerList.size());
		myGame.setPlayerList(playerList);
		int newPosition = ladderTail;
		myGame.getPlayerList().get(myGame.getPlayerList().size()-1).setPlayerPositionValue(newPosition);
		int player = myGame.getPlayerList().size()-1;
		myGame.makeLead(player, newPosition);
		assertTrue(myGame.getPlayerList().get(player).getPlayerPositionValue()==ladderHead);	
	}
	
	@Test
	public void testMakeBite() throws SnakeAndLadderException {
		Game myGame = Game.getInstance();
		List<Snake> snakeList = new ArrayList<Snake>();
		int snakeHead = 50;
		int snakeTail = 25;
		snakeList.add(new Snake(new Position(snakeHead), new Position(snakeTail)));
		myGame.getMyBoard().setSnakeList(snakeList);
		List<Player> playerList = new ArrayList<Player>();
		playerList.add(new Player());
		myGame.setPlayerCount(playerList.size());
		myGame.setPlayerList(playerList);
		int newPosition = snakeHead;
		myGame.getPlayerList().get(myGame.getPlayerList().size()-1).setPlayerPositionValue(newPosition);
		int player = myGame.getPlayerList().size()-1;
		myGame.makeBite(player, newPosition);
		assertTrue(myGame.getPlayerList().get(player).getPlayerPositionValue()==snakeTail);	
	}
	
	@Test
	public void testFindWinnerWhenSomeOneWon() throws SnakeAndLadderException {
		Game myGame = Game.getInstance();
		List<Player> playerList = new ArrayList<Player>();
		playerList.add(new Player());
		playerList.add(new Player());
		playerList.add(new Player());
		playerList.add(new Player());
		playerList.get(2).setPlayerId(12);		
		playerList.get(2).setPlayerName(new String("vishal"));
		playerList.get(2).setPlayerPositionValue(Board.getSizeOfBoard());
		playerList.get(2).setWon(true);
		myGame.setPlayerCount(playerList.size());
		myGame.setPlayerList(playerList);
		Player player = myGame.findWinner();
		assertTrue(player.getPlayerName().equalsIgnoreCase(new String("vishal")));
		assertTrue(player.getPlayerPositionValue()==Board.getSizeOfBoard());
		assertTrue(player.isWon()==true);
		assertTrue(player.getPlayerId()==12);		
	}
	
	@Test
	public void testFindWinnerWhenNoOneWon() throws SnakeAndLadderException {
		Game myGame = Game.getInstance();
		List<Player> playerList = new ArrayList<Player>();
		playerList.add(new Player());
		playerList.add(new Player());
		playerList.add(new Player());
		playerList.add(new Player());
		playerList.get(2).setPlayerId(12);		
		playerList.get(2).setPlayerName(new String("vishal"));
		playerList.get(2).setPlayerPositionValue(Board.getSizeOfBoard());
		myGame.setPlayerCount(playerList.size());
		myGame.setPlayerList(playerList);
		Player player = myGame.findWinner();
		assertTrue(player==null);		
	}
	
	@Test
	public void testSetPlayerNewPosition() throws SnakeAndLadderException {
		Game myGame = Game.getInstance();
		List<Player> playerList = new ArrayList<Player>();
		playerList.add(new Player());
		myGame.setPlayerCount(playerList.size());
		myGame.setPlayerList(playerList);
		myGame.getPlayerList().get(myGame.getPlayerList().size()-1).setPlayerPositionValue(5);
		int newPos = 10;
		int player = myGame.getPlayerList().size()-1;
		myGame.setPlayerNewPosition(player, newPos);		
		assertTrue(myGame.getPlayerList().get(player).getPlayerPositionValue()==10);
	}
	
	@Test
	public void testGetChangedPlayerPositionInNextMove() throws SnakeAndLadderException {
		Game myGame = Game.getInstance();
		List<Player> playerList = new ArrayList<Player>();
		playerList.add(new Player());
		myGame.setPlayerCount(playerList.size());
		myGame.setPlayerList(playerList);
		myGame.getPlayerList().get(myGame.getPlayerList().size()-1).setPlayerPositionValue(5);
		Game.getMyDice().rollDice();
		int diceValue = Game.getMyDice().getValue();	
		int player = myGame.getPlayerList().size()-1;		
		int newPos = diceValue + 5;	
		assertTrue(myGame.getChangedPlayerPositionInNextMove(player)==newPos);
	}	
	
	@Test
	public void testMakeFinish() throws SnakeAndLadderException {
		Game myGame = Game.getInstance();
		List<Player> playerList = new ArrayList<Player>();
		playerList.add(new Player());
		myGame.setPlayerCount(playerList.size());
		myGame.setPlayerList(playerList);
		myGame.getPlayerList().get(myGame.getPlayerList().size()-1).setPlayerPositionValue(95);
		Game.getMyDice().setValue(5);
		int diceValue = Game.getMyDice().getValue();	
		int player = myGame.getPlayerList().size()-1;
		int newPos = diceValue + myGame.getPlayerList().get(player).getPlayerPositionValue();
		myGame.setPlayerNewPosition(player, newPos);
		assertTrue(myGame.isWon(myGame.getPlayerList().get(player))==true);
		myGame.getPlayerList().get(player).setWon(myGame.isWon(myGame.getPlayerList().get(player)));
		assertTrue(myGame.getPlayerList().get(player).isWon()==true);		
	}	
	

	
}
