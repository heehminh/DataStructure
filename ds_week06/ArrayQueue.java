package ds_week06;
import java.util.NoSuchElementException;

public class ArrayQueue <E> {
	private E[] q; // 큐를 위한 배열
	private int front, rear, size;
	
	// 큐 생성자
	public ArrayQueue() {
		q = (E[]) new Object[2]; // 초기에 크기가 2인 배열 생성
		front = rear = size = 0;
	}
	
	public int size() { return size; }
	public boolean isEmpty() { return size==0; }
	public void resize(int newSize) {
		Object[] t = new Object[newSize];
		
		// 배열 q의 항목들을 배열 t[1]로부터 복사
		for(int i=1, j=front+1; i<size+1; i++, j++) {
			t[i] = q[j%q.length];
		}
		
		front = 0;
		rear = size;
		
		q = (E[]) t;
	}
	
	public void add(E newItem) {
		if ((rear+1) % q.length == front) // 배열이 꽉찬경우
			resize(q.length*2);
		
		rear = (rear+1) % q.length;
		q[rear] = newItem;
		
		size++;
	}
	
	public E remove() {
		if (isEmpty()) throw new NoSuchElementException();
		
		front = (front+1) % q.length;
		E item = q[front];
		
		q[front] = null; // print시 항목없음을 확인하기 위해
		size--; 
		
		if (size>0 && size==q.length/4)
			resize(q.length/2);
		
		return item;
	}
	
	public void print() {
		System.out.print("항목수: ");
		System.out.print(size+"/ ");
		
		for(int i=0; i<q.length; i++) {
			System.out.print(q[i]+"\t");
		} System.out.println();
	}
}
