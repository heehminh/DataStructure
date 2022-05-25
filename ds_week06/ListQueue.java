package ds_week06;
import java.util.NoSuchElementException;

public class ListQueue <E extends Comparable<E>>{
	private Node<E> front, rear;
	
	private int size;
	
	public ListQueue() {
		front = rear = null;
		size = 0;
	}
	
	public int size() { return size; }
	public boolean isEmpty() { return size==0; }
	
	// newItem을 큐의 rear에 삽입
	public void add(E newItem) {
		// 새 노드 생성
		Node newNode = new Node(newItem, null);
		
		// 큐가 empty이면 front도 newNode를 가리키게 함
		// 그렇지 않으면 rear의 next가 newNode를 가리키게 함
		if (isEmpty()) front = newNode;
		else rear.setNext(newNode);
		
		rear = newNode; // 마지막 rear가 newNode를 가리킴
		size++;			// 큐 항목 수 1 증가
	}
	
	public E remove() {
		if(isEmpty()) throw new NoSuchElementException();
		
		E frontItem = front.getItem ();
		front = front.getNext();
		
		size--;
		if (isEmpty()) rear=null;
		
		return frontItem;
	}
	
	public void print() {
		if(isEmpty()) System.out.println("큐가 empty임");

		for(Node p=front; p!=rear; p=p.getNext())
			System.out.print(p.getItem()+"\t");
		
		if(rear!=null)
			System.out.println(rear.getItem());

	} 
}
