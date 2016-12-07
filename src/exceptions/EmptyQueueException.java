package exceptions;

public class EmptyQueueException extends Exception {
	/**
	 * This is the main constructor for
	 * the exception.
	 */
	public EmptyQueueException(){}
	/**
	 * This is the Main Constructor that sends
	 * the message to the exception class.
	 * @param msg is the string message being passed
	 */
	public EmptyQueueException(String msg){
		super(msg);
	}
	
}
