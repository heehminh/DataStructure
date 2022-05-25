package ds_hw;
import java.util.NoSuchElementException;

import ds_week04.DNode;

public class DList<E extends Comparable<E>> {
	protected Node head, tail;
	protected int size;
	
//	public DList() {
//		head = new Node(null, null, null);
//		tail = new Node(null, head, null);
//		head.setNext(tail);
//		size = 0;
//	}

	public int getSize() { return size; }
	public boolean isEmpty() { return size==0; }

//	// 새로운 Node를 p앞에 삽입
//	public void insertBefore(Node p, E newitem) {
//		Node t = p.getPrevious();
//		Node newNode = new Node(newitem, t, p);
//		t.setNext(newNode);
//		p.setPrevious(newNode);
//		size ++;
//	}
//	
//	// 새로운 Node를 p뒤에 삽입
//	public void insertAfter(Node p, E newitem) {
//		Node t = p.getNext();
//		Node newNode = new Node(newitem, p, t);
//		
//		p.setNext(newNode);
//		t.setNext(newNode);
//		size ++;
//	}
//	
//	// x가 가리키는 노드를 삭제 
//	public void delete(Node x) {
//		if (x==null) throw new NoSuchElementException();
//		
//		Node p = x.getPrevious();
//		Node q = x.getNext();
//		
//		p.setNext(q);
//		q.setPrevious(p);
//		size --;
//	}
//	
//	public void print() {
//		for (Node p=head; p!=null; p=p.getNext()) {
//			System.out.print(p.getItem()+"\t");
//		}
//	}

}
