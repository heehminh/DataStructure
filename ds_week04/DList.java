package ds_week04;
import java.util.NoSuchElementException;

public class DList <E> {
	protected DNode head, tail;
	protected int size;
	
	// 이중 연결 리스트 생성자
	public DList() {
		// item, previous, next
		this.head = new DNode(null, null, null);
		this.tail = new DNode(null, head, null);
		this.head.setNext(tail);
		size = 0;
	}
	
	public int size() { return this.size; }
	public boolean isEmpty() { return this.size == 0; }
	
	public void insertBefore(DNode p, E newItem) {
		DNode t = p.getPrevious();
		DNode newNode = new DNode(newItem, t, p);
		p.setPrevious(newNode);
		t.setNext(newNode);
		size ++;
	}
	
	public void insertAfter(DNode p, E newItem) {
		DNode t = p.getNext();
		DNode newNode = new DNode(newItem, p, t);
		t.setPrevious(newNode);
		p.setNext(newNode);
		size ++;
	}
	
	// x가 가리키는 노드 삭제 (앞, 뒤 정보 필요없음)
	public void delete(DNode x) {
		if (x==null) throw new NoSuchElementException();
		
		DNode f = x.getPrevious();
		DNode r = x.getNext();
		f.setNext(r);
		r.setPrevious(f);
		size --;
	}
	
	public void print() {
		if (size > 0) {
			for (DNode p = head.getNext(); p != tail; p = p.getNext()) {
				System.out.print(p.getItem()+"\t ");
			}
		}
		else System.out.println("리스트 비어있음");
		System.out.println();
	} 

	

}
