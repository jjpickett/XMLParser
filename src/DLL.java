
import utilities.Iterator;
import utilities.List;
/**
 * @see List
 */
public class DLL<E> implements List<E>{

	private static final long serialVersionUID = 1L;
	private DLLNode<E> head;
    private DLLNode<E> tail;
    private int size;
    /**
     * This is the main constructor for the Double Linked List
     */
    public DLL(){
    	head = null;
    	tail = null;
    	size = 0;
    }
    /**
     * @see List#size()
     */
	@Override
	public int size() {
		return size;
	}
	/**
	 * @see List#clear()
	 */
	@Override
	public void clear() {
		while(this.size > 0){
			DLLNode<E> temp = head;
			head = head.getNext();
			head.setPrev(null);
			temp = null;
			size--;
		}
	}
	/**
	 * @see List#add(int, Object)
	 */
	@Override
	public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {	
		if (index < 0)
			throw new IndexOutOfBoundsException("The position " + index + " is less than zero and is invalid.");
		else if (index > size)
			throw new IndexOutOfBoundsException("The position " + index + " is greater than the length of the list");
		else if(index == 0){
			if(head == null)
				head = new DLLNode<E>(toAdd);
			else{
				DLLNode<E> temp = new DLLNode<E>(toAdd);
				temp.setNext(head);
				head = temp;
				head.setPrev(null);
			}
			size++;
		}
		else{
			// Sets the node wanting to be added as new node
			DLLNode<E> newNode = new DLLNode<E>(toAdd);
			//Gets the node at the previous position of whats indicated
			DLLNode<E> previousNode = new DLLNode<E>(get(index - 1));
			//Gets the node at the current position wanted
			DLLNode<E> nextNode = new DLLNode<E>(get(index));
			
			previousNode.setNext(newNode);
			newNode.setNext(nextNode);
			size++;			 
		}
		return true;
	}
	/**
	 * @see List#add(Object)
	 */
	@Override
	public boolean add(E toAdd) throws NullPointerException {
		if (!isEmpty()) {
			tail.setNext(new DLLNode<E>(toAdd));
			tail = tail.getNext();
		} else
			head = tail = new DLLNode<E>(toAdd);
		size++;
		return true;
	}
	/**
	 * @see List#addAll(List)
	 */
	@Override
	public boolean addAll(List<? extends E> toAdd) throws NullPointerException {
		for(int i = 0; i < toAdd.size(); i++)
			this.add(size, toAdd.get(i));
		return true;
	}
	/**
	 * @see List#get(int)
	 */
	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		DLLNode<E> current = head;
		for (int i = 0; i < index; i++)
			current = current.getNext();
		return current.getElement();
	}
	/**
	 * @see List#remove(int)
	 */
	@Override
	public E remove(int index) throws IndexOutOfBoundsException {
		if (head == null)
			throw new IndexOutOfBoundsException("The list you are attempting to remove from does not exist.");
		
		if (index < 0)
			throw new IndexOutOfBoundsException("The position " + index + " is less than zero and is invalid.");
		else if (index > size)
			throw new IndexOutOfBoundsException("The position " + index + " is greater than the length of the list");
		else if (index == 0){
			DLLNode<E> temp = head;
			head = head.getNext();
			head.setPrev(null);
			size--;
			return temp.getElement();
		}
		else{
			// Gets the node at the current position that we want to remove
			DLLNode<E> currentNode = new DLLNode<E>(get(index));
			//Gets the node at the previous position of what is indicated
			DLLNode<E> previousNode = new DLLNode<E>(get(index - 1));
			//Gets the node at the next location after the position
			DLLNode<E> nextNode = new DLLNode<E>(get(index + 1));
			
			previousNode.setNext(nextNode);
			size--;		
			return currentNode.getElement();
		}
	}
	/**
	 * @see List#remove(Object)
	 */
	@Override
	public E remove(E toRemove) throws NullPointerException {
		int index = 0;
		DLLNode<E> current = head;
		
		if(head != null)
		{
			for (int i = 0; i < index; i++){
				current = current.getNext();
				if(toRemove.equals(current))
					return remove(i);
			}	
		}else{
			throw new NullPointerException("There is no element in this list");
		}
		return null;	
	}
	/**
	 * @see List#set(int, Object)
	 */
	@Override
	public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
		if (head == null)
			throw new NullPointerException("The list you are attempting to set to does not exist.");
		
		if (index < 0)
			throw new IndexOutOfBoundsException("The position " + index + " is less than zero and is invalid.");
		else if (index > size)
			throw new IndexOutOfBoundsException("The position " + index + " is greater than the length of the list");
		else{
			E myElement = get(index);
			remove(index);
			add(index, toChange);
			return myElement;
		}
	}
	/**
	 * @see List#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		return size == 0;
	}
	/**
	 * @see List#contains(Object)
	 */
	@Override
	public boolean contains(E toFind) throws NullPointerException {
		DLLNode<E> temp = null;
		if(head != null){
			for (int i = 0; i < size; i++){
				temp = temp.getNext();
				if(toFind.equals(temp.getElement()))
					return true;
			}
		}
		return false;
	}
	/**
	 * @see List#toArray(Object[])
	 */
	@Override
	public E[] toArray(E[] toHold) throws NullPointerException {
		return toHold;
	}
	/**
	 * @see List#toArray()
	 */
	@Override
	public E[] toArray() {
		E[] elements = (E[])new Object[size];
		DLLNode<E> tempNode = head;
		for (int i = 0; i < size; i++){
			elements[i] = tempNode.getElement();
			tempNode = tempNode.getNext();
		}
		return elements;
	}
	/**
	 * @see List#iterator()
	 */
	@Override
	public Iterator<E> iterator() {
		E[] elements = (E[])new Object[size];
		DLLNode<E> tempNode = head;
		for (int i = 0; i < size; i++){
			elements[i] = tempNode.getElement();
			tempNode = tempNode.getNext();
		}
		return new MyIterator<E>(elements);
	}

}
