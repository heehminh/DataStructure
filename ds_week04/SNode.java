package ds_week04;

public class SNode <E extends Comparable<E>>{
	private E item;
	private SNode<E> next;
	
	// 생성자
	public SNode(E newItem, SNode<E> p) {
		this.item = newItem;
		this.next = p;
	}
	
	public E getItem() { return this.item; }
	public SNode<E> getNext() { return this.next; }
	public void setItem(E newItem) { this.item = newItem; }
	public void setNext(SNode<E> n) { this.next = n; }
	


}
