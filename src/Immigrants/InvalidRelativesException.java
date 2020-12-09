package Immigrants;

public class InvalidRelativesException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public InvalidRelativesException(int amount) {
		super("The relatives cannot be more than " +amount +"!");
	}

}
