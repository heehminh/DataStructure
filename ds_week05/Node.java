//자료구조 과제 #4 (60200860 김민희)
package ds_week05;

public class Node <E>{
	private E 		item;
	private Node<E> next;
	
	// 생성자
	public Node(E newItem, Node<E> node) {
		this.item = newItem;
		this.next = node;
	}
	
	public E 		getItem() { return this.item; }
	public Node<E> 	getNext() { return this.next; }
	public void 	setItem(E newItem) { this.item = newItem; }
	public void 	setNext(Node<E> newNext) { this.next = newNext; }

}

