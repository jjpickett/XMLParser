package exceptions;

public class EmptyQueueException extends Exception {

	public EmptyQueueException(){}
	
	public EmptyQueueException(String msg){
		super(msg);
	}
	
}
