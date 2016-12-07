import exceptions.EmptyQueueException;
import utilities.Iterator;
import utilities.QueueADT;

public class MyQueue<E> implements QueueADT<E>{
	
	private int size = 0;
	public static final int INITIAL_CAPACITY = 30;
	private E[] elements = (E[]) new Object[INITIAL_CAPACITY];
	/**
	 * This is an empty constructor for the MyQueue class
	 */
	public MyQueue(){}
	/**
	 * This is the main constructor for the MyQeue class
	 * that takes in an array of elements.
	 * @param elements is an array of elements
	 */
	public MyQueue(E[] elements){
		this.size = elements.length;
		this.elements = (E[]) new Object[size];
		this.elements = elements; 
	}
	/**
	 * @see QueueADT#enqueue(Object)
	 */
	@Override
	public void enqueue(E toAdd) throws NullPointerException {
		elements[size] = toAdd;
		size++;
	}
	/**
	 * @see QueueADT#dequeue()
	 */
	@Override
	public E dequeue() throws EmptyQueueException {
		E temp = elements[size];
		elements[size] = null;
		size--;
		return temp;
	}
	/**
	 * @see QueueADT#peek()
	 */
	@Override
	public E peek() throws EmptyQueueException {
		return elements[0];
	}
	/**
	 * @see QueueADT#dequeueAll()
	 */
	@Override
	public void dequeueAll() {
		for(int i = 0; i < size; i++)
			elements[i] = null;
		size = 0;
	}
	/**
	 * @see QueueADT#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		return this.size == 0;
	}
	/**
	 * @see QueueADT#iterator()
	 */
	@Override
	public Iterator<E> iterator() {
		return new MyIterator<E>(elements);
	}
	/**
	 * @see QueueADT#equals(QueueADT)
	 */
	@Override
	public boolean equals(QueueADT<E> that) {
		if(this.size == that.size()){
			for(int i = that.size(); i > 0; i--){
				try {
					if(!elements[i].equals(that.dequeue()))
						return false;
				} catch (EmptyQueueException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return true;
		}
		return false;
	}
	/**
	 * @see QueueADT#toArray()
	 */
	@Override
	public E[] toArray() {
		return elements;
	}
	/**
	 * @see QueueADT#toArray(Object[])
	 */
	@Override
	public E[] toArray(E[] holder) throws ArrayStoreException, NullPointerException {
		elements = holder;
		return elements;
	}
	/**
	 * @see QueueADT#isFull()
	 */
	@Override
	public boolean isFull() {
		return false;
	}
	/**
	 * @see QueueADT#size()
	 */
	@Override
	public int size() {
		return size;
	}

}
