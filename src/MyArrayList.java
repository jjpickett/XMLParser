import utilities.Iterator;
import utilities.List;

public class MyArrayList<E> implements List<E> {
	
	private int size = 0;
	public static final int INITIAL_CAPACITY = 10;
	private E[] elements = (E[]) new Object[INITIAL_CAPACITY];
	
	public MyArrayList(){}
	
	public MyArrayList(E[] elements){
		this.size = elements.length;
		this.elements = (E[]) new Object[size];
		this.elements = elements; 
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public void clear() {
		elements = (E[]) new Object[INITIAL_CAPACITY];
	    size = 0;
	}

	@Override
	public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
		if (index < 0 || index > this.size)
			throw new IndexOutOfBoundsException("Index=" + index);

		// Move the elements to the right after the specified index
	    for (int i = size - 1; i >= index; i--)
	      elements[i + 1] = elements[i];
	    // Insert new element to data[index]
	    elements[index] = toAdd;
	    // Increase size by 1
	    size++;
		return true;
	}

	@Override
	public boolean add(E toAdd) throws NullPointerException {
		
		elements[size] = toAdd;
		size++;
		return true;
	}

	@Override
	public boolean addAll(List<? extends E> toAdd) throws NullPointerException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E get(int index) throws IndexOutOfBoundsException {
	    return elements[index];
	}

	@Override
	public E remove(int index) throws IndexOutOfBoundsException {
		E e = elements[index];

	    for (int j = index; j < size - 1; j++)
	      elements[j] = elements[j + 1];

	    elements[size - 1] = null; // This element is now null

	    // Decrement size
	    size--;

	    return e;
	}

	@Override
	public E remove(E toRemove) throws NullPointerException {
		for (int i = 0; i < size; i++)
		      if (toRemove.equals(elements[i]))
		    	  return(remove(i));
		return null;
	}

	@Override
	public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(E toFind) throws NullPointerException {
		for (int i = 0; i < size; i++)
	      if (toFind.equals(elements[i])) return true;

	    return false;
	}

	@Override
	public E[] toArray(E[] toHold) throws NullPointerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
//	int size = 0;
//	
//	public E [] toArray(E [] toHold) throws NullPointerException{
//		if(toHold == null)
//			throw new NullPointerException("Cannout copy to a null array.");
//		
//		if(toHold.length < size )
//			toHold = (E[]) (Array.newInstance(toHold.getClass().getComponentType()), size));
//			
//			for(int i = 0; i < size; i++)
//				toHold[i] = (E) array[i];
//		
//		return toHold;
//		
//	}
//	
//	public Object[] toArray(){
//		Object[] toReturn = new Object[size];
////		for (int i =0; i < size(); i++)
//	}
//
//}
//
//private class ArrayBasedIterator implements Iterator<E>{
//	
////	private E[] 	copyOfElements;
//	private int		pos;
//	
//	@SuppressWarnings("unchecked")
//	public ArrayBasedIterator(){
////		copyOfElements = (E[]) (new Object[size()]);
////		System.arraycopy(array, 0, copyOfElements, 0, copyOfElements.length);
//	}
//	
//	public boolean hasNext(){
//		return pos < size;
//	}
//	
//	public E next() throws NoSuchElementException{
//		if(pos >= size)
//			throw new NoSuchElementException("No such element yo!");
//		E toReturn = array[pos++];
//		return toReturn;
//	}

}
