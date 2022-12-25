package snake_ladder;

public class Player{
	private String playerName = new String("Default Player");
	private int playerId = 0;
	private boolean isWon = false;
	private Position playerPosition = new Position(0);
	
	public Player() throws SnakeAndLadderException {
		super();
		this.playerId = 0;
		this.playerName = new String("Default Player");
		this.isWon = false;
		this.playerPosition = new Position(0);
	}
	
	public Player(int playerId, String playerName) throws SnakeAndLadderException {
		super();
		this.playerId = playerId;
		this.playerName = playerName;
		this.isWon = false;
		this.playerPosition = new Position(0);
	}
	
	public String getPlayerName() {
		return playerName;
	}
	
	public void displayPlayer(Player player){
		System.out.println("Player ID : " + player.getPlayerId() + ", Name : " + player.getPlayerName() + ", Position : " + player.getPlayerPositionValue() + ", Win? : " + player.isWon());
	}
	
	public void displayPlayer(){
		System.out.println("Player ID : " + this.getPlayerId() + ", Name : " + this.getPlayerName() + ", Position : " + this.getPlayerPositionValue() + ", Win? : " + (this.isWon() == true ? "Yes" : "No"));
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	
	public Position getPlayerPosition() {
		return playerPosition;
	}
	
	public int getPlayerPositionValue() {
		return playerPosition.getValue();
	}
	
	public void setPlayerPosition(Position playerPosition) throws SnakeAndLadderException {
		this.playerPosition.setValue(playerPosition.getValue());
	}
	
	public void setPlayerPositionValue(int position) throws SnakeAndLadderException {
		this.playerPosition.setValue(position);
	}
	
	public int getPlayerId() {
		return playerId;
	}
	
	public void setPlayerId(int playerId) {		
		this.playerId = playerId;
	}
	
	public boolean isWon() {
		return isWon;
	}
	
	public void setWon(boolean isWon) {
		this.isWon = isWon;
	}
	
	public void snakeBite(Position playerPosition) throws SnakeAndLadderException {
		this.playerPosition.setValue(playerPosition.getValue());
	}
	
	public void ladderLead(Position playerPosition) throws SnakeAndLadderException {
		this.playerPosition.setValue(playerPosition.getValue());
	}
	
}
