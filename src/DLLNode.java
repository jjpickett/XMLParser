public class DLLNode<E> {
	private E element;
	private DLLNode<E> next;
	private DLLNode<E> prev;
	/**
	 * This is the main constructor for the 
	 * DLLNode class.
	 * @param o element being passed in
	 * @param n the next node
	 */
	public DLLNode(E o, DLLNode<E> n) {
		this.element = o;
		this.next = n;
	}
	/**
	 * This is another constructor that
	 * adds the element to the Node.
	 * @param o is the element being passed in
	 */
	public DLLNode(E o) {
		this.element = o;
		this.next = null;
	}
	/**
	 * This method is a setter for the element
	 * that is in this DLLNode
	 * @param o is the Element
	 */
	public void setElement(E o) {
		this.element = o;
	}
	/**
	 * This is the getter for the element in this
	 * Node.
	 * @return the element
	 */
	public E getElement() {
		return this.element;
	}
	/**
	 * This is a setter that sets what
	 * the next Node will be
	 * @param n is the node that will be set
	 */
	public void setNext(DLLNode<E> n) {
		this.next = n;
	}
	/**
	 * This is the getter that will return what
	 * the next Node will be.
	 * @return the next Node in the DLL
	 */
	public DLLNode<E> getNext() {
		return this.next;
	}
	/**
	 * This is a setter method that
	 * will set what the previous DLLNode
	 * will be.
	 * @param n is the Node that is the previous node
	 */
	public void setPrev(DLLNode<E> n) {
		this.next = n;
	}
	/**
	 * This is a getter method that will return
	 * the node pervious to this one.
	 * @return the previous DLLNode
	 */
	public DLLNode<E> getPrev() {
		return this.prev;
	}
}