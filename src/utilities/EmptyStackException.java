package utilities;

public class EmptyStackException extends Exception {
	/**
	 * This is the main constructor for
	 * the exception.
	 */
	public EmptyStackException(){}
	/**
	 * This is the Main Constructor that sends
	 * the message to the exception class.
	 * @param msg is the string message being passed
	 */
	public EmptyStackException(String msg){
		super(msg);
	}
}
