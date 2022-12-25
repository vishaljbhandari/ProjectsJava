package snake_ladder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Board {
	private static Board instance = null;
	private static int boardDimension = 10;
	private static int difficultyLevel = 5;
	private int snakeCount = 5;
	private int ladderCount = 5;
	
	private List<Snake> snakeList = new ArrayList<Snake>();
	private List<Ladder> ladderList = new ArrayList<Ladder>();
	
	protected Board() {
	// Exists only to defeat instantiation.
	}
	
	public static synchronized Board getInstance() { //tested
		if(Board.instance == null) {
			Board.instance = new Board();
		}
		return Board.instance;
	}
	
	public static int getBoardDimension() { //tested
		return Board.boardDimension;
	}
	
	public static int getSizeOfBoard() {  // tested
		return Board.boardDimension * Board.boardDimension;
	}
	
	public static int getDifficultyLevel() {  // tested
		return Board.difficultyLevel;
	}	
	
	public static void setBoardDimension(int boardDimension) throws SnakeAndLadderException {  // tested
	    if (boardDimension < 10  || boardDimension > 50) {
	        throw new SnakeAndLadderException("An Snake And Ladder Exception : Invalid Board Dimension, Must Be A Non Zero Number Between 10 - 50");
	    }
		Board.boardDimension = boardDimension;
	}
	
	public static void setDifficultyLevel(int difficultyLevel) throws SnakeAndLadderException {  // tested
	    if (difficultyLevel < 1 || difficultyLevel > 10) {
	        throw new SnakeAndLadderException("An Snake And Ladder Exception : Invalid Difficulty Level, Must A Non Zero Number Between 1 - 10");
	    }
		Board.difficultyLevel = difficultyLevel;
	}
		
	public int getSnakeCount() {	  // tested	
		return this.snakeCount;
	}
	
	public void setSnakeCount() {  // tested
		int count = (int) Math.floor( Board.getBoardDimension() * ( (float) Board.getDifficultyLevel() / 10 ) );
		this.snakeCount = count == 0 ? 1 : count ;
	}
	
	public int getLadderCount() {  // tested
		return this.ladderCount;
	}
	
	public void setLadderCount() {  // tested
		setSnakeCount();
		int count = Board.boardDimension - this.snakeCount;
		this.ladderCount = count == 0 ? 1 : count ;
	}
	
	public void setSnakeLaddetCount(){  // tested
		this.setSnakeCount();
		this.setLadderCount();
	}

	public int getCriticalPositions() {  // tested      
		return ( this.ladderCount + this.snakeCount ) * 2;
	}
	
	public int getSafeArea() {  // tested
		return  Board.getSizeOfBoard() - this.snakeCount * 2;
	}
	
	public int getCoverArea(){  // tested
		return Board.getSizeOfBoard() - 1 - 1;
	}	
	
	public List<Snake> getSnakeList() { // tested
		return snakeList;
	}
	
	public void setSnakeList(List<Snake> snakeList) { // tested
		this.snakeList = snakeList;
	}
	
	public List<Ladder> getLadderList() { // tested
		return ladderList;
	}
	
	public void setLadderList(List<Ladder> ladderList) {
		this.ladderList = ladderList;
	}
	
	public List<Position> generateCriticalPositions() throws SnakeAndLadderException{ // tested
		int totalCount = this.getCriticalPositions();
		float partitionValue = (float) getCoverArea() / totalCount;	
		List<Position> positionList = new ArrayList<Position>();		
		for(int i = 2, j = 1, nextNum = 2, val = 0 ; nextNum <= Board.getSizeOfBoard() - 1 && j <= totalCount ;  i = nextNum, j++ ){
			if(Board.difficultyLevel==10){
				nextNum = (int) Math.floor((float) i + partitionValue);			
			}else{
				nextNum = (int) Math.ceil((float) i + partitionValue);
			}
			nextNum = nextNum > Board.getSizeOfBoard() - 1 ? Board.getSizeOfBoard() : nextNum;
			val = i + (int)( Math.random()*(nextNum - i) );			
			//System.out.println("Partition " + j + "th : " + i + " - " + ( nextNum - 1) + " Value : " + val);
			positionList.add(new Position(val));
		}
		Collections.shuffle(positionList);
		return positionList;
	}

	List<Snake> generateSnakeList(List<Position> snakePositions) throws SnakeAndLadderException{ // tested
		List<Snake> mySnakeList = new ArrayList<Snake>();
		Collections.shuffle(snakePositions);
		for(int i = 0, head = 0, tail = 0, temp = 0 ; i < ( snakePositions.size()  ) ; i+=2 ){			
			head = snakePositions.get(i).getValue();
			tail = snakePositions.get(i + 1).getValue();
			if(head < tail ) {
				temp = head;
				head = tail;
				tail = temp;
			}			
			mySnakeList.add(new Snake(new Position(head), new Position(tail)));
		}
		return mySnakeList;		
	}
	
	List<Ladder> generateLadderList(List<Position> ladderPositions) throws SnakeAndLadderException{ // tested
		List<Ladder> myLadderList = new ArrayList<Ladder>();
		Collections.shuffle(ladderPositions);
		for(int i = 0, head = 0, tail = 0, temp = 0 ; i < ( ladderPositions.size() ) ; i+=2 ){
			head = ladderPositions.get(i).getValue();
			tail = ladderPositions.get(i + 1).getValue();
			if(head < tail ) {
				temp = head;
				head = tail;
				tail = temp;
			}
			myLadderList.add(new Ladder(new Position(head), new Position(tail)));
		}
		return myLadderList;	
	}
	
	public void printLadderSet(){
		if(this.getLadderList().size()!=0){
			for(int i = 0 ; i < this.getLadderList().size(); i++){
				System.out.println(( i+1 ) + "th, Head: " + this.getLadderList().get(i).getHead().getValue() + ", Tail: " + this.getLadderList().get(i).getTail().getValue());			
			}
		}else{
			System.out.println("No Ladder On The Board");			
		}
	}
	
	public void printSnakeSet(){
		if(this.getSnakeList().size()!=0){
			for(int i = 0 ; i < this.getSnakeList().size(); i++){
				System.out.println(( i+1 ) + "th, Head: " + this.getSnakeList().get(i).getHead().getValue() + ", Tail: " + this.getSnakeList().get(i).getTail().getValue());			
			}	
		}else{
			System.out.println("No Snake On The Board");			
		}
	}
	
	public void printSnakeLadder(){		
		System.out.println("Ladder List-----------------------");
		this.printLadderSet();
		System.out.println("Snake List------------------------");
		this.printSnakeSet();
	}
	
	//public void printBlocks(int id){}
	public void printBlocks(int id){
				switch(id){
			case 1:  	System.out.println("Board Configurations");
						break;
			case 2: 	System.out.println("Enter Dimenesion Of Square Board Between 10-50");
						break;
			case 3:		System.out.println("Enter Difficulty Level Of Game Board Between 1-10");
						System.out.println("More Difficulty Level Means More Snakes and less Ladders, Vise Versa");
			break;
			case 4:		System.out.println("Board Dimension : " + Board.boardDimension + " Size : " + Board.getSizeOfBoard() + " Deficulty Level : " + Board.difficultyLevel);
						System.out.println("Number Of Snakes : " + this.getSnakeCount() + " & Ladders  : " + this.getLadderCount()+ " Present On Board, Critical Positions : " + this.getCriticalPositions());
						break;
				
		}
	}
	
	public int takeIntegerInput(){
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
	
	public void takeInputOfDimension() throws SnakeAndLadderException{
		int InputOfDimension = 0;
		boolean lastFlag = false;
		do{	
			if(lastFlag==true) System.out.print("Invalid Input, Enter Again, ");
			System.out.print("Input: ");
	        	InputOfDimension = this.takeIntegerInput();
			InputOfDimension = (int) Math.floor(InputOfDimension);
			if(InputOfDimension<10||InputOfDimension>50)
				lastFlag=true;
			else break;
		}while(InputOfDimension<10||InputOfDimension>50);
		Board.setBoardDimension(InputOfDimension);
	}
	
	public void takeInputOfDifficultyLevel() throws SnakeAndLadderException{
		int InputOfDifficultyLevel = 0;
		boolean lastFlag = false;
		do{	
			if(lastFlag==true) System.out.print("Invalid Input, Enter Again, ");
			System.out.print("Input: ");
	        	InputOfDifficultyLevel = this.takeIntegerInput();
			InputOfDifficultyLevel = (int) Math.floor(InputOfDifficultyLevel);
			if(InputOfDifficultyLevel<1||InputOfDifficultyLevel>10)
				lastFlag=true;
			else break;
		}while(InputOfDifficultyLevel<1||InputOfDifficultyLevel>10);
		Board.setDifficultyLevel(InputOfDifficultyLevel);
	}
	
	public void generatorSnakeLadder() throws SnakeAndLadderException{
		List<Position> positionList = generateCriticalPositions();
		List<Position> positionListForSnake = positionList.subList(0, this.snakeCount * 2);
		List<Position> positionListForLadder = positionList.subList(this.snakeCount * 2, positionList.size());
		//this.snakeList = this.generateSnakeList(positionListForSnake);		
		//this.ladderList = this.generateLadderList(positionListForLadder);
		this.setSnakeList(this.generateSnakeList(positionListForSnake));		
		this.setLadderList(this.generateLadderList(positionListForLadder));
	}
	
	public Board generateBoard() throws SnakeAndLadderException{ // tested
		this.printBlocks(1);
		this.printBlocks(2);
		takeInputOfDimension();
		this.printBlocks(3);
		takeInputOfDifficultyLevel();
		//Preparing Board
		this.setSnakeLaddetCount();	
		this.printBlocks(4);
		this.generatorSnakeLadder();
		printSnakeLadder();
		return Board.getInstance();
	}	

	public static void main(String args[]) throws SnakeAndLadderException{
		Board myBoard = Board.getInstance();
		myBoard.generateBoard();

	}
}