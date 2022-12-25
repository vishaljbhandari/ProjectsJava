package snake_ladder;

import static org.junit.Assert.*;

import org.junit.Test;

public class PlayerTest {

	@Test
	public void testPlayer() throws SnakeAndLadderException {
		Player player = new Player();
		String str = new String("Default Player");
		assertTrue(player.getPlayerId()==0);
		assertTrue(player.isWon()==false);
		assertTrue(player.getPlayerPosition().getValue()==0);
	    assertEquals("Result", str, player.getPlayerName());	
	}

	@Test
	public void testPlayerIntString() throws SnakeAndLadderException {
		int id = 5;
		String str = new String("Hello");
		Player player = new Player(id, str);
		assertTrue(player.getPlayerId()==id);
		assertTrue(player.isWon()==false);
		assertTrue(player.getPlayerPosition().getValue()==0);
		assertTrue(player.getPlayerName()==str);	
	}

	@Test
	public void testGetPlayerName() throws SnakeAndLadderException {
		int id = 5;
		String str = new String("Hello");
		Player player = new Player(id, str);
	    assertEquals("Result", str, player.getPlayerName());
	}
	
	/*
	// No Need
	@Test
	public void testDisplayPlayerPlayer() {
		fail("Not yet implemented");
	}

	// No Need
	@Test
	public void testDisplayPlayer() {
		fail("Not yet implemented");
	}
	*/
	
	@Test
	public void testSetPlayerName() throws SnakeAndLadderException {
		String str = new String("Hello");
		Player player = new Player();
		player.setPlayerName(str);
	    assertEquals("Result", str, player.getPlayerName());
	}

	@Test
	public void testGetPlayerPosition() throws SnakeAndLadderException {
		Player player = new Player();
		assertTrue(player.getPlayerPosition().getValue()==0);
	}

	@Test
	public void testGetPlayerPositionValue() throws SnakeAndLadderException {
		Player player = new Player();
		assertTrue(player.getPlayerPositionValue()==0);
	}

	@Test
	public void testSetPlayerPosition() throws SnakeAndLadderException {
		int pos = 5;
		Player player = new Player();
		player.setPlayerPosition(new Position(pos));
		assertTrue(player.getPlayerPositionValue()==pos);
	}

	@Test
	public void testSetPlayerPositionValue() throws SnakeAndLadderException {
		int pos = 5;
		Player player = new Player();
		player.setPlayerPositionValue(pos);
		assertTrue(player.getPlayerPositionValue()==pos);
	}

	@Test
	public void testGetPlayerId() throws SnakeAndLadderException {
		int id = 5;
		Player player = new Player(id, new String("Hello"));
		assertTrue(player.getPlayerId()==id);
	}

	@Test
	public void testSetPlayerId() throws SnakeAndLadderException {
		int id = 5;
		Player player = new Player(id, new String("Hello"));
		id++;
		player.setPlayerId(id);
		assertTrue(player.getPlayerId()==id);
	}

	@Test
	public void testIsWonFalse() throws SnakeAndLadderException {
		Player player = new Player();
		assertTrue(player.isWon()==false);
	}

	@Test
	public void testIsWonTrue() throws SnakeAndLadderException {
		Player player = new Player();
		player.setWon(true);
		assertTrue(player.isWon()==true);
	}

	@Test
	public void testSetWonTrue() throws SnakeAndLadderException {
		Player player = new Player();
		player.setWon(true);
		assertTrue(player.isWon()==true);
	}

	@Test
	public void testSetWonFalse() throws SnakeAndLadderException {
		Player player = new Player();
		player.setWon(false);
		assertTrue(player.isWon()==false);
	}

	@Test
	public void testSnakeBite() throws SnakeAndLadderException {
		Player player = new Player();
		player.setPlayerPositionValue(10);
		Position pos = new Position(5);
		player.snakeBite(pos);
		assertTrue(pos.equalPositions(player.getPlayerPosition()));
	}

	@Test
	public void testLadderLead() throws SnakeAndLadderException {
		Player player = new Player();
		player.setPlayerPositionValue(10);
		Position pos = new Position(15);
		player.ladderLead(pos);
		assertTrue(pos.equalPositions(player.getPlayerPosition()));
	}

	@Test
	public void testLadderLeadToMacPosition() throws SnakeAndLadderException {
		int dim = 10;
		Board.setBoardDimension(dim);
		Player player = new Player();
		player.setPlayerPositionValue(10);
		Position pos = new Position(Board.getSizeOfBoard());
		player.ladderLead(pos);
		assertTrue(pos.equalPositions(player.getPlayerPosition()));
	}
}
