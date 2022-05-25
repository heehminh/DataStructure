// 자료구조 과제#2 (60200680 김민희)
package ds_week04;
import java.util.NoSuchElementException;

// Node class와 제너릭 타입을 맞춰주기!
public class SList <E extends Comparable<E>> {
	protected Node<E> head; // 연결리스트의 첫 노드 가리킴
	private int size;	 // 전체 노드의 사이즈
	
	public SList() { // 연결리스트 생성자
		this.head = null;
		this.size = 0;
	}
	
	public int size() { return size; }
	
	// target을 찾을 때까지 연결리스트의 노드들을 첫 노드부터 차례로 탐색
	public int search(E target) { // target을 검색
		Node<E> p = head;
		
		for(int k=0; k<size; k++) {
			if(target == p.getItem()) return k;
			p = p.getNext();
		}
		 return -1; // 탐색을 실패한 경우 -1 리턴
	}
	
	// 삽입 메소드(2가지)
	// 새 노드를 리스트의 첫번째 노드가 되도록 연결
	public void insertFront(E newItem) {
		head = new Node<E>(newItem, head);
		size ++;
	}
	
	// p가 가리키는 노드의 다음에 새 노드를 삽입
	public void insertAfter(E newItem, Node<E> p) {
		p.setNext(new Node<E>(newItem, p.getNext()));
		size ++;
	}
	
	public boolean isEmpty() {
		if (size == 0) return true;
		else return false;
	}
	
	// 삭제 메소드(2가지)
	// 리스트가 empty가 아닐때, 리스트의 첫 노드를 삭제
	public void deleteFront() {
		if(isEmpty()) throw new NoSuchElementException();
		
		head = head.getNext();
		size --;
	}

	// p가 가리키는 노드의 다음 노드를 삭제
	public void deleteAfter(Node<E> p) {
		if(p == null || p.getNext() == null) 
			throw new NoSuchElementException();
		
		Node<E> t = p.getNext();
		p.setNext(t.getNext()); 
		t.setNext(null);
		size --;
	}

	// 연결 리스트 노드들의 항목들을 차례로 출력
	public void print() {
		for (Node p=head; p != null; p=p.getNext()) {
			System.out.print(p.getItem()+"\t");
		} System.out.println();
	}

	// 17_mergeLists
	public Node<E> mergeLists(Node<E> p1, Node<E> p2){
		if(p1 == null) return p2;
		else if(p2 == null) return p1;
		
		Node<E> o = null;
		
		if(p1.getItem().compareTo(p2.getItem()) <= 0) {
			o = p1;
			p1 = p1.getNext();
			o.setNext(mergeLists(p1, p2));
		}
		else {
			o = p2;
			p2 = p2.getNext();
			o.setNext(mergeLists(p1, p2));
		}
		return o;
	}
	
	// 20_splitList
	public Object[] splitList(Node<E> p, int k, SList<E> l1, SList<E> l2) {
		p = head;
		
		while (p != null) {
			E item = p.getItem();
			
			if ((int)item <= k) l1.insertFront(item);
			else l2.insertFront(item);
			
			p = p.getNext();
		}
		return new Object[] {l1, l2};
	}

}
