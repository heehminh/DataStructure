//자료구조 과제 #4 (60200860 김민희)
package ds_week05;
import java.util.EmptyStackException;

public class ListStack <E> {
	private Node<E> top;
	private int size;
	
	public ListStack() {
		this.top = null;
		this.size = 0;
	}
	public int size() { return size; }
	public boolean isEmpty() { return (size==0); }
	
	public E peek() {
		if (isEmpty()) throw new EmptyStackException();
		return top.getItem();
	}
	
	public void push(E newItem) {
		Node newNode = new Node(newItem, top);
		
		top = newNode;
		size ++;
	}
	
	public E pop() {
		if (isEmpty()) throw new EmptyStackException();
		
		E topItem = top.getItem();
		top = top.getNext();
		size --;
		
		return topItem;
	}
	
	public void print() {
		if (isEmpty()) System.out.print("스택이 비어있음.");
		else {
			for (Node p = top; p != null; p=p.getNext())
				System.out.print(p.getItem()+"\t ");
		} System.out.println();
	}

}
