package ds_hw;
import java.util.NoSuchElementException;

public class ListStack<E extends Comparable<E>>{
	private Node<E> top;
	private int size;
	
	public ListStack() {
		top=null; size=0;
	}
	
	public int getSize() { return size; }
	public boolean isEmpty() { return size==0; }
	
	public E peek() {
		if (isEmpty()) throw new NoSuchElementException();
		
		return top.getItem();
	}
	
	public void push(E newitem) {
		Node newNode = new Node(newitem, top);
		top = newNode;
		size ++;
	}
	
	public E pop() {
		if(isEmpty()) throw new NoSuchElementException();
		
		E item = top.getItem();
		top = top.getNext();
		size --;
		
		return item;
	}
	
	public void print() {
		for(Node p=top; p!=null; p=p.getNext()) {
			System.out.print(p.getItem()+"\t");
		}
	}
	
}
