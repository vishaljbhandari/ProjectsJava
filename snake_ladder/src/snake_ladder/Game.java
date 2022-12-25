package snake_ladder;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Game{
	private static Game instance = null;
	private static Dice myDice = new Dice();
	private int playerCount = 2;
	private List<Player> playerList = new ArrayList<Player>();
	private boolean isFinished = false;
	private Board myBoard  = null;
	
	protected Game() throws SnakeAndLadderException {		 //Tested
		Game.instance = null;
		Game.myDice = new Dice(1);
		this.playerCount = 2;
		this.playerList = new ArrayList<Player>();
		this.isFinished = false;
		this.myBoard  = null;
	}
	
	public static synchronized Game getInstance() throws SnakeAndLadderException { //Tested
		if(instance == null) {
			instance = new Game();
		}
		return instance;
	}	
	
	public Board getMyBoard() { //Tested
		return this.myBoard;
	}
	
	public void setMyBoard(Board myBoard) { //Tested
		this.myBoard = myBoard;
	}
	
	public static Dice getMyDice() { //Tested
		return Game.myDice;
	}
	
	public static void setMyDice(Dice myDice) { //Tested
		Game.myDice = myDice;
	}
	
	public int getPlayerCount() { //Tested
		return playerCount;
	}
	
	public void setPlayerCount(int playerCount) { //Tested
		this.playerCount = playerCount;
	}
	
	public boolean isFinished() { //Tested
		return isFinished;
	}
	
	public void setFinished(boolean isFinished) { //Tested
		this.isFinished = isFinished;
	}	
	
	public List<Player> getPlayerList() { //Tested
		return playerList;
	}
	
	public void setPlayerList(List<Player> playerList) { //Tested
		this.playerList = playerList;
	}
	
	public boolean isBite(Position position){ //Tested
		List<Snake> snakeList = this.getMyBoard().getSnakeList();
		for( int i = 0; i < snakeList.size(); i++){
			if(snakeList.get(i).isBite(position)==true )
				return true;
		}
		return false;
	}

	public int whoBite(Position position){ //Tested
		List<Snake> snakeList = this.getMyBoard().getSnakeList();
		for( int i = 0; i < snakeList.size(); i++){
			if(snakeList.get(i).isBite(position)==true )
				return i;
		}
		return -1;
	}
	
	public void biteVictim(Player player, Snake snake) throws SnakeAndLadderException{ //Tested
		player.snakeBite(snake.snakeBite());		
	}
	
	public boolean isLead(Position position){ //Tested
		List<Ladder> ladderList = this.getMyBoard().getLadderList();
		for( int i = 0; i < ladderList.size(); i++){
			if(ladderList.get(i).isLead(position)==true )
				return true;
		}
		return false;
	}

	public int whoLead(Position position){ //Tested
		List<Ladder> ladderList = this.getMyBoard().getLadderList();
		for( int i = 0; i < ladderList.size(); i++){
			if(ladderList.get(i).isLead(position)==true )
				return i;
		}
		return -1;
	}
	
	public void leadGainer(Player player, Ladder ladder) throws SnakeAndLadderException{ //Tested
		player.ladderLead(ladder.ladderLead());		
	}
	
	public List<Player> gatherPlayers() throws SnakeAndLadderException{  //Tested
		List<Player> myPlayerList = new ArrayList<Player>();
		this.printBlocks(3);
		for(int i = 0; i < this.getPlayerCount(); i++){
			Player player = new Player();
			player.setPlayerId(i);
			System.out.print("Player ID : " + player.getPlayerId() + ", Enter Player Name : ");
			Scanner user_input = new Scanner( System.in );
			String first_name;
			first_name = user_input.next( );
			player.setPlayerName(first_name.trim());		
			myPlayerList.add(player);
		}
		return myPlayerList;	
	}
	
	public void displayPlayers(List<Player> playerList){  //Tested
		for(int i = 0 ; i < playerList.size() ; i++)
			playerList.get(i).displayPlayer();		
	}
	
	public boolean isWon(Player player){ //Tested
		if(player.getPlayerPositionValue() == Board.getSizeOfBoard())
			return true;
		return false;
	}
	
	public int takeIntegerInput(){ //Tested
		int inputValue = 0;
		Scanner user_input = new Scanner( System.in );
		boolean doFinaly = false;
        try{
        	inputValue = user_input.nextInt();
        }
        catch(InputMismatchException e){
        	inputValue = 0;
        	doFinaly = true;
        }	
        finally{
        	if(doFinaly == true)
        		return 0;
        }
        return inputValue;
	}
	
	public void takeInputOfDiceRange() throws SnakeAndLadderException{ //Tested
		int maxDiceRange = (int) (Board.getSizeOfBoard() * 0.25f );
		int InputOfMaxDiceRange = 0;
		boolean lastFlag = false;
		do{	
			if(lastFlag==true) System.out.print("Invalid Input, Enter Again, ");
			System.out.print("Input: ");
	        	InputOfMaxDiceRange =  this.takeIntegerInput();
			InputOfMaxDiceRange = (int) Math.floor(InputOfMaxDiceRange);
			if(InputOfMaxDiceRange<6||InputOfMaxDiceRange>maxDiceRange)
				lastFlag=true;
			else break;
		}while(InputOfMaxDiceRange<6||InputOfMaxDiceRange>maxDiceRange);
		Dice.setDiceRange(InputOfMaxDiceRange);
	}
	
	public void takeInputOfNumberOfPlayers() throws SnakeAndLadderException{ //Tested
		int InputOfPlayerCount = 0;
		boolean lastFlag = false;
		do{	
			if(lastFlag==true) System.out.print("Invalid Input, Enter Again, ");
			System.out.print("Input: ");
	        	InputOfPlayerCount =  this.takeIntegerInput();
			InputOfPlayerCount = (int) Math.floor(InputOfPlayerCount);
			if(InputOfPlayerCount<2||InputOfPlayerCount>50)
				lastFlag=true;
			else break;
		}while(InputOfPlayerCount<2||InputOfPlayerCount>50);
		this.setPlayerCount(InputOfPlayerCount);
	}
	
	//public void printBlocks(int id){}
	public void printBlocks(int id){ //Tested
		switch(id){
			case 1:  	System.out.println("Enter Dice Face Range(Maximum Value That Dice Cant Take), Between 6-" + (int) (Board.getSizeOfBoard() * 0.25f ));
						break;
			case 2: 	System.out.println("Enter Number Of Players, Between 2-50");
						break;
			case 3:		System.out.println("Enter Player Information");
						break;
			case 4:		System.out.println("--------------------------------------------------------------");
						System.out.println("--Game Started---type \"stop\" to stop----Else Anything-------");
						System.out.println("--------------------------------------------------------------");
						break;						
			case 5:		System.out.println("Game Finished\nGame Winner ");						
						break;				
			case 6:		System.out.println("Game Terminated");
						break;				

		}
	}
	
	public void makeGameReady() throws SnakeAndLadderException{		
		setMyBoard(Board.getInstance());		
		Board.getInstance().generateBoard();
		Game.setMyDice(new Dice());
		this.printBlocks(1);
		this.takeInputOfDiceRange();
		this.printBlocks(2);
		this.takeInputOfNumberOfPlayers();
		this.setPlayerList(this.gatherPlayers());
		this.displayPlayers(this.getPlayerList());	
	}
	
	public void makeLead(int player, int newPosition) throws SnakeAndLadderException{ //tested
		System.out.print(", Hurray..!! Ladder Lead, ");
		int whoLead = this.whoLead(new Position(newPosition));
		leadGainer(this.getPlayerList().get(player), this.getMyBoard().getLadderList().get(whoLead));
		System.out.print("New Position: " + this.getPlayerList().get(player).getPlayerPositionValue());
	}
	
	public void makeBite(int player, int newPosition) throws SnakeAndLadderException{ //tested
		System.out.print(", Ouch..!! Snake Bite, ");
		int whoBite = this.whoBite(new Position(newPosition));
		biteVictim(this.getPlayerList().get(player), this.getMyBoard().getSnakeList().get(whoBite));
		System.out.print("New Position: " + this.getPlayerList().get(player).getPlayerPositionValue());
	}
	
	public boolean makeFinish(int player){ //tested
		System.out.print(" Finished..");
		this.getPlayerList().get(player).setWon(this.isWon(this.getPlayerList().get(player))); 				
		return this.getPlayerList().get(player).isWon();
	}
	
	public void printPlayerCurrentState(int player){ //No Need To Test
		System.out.print("\nPlayer Id:" + this.getPlayerList().get(player).getPlayerId() + ", Name: " + this.getPlayerList().get(player).getPlayerName() + ", Old Position: " +  this.getPlayerList().get(player).getPlayerPositionValue());
	}
	
	public int getChangedPlayerPositionInNextMove(int player){ //tested
		return this.getPlayerList().get(player).getPlayerPositionValue() + Game.getMyDice().getValue();
	}
	
	public void setPlayerNewPosition(int player, int newPosition) throws SnakeAndLadderException{ //tested
		this.getPlayerList().get(player).setPlayerPosition(new Position(newPosition));		
	}
	
	public boolean playGame() throws SnakeAndLadderException{
		this.printBlocks(4);
		boolean stopGame = false;
		String continueChoice;	
		Scanner user_input = new Scanner( System.in );		
		int itrationNumber = 1;
		while(!this.isFinished() && !stopGame){
			System.out.println("Iteration: " + itrationNumber + " Press Enter to Continue, Type \"stop\" And Hit Enter to Terminate");			
			for( int i = 0; i < this.getPlayerCount(); i++){		
				this.printPlayerCurrentState(i);
				Game.getMyDice().rollDice();
				System.out.print(", DiceFace: " + Game.getMyDice().getValue());
				int newPosition = this.getChangedPlayerPositionInNextMove(i);
				if( newPosition <= Board.getSizeOfBoard()){
					this.setPlayerNewPosition(i, newPosition);
					System.out.print(", New Position: " + this.getPlayerList().get(i).getPlayerPositionValue());
					if(newPosition == Board.getSizeOfBoard()){
						stopGame = this.makeFinish(i);
						break;
					}					
					if(this.isBite(new Position(newPosition))){
						this.makeBite(i, newPosition);
					}
					if(this.isLead(new Position(newPosition))){
						this.makeLead(i, newPosition);
					}			
				}else{
					System.out.print(", Out Of Board, No Change, Same Position: " + this.getPlayerList().get(i).getPlayerPositionValue());
				}		
			}
			System.out.println("\n--------------------------------------------------------------");
			continueChoice = user_input.nextLine( );
			if(continueChoice.trim().toLowerCase().equalsIgnoreCase("stop")){
				return false;
			}
			itrationNumber++;
		}
		return true;
	}
	
	public Player findWinner(){ //Tested
		List<Player> playerList = this.getPlayerList();
		for( int i = 0; i < playerList.size(); i++){
			if(playerList.get(i).isWon()==true )
				return playerList.get(i);
		}
		return null;
	}
	
	public static void StartGame() throws SnakeAndLadderException{
		System.out.println("Welcome to Vishal's Snake & Ladder Board...");
		Game myGame = Game.getInstance();
		myGame.makeGameReady();
		boolean completedGame = myGame.playGame();
		if(completedGame == true){
			Player winner = myGame.findWinner();
			myGame.printBlocks(5);
			winner.displayPlayer();
		}else{
			myGame.printBlocks(6);			
		}
	}
	public static void main(String args[]) throws SnakeAndLadderException{
		Game.StartGame();		
	}
}
