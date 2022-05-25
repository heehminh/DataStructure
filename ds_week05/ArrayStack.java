package ds_week05;
import java.util.EmptyStackException;

public class ArrayStack<E> {
	private E	s[]; // 스택을 위한 배열
	private int top; // 스택의 top 항목의 배열원소 인덱스
	
	public ArrayStack() {
		s = (E[]) new Object[1]; // 초기에 크기가 1인 배열 생성
		top = -1;
	}
	
	public int size() { return top+1; }
	public boolean isEmpty() { return (top==-1); }
	
	// 스택 top 항목의 내용만을 리턴
	public E peek() {
		if(isEmpty()) throw new EmptyStackException();
		
		return s[top];
	}
	
	// push- newItem을 스택의 top에 삽입
	public void push(E newItem) {
		if (size() == s.length) 
			resize (2*s.length);
		
		s[++top] = newItem;
	}
	
	// pop- 스택에서 top의 item 제거
	public E pop() {
		if (isEmpty()) throw new EmptyStackException();
		
		E item = s[top];
		s[top--] = null;
		
		if (size() > 0 && size()==s.length/4)
			resize (s.length/2);
		
		return item;
	}
	
	public void resize(int newSize) {
		Object[] t = new Object[newSize];
		
		for (int i=0; i<size(); i++) 
			t[i] = s[i];
		
		s = (E[]) t;
	}
	
	public void print() {
		if (isEmpty())
			System.out.print("스택이 비어있음.");
		else {
			for (int i=0; i<size(); i++)
				System.out.print(s[i]+"\t ");
		} System.out.println();
	}
}
