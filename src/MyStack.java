import utilities.EmptyStackException;
import utilities.Iterator;
import utilities.StackADT;

public class MyStack<E> implements StackADT<E> {
	private int size = 0;
	public static final int INITIAL_CAPACITY = 30;
	private E[] elements;
	/**
	 * This is the empty constructor that initializes
	 * the elements Array to the initial capacity
	 */
	public MyStack() {
		elements = (E[]) new Object[INITIAL_CAPACITY];
	}
	/**
	 * This constructor allows for a 
	 * user to set what size they want for when
	 * they start off.
	 * @param size is the size of the stack
	 */
	public MyStack(int size) {
		elements = (E[]) new Object[size];
		this.size = size;
	}
	/**
	 * @see StackADT#push(Object)
	 */
	@Override
	public void push(E toAdd) throws NullPointerException {

		for (int i = size - 1; i >= 0; i--)
			elements[i + 1] = elements[i];

		elements[0] = toAdd;
		size++;

	}
	/**
	 * @see StackADT#pop()
	 */
	@Override
	public E pop() {
		E val = elements[0];
		for (int i = 0; i < size; i++)
			elements[i] = elements[i + 1];
		
		size--;
		return val;
	}
	/**
	 * @see StackADT#peek()
	 */
	@Override
	public E peek() throws EmptyStackException {
		if(elements == null)
			throw new EmptyStackException();
		return elements[0];
	}
	/**
	 * @see StackADT#clear()
	 */
	@Override
	public void clear() {
		elements = (E[]) new Object[INITIAL_CAPACITY];
		size = 0;
	}
	/**
	 * @see StackADT#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		return this.size == 0;
	}
	/**
	 * @see StackADT#toArray()
	 */
	@Override
	public E[] toArray() {
		return elements;
	}
	/**
	 * @see StackADT#toArray(Object[])
	 */
	@Override
	public E[] toArray(E[] holder) throws ArrayStoreException, NullPointerException {
		elements = holder;
		return elements;
	}
	/**
	 * @see StackADT#contains(Object)
	 */
	@Override
	public boolean contains(E toFind) throws NullPointerException {
		for (int i = 0; i < size; i++)
		      if (toFind.equals(elements[i])) return true;

		return false;
	}
	/**
	 * @see StackADT#search(Object)
	 */
	@Override
	public int search(E toFind) {
		for (int i = 0; i < size; i++)
		      if (toFind.equals(elements[i])) return i;
		return -1;
	}
	/**
	 * @see StackADT#iterator()
	 */
	@Override
	public Iterator<E> iterator() {
		return new MyIterator<E>(elements);
	}
	/**
	 * @see StackADT#equals(StackADT)
	 */
	@Override
	public boolean equals(StackADT<E> that) {
		
		if(this.size == that.size()){
			for(int i = 0; i < this.size; i++)
				if(that.search(elements[i]) != i)
					return false;
			return true;
		}
		return false;
	}
	/**
	 * @see StackADT#size()
	 */
	@Override
	public int size() {
		return size;
	}

}
