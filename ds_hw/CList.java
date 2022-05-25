package ds_hw;
import java.util.NoSuchElementException;

import ds_week04.Node;

public class CList<E extends Comparable<E>>{
	private Node last;
	private int size;
	
	public CList() {
		last=null;
		size=0;
	}
	
	public int getSize() { return size; }
	public boolean isEmpty() { return size==0; }
	
	// 새 항목을 리스트의 첫노드(last의 다음 노드)로 삽입
	public void insert(E newitem) {
		Node newNode = new Node(newitem, null);
		
		if (last == null) {
			newNode.setNext(newNode);
			last = newNode;
		} 
		else {
			newNode.setNext(last.getNext());
			last.setNext(newNode);
		}
		size ++;
	}
	
	// 리스트의 첫 노드(last의 다음노드를 삭제)
	public void delete() {
		if (isEmpty()) throw new NoSuchElementException();
		
		Node x = last.getNext();
		if (x==null) last=null;
		else last.setNext(x.getNext());

		size--;
	}
	
	public void print() {
		if (size>0) {
			int i=0;
			for(Node p=last.getNext(); i<size; p=p.getNext(), i++) {
				System.out.print(p.getItem()+"\t");
			}
		} else { 
			System.out.print("리스트빔");
		} System.out.println();
		
	}

}
