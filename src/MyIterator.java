import java.util.NoSuchElementException;

import utilities.Iterator;
import utilities.List;
/**
 * This is the MyIterator class
 * @author 709005
 *
 * @param <E> is the type that will be used in this class
 */
public class MyIterator<E> implements Iterator<E> {
	private int index = 0;
	private E[] elements;
	/**
	 * This is the main constructor for MyIterator
	 * that adds the array of elements.
	 * @param elements is a variable that holds an
	 * array of elements
	 */
	public MyIterator(E[] elements){
		this.elements = elements;
	}
	/**
	 * @see Iterator#hasNext()
	 */
	@Override
	public boolean hasNext() {
		return index < elements.length;
	}
	/**
	 * @see Iterator#next()
	 */
	@Override
	public E next() throws NoSuchElementException {
		if (!this.hasNext())
			throw new NoSuchElementException();
		
		return this.elements[index++];	
	}

}
