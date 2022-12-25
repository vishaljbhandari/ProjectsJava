package snake_ladder;

public class Dice{
	private int value = 1;
	private static int diceRange = 6;
	
	public Dice() {
		super();
		this.value = 1;
	}	
	
	public Dice(int value) throws SnakeAndLadderException {
		super();
	    if (value < 1  || value > Dice.diceRange) 
	        throw new SnakeAndLadderException("An Snake And Ladder Exception : Invalid Dice Value, Must Be A Non Zero Number Between 1 - " + Dice.diceRange);
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
	public void setValue(int value) throws SnakeAndLadderException {
	    if (value < 1  || value > Dice.diceRange) 
	        throw new SnakeAndLadderException("An Snake And Ladder Exception : Invalid Dice Value, Must Be A Non Zero Number Between 1 - " + Dice.diceRange);
		this.value = value;
	}	
	
	public static int getDiceRange() {
		return diceRange;
	}

	public static void setDiceRange(int diceRange) throws SnakeAndLadderException {
	    if ( diceRange < 6  || diceRange > (int) (Board.getSizeOfBoard() * 0.25f )) 
	        throw new SnakeAndLadderException("An Snake And Ladder Exception : Dice Range can't be less than 6 and more than " + (int) (Board.getSizeOfBoard() * 0.25f ) );
		Dice.diceRange = diceRange;
	}

	public void rollDice(){
		int val = 1 + (int)(Math.random()*( Dice.diceRange ));
		this.value = val < 1 ? 1 : val > Dice.diceRange ? Dice.diceRange : val ;
		
	}	
	
}
