package snake_ladder;

public class SnakeAndLadderException extends Exception
{
	private static final long serialVersionUID = 1L;
	private String ExceptionMessage = null;

	public SnakeAndLadderException() {
		super();
		ExceptionMessage = null;
	}
	
	public SnakeAndLadderException(String exceptionMessage) {
		super();
		ExceptionMessage = exceptionMessage;
	}

	public String getExceptionMessage(){
		return ExceptionMessage;
	}
	
	public void setExceptionMessage(String exceptionMessage) {
		ExceptionMessage = exceptionMessage;
	} 

}