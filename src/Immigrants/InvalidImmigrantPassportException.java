package Immigrants;

public class InvalidImmigrantPassportException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public InvalidImmigrantPassportException() {
		super("The passport of the normal immigrant cannot be null!");
	}

}
