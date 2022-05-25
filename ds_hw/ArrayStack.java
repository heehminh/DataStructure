package ds_hw;
import java.util.NoSuchElementException;

public class ArrayStack<E extends Comparable<E>> {
	private E s[];
	private int top;
	
	public ArrayStack() {
		s = (E[]) new Object[1];
		top = -1;
	}
	
	public int getSize() { return top+1; }
	public boolean isEmpty() { return top==-1; }
	public void resize(int num) {
		Object[] t = new Object[num];
		
		for (int i=0; i<getSize(); i++) {
			t[i] = s[i];
		}
		s = (E[]) t;
	}

	public E peek() {
		if (isEmpty()) throw new NoSuchElementException();
		return s[top];
	}
	
	public void push(E newitem) {
		// resize
		if (getSize() == s.length) resize(2*getSize());
		s[++top] = newitem;
	}
	
	public E pop() {
		if (isEmpty()) throw new NoSuchElementException();
		
		E item = s[top];
		s[top] = null;
		top --;
		
		if (getSize() >0 && getSize() == s.length/4) resize(2*getSize());
		
		return item;
	}
}
