package snake_ladder;

public class Position{
	private int value = 0;
	public Position(int value) throws SnakeAndLadderException {
		super();
	    if ( value < 0) {
	        throw new SnakeAndLadderException("An Snake And Ladder Exception : Position can't be Lesser than Zero");
	    }
	    if ( value > Board.getSizeOfBoard()) {
	        throw new SnakeAndLadderException("An Snake And Ladder Exception : Position can't be greater than " + Board.getSizeOfBoard());
	    }
		this.value = value;
	}
	public Position() {
		super();
		this.value = 0;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) throws SnakeAndLadderException {
	    if ( value < 0) {
	        throw new SnakeAndLadderException("An Snake And Ladder Exception : Position can't be Lesser than Zero");
	    }
	    if ( value > Board.getSizeOfBoard()) {
	        throw new SnakeAndLadderException("An Snake And Ladder Exception : Position can't be greater than " + Board.getSizeOfBoard());
	    }
		this.value = value;
	}

	public boolean equalPositions(Position position){
		return this.value == position.getValue() ? true : false ;
	}
	
	
	
	
}
