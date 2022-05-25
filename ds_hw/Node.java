package ds_hw;
import java.util.NoSuchElementException;

public class Node<E extends Comparable<E>> {
	private E item;
	private Node<E> next;
	
	public Node(E newitem, Node p) {
		item=newitem; next=p;
	}
	
	public E getItem() { return item; }
	public Node getNext() { return next; }
	public void setItem(E newitem) { item=newitem; }
	public void setNext(Node p) { next=p; }

}
