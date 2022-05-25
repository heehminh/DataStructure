package ds_week04;

public class DNode <E> {
	private E item;
	private DNode previous;
	private DNode next;
	
	public DNode(E newItem, DNode p, DNode q) {
		this.item = newItem;
		this.previous = p; this.next = q;
	}
	
	public E 		getItem() 			 { return this.item; }
	public DNode 	getPrevious() 		 { return this.previous; }
	public DNode 	getNext()			 { return this.next; }
	public void 	setItem(E newItem)	 { this.item = newItem; }
	public void 	setPrevious(DNode p) { this.previous = p; }
	public void 	setNext(DNode q) 	 { this.next = q; }

}
