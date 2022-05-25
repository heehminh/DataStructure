package ds_week04;
import java.util.NoSuchElementException;

public class CList <E extends Comparable<E>> {
	private Node last; // 리스트의 마지막 노드
	private int size;
	
	// 원형 연결리스트 생성자
	public CList() {
		this.last = null;
		this.size = 0;
	}
	
	public int size() { return this.size; }
	public boolean isEmpty() { return size == 0; }
	
	// last가 가리키는 노드의 다음에 새노드 삽입
	public void insert(E newItem) {
		Node newNode = new Node(newItem, null);
		
		if(last == null) { // 리스트가 empty일때
			newNode.setNext(newNode);
			last = newNode;
		} else {
			newNode.setNext(last.getNext());
			last.setNext(newNode);
		} 
		size ++;
	}
	
	// last가 가리키는 노드의 다음 노드(리스트의 첫 노드)를 제거
	public void delete() {
		if (isEmpty()) throw new NoSuchElementException();
		
		Node x = last.getNext();
		if(x==last) last = null; // 리스트에 1개의 노드만 있는 경우
		else {
			last.setNext(x.getNext());
		} 
		size --;
	}
	
	public void print() { 
		if(size > 0) {
			int i = 0;
			for (Node p = last.getNext(); i<size; p=p.getNext(), i++) 
				System.out.print(p.getItem()+"\t ");
		}
		else System.out.println("리스트 비어있음");
		System.out.println();
	}


}
