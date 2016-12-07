import utilities.Iterator;
import utilities.List;

public class MyArrayList<E> implements List<E> {
	
	private int size = 0;
	public static final int INITIAL_CAPACITY = 30;
	private E[] elements = (E[]) new Object[INITIAL_CAPACITY];
	/**
	 * This is the empty constructor for
	 * this class.
	 */
	public MyArrayList(){}
	/**
	 * This is the main constructor for this class
	 * that will build the arrayList with the given
	 * elements.
	 * @param elements is an array of elements
	 */
	public MyArrayList(E[] elements){
		this.size = elements.length;
		this.elements = (E[]) new Object[size];
		this.elements = elements; 
	}
	/**
	 * @see List#size()
	 */
	@Override
	public int size() {
		return this.size;
	}
	/**
	 * @see List#clear()
	 */
	@Override
	public void clear() {
		elements = (E[]) new Object[INITIAL_CAPACITY];
	    size = 0;
	}
	/**
	 * @see List#add(int, Object)
	 */
	@Override
	public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
		if (index < 0 || index > this.size)
			throw new IndexOutOfBoundsException("Invalid index at " + index);

	    for (int i = size - 1; i >= index; i--)
	      elements[i + 1] = elements[i];
	    
	    elements[index] = toAdd;
	    size++;
		return true;
	}
	/**
	 * @see List#add(Object)
	 */
	@Override
	public boolean add(E toAdd) throws NullPointerException {
		elements[size] = toAdd;
		size++;
		return true;
	}
	/**
	 * @see List#addAll(List)
	 */
	@Override
	public boolean addAll(List<? extends E> toAdd) throws NullPointerException {
		for(int i = 0; i < toAdd.size(); i++)
			this.add(toAdd.get(i));
		return true;
	}
	/**
	 * @see List#get(int)
	 */
	@Override
	public E get(int index) throws IndexOutOfBoundsException {
	    return elements[index];
	}
	/**
	 * @see List#remove(int)
	 */
	@Override
	public E remove(int index) throws IndexOutOfBoundsException {
		E e = elements[index];

	    for (int j = index; j < size - 1; j++)
	      elements[j] = elements[j + 1];

	    elements[size - 1] = null;
	    size--;
	    return e;
	}
	/**
	 * @see List#remove(Object)
	 */
	@Override
	public E remove(E toRemove) throws NullPointerException {
		for (int i = 0; i < size; i++)
		      if (toRemove.equals(elements[i]))
		    	  return(remove(i));
		return null;
	}
	/**
	 * @see List#set(int, Object)
	 */
	@Override
	public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
		E old = elements[index];
	    elements[index] = toChange;
	    return old;
	}
	/**
	 * @see List#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		return this.size == 0;
	}
	/**
	 * @see List#contains(Object)
	 */
	@Override
	public boolean contains(E toFind) throws NullPointerException {
		for (int i = 0; i < size; i++)
	      if (toFind.equals(elements[i])) return true;

	    return false;
	}
	/**
	 * @see List#toArray(Object[])
	 */
	@Override
	public E[] toArray(E[] toHold) throws NullPointerException {
		elements = toHold;
		return elements;
	}
	/**
	 * @see List#toArray()
	 */
	@Override
	public E[] toArray() {
		return elements;
	}
	/**
	 * @see List#iterator()
	 */
	@Override
	public Iterator<E> iterator() {
		return new MyIterator<E>(elements);
	}

}
