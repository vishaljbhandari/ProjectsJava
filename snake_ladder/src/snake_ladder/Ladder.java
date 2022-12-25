package snake_ladder;

public class Ladder{
	private Position head = new Position(2);
	private Position tail = new Position(1);
	public Ladder(Position head, Position tail) throws SnakeAndLadderException {
		super();
	    if (head.getValue() <= tail.getValue()) {
	        throw new SnakeAndLadderException("An Snake And Ladder Exception : Ladder Tail can't be greater than Head");
	    }
	    if (head.getValue() == 0 || head.getValue() == 1 || head.getValue() == Board.getSizeOfBoard()) {
	        throw new SnakeAndLadderException("An Snake And Ladder Exception : Ladder Head can't be 0, 1, " + Board.getSizeOfBoard());
	    }
	    if(tail.getValue() == 0 || tail.getValue() == Board.getSizeOfBoard() || tail.getValue() == Board.getSizeOfBoard() - 1) {
	        throw new SnakeAndLadderException("An Snake And Ladder Exception : Ladder Tail can't be 0, " + ( Board.getSizeOfBoard() - 1 ) + ", " + Board.getSizeOfBoard());
	    }
		this.head = head;
		this.tail = tail;
	}
	
	public Ladder() throws SnakeAndLadderException {
		super();
		this.head = new Position(Board.getSizeOfBoard() - 1);
		this.tail = new Position(1);
	}
	
	public Position getHead() {
		return head;
	}
	
	public int getHeadValue() {
		return head.getValue();
	}

	public void setHead(Position head) throws SnakeAndLadderException {	 
		int oldHead = this.head.getValue();
		this.head = head;
		boolean isValid = validateLadder();
		if(!isValid){
			this.head.setValue(oldHead);			
			throw new SnakeAndLadderException("An Snake And Ladder Exception : Invalid Ladder");
		}
	}
	
	public void setHeadValue(int head) throws SnakeAndLadderException {
		this.setHead(new Position(head));
	}
	
	public Position getTail() {
		return tail;
	}
	public int getTailValue() {
		return tail.getValue();
	}
	
	public void setTail(Position tail) throws SnakeAndLadderException {
		int oldTail = this.tail.getValue();
		this.tail = tail;
		boolean isValid = validateLadder();
		if(!isValid){
			this.tail.setValue(oldTail);			
			throw new SnakeAndLadderException("An Snake And Ladder Exception : Ladder Tail can't be greater than Head");
		}
	}	
	
	public void setTailValue(int tail) throws SnakeAndLadderException {
		this.setTail(new Position(tail));
	}	
	
	public Position ladderLead(){
		return this.head;
	}
	
	public boolean isLead(Position place){
		if(this.tail.equalPositions(place) == true)
			return true;
		return false;
	}

	public boolean validateLadder() throws SnakeAndLadderException{
	    if (head.getValue() <= tail.getValue()) {
		    return false; 
	    }
	    if (head.getValue() == 0 || head.getValue() == 1 || head.getValue() == Board.getSizeOfBoard()) {
	    	return false; 
	    }
	    if(tail.getValue() == 0 || tail.getValue() == Board.getSizeOfBoard() || tail.getValue() == Board.getSizeOfBoard() - 1) {
	    	return false; 
	    }
	    return true;
	}
	
	
}
