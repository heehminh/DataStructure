// 자료구조 과제#2 (60200680 김민희)
package ds_week04;

public class Node <E extends Comparable<E>>{
	private E item;
	private Node<E> next;
	
	// 생성자
	public Node(E newItem, Node<E> p) {
		this.item = newItem;
		this.next = p;
	}
	
	public E getItem() { return this.item; }
	public Node<E> getNext() { return this.next; }
	public void setItem(E newItem) { this.item = newItem; }
	public void setNext(Node<E> n) { this.next = n; }

}
