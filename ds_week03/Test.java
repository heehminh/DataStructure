package ds_week03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.Random;

class Heap<E> {
	
	private final Comparator<? super E> comparator;
	private static final int DEFAULT_CAPACITY = 10; 
	
	private int size;
	
	private Object[] array; // 요소를 담을 배열
	
	public Heap() {
		this(null);
	}
	
	public Heap(Comparator<? super E> comparator) {
		this.array = new Object[DEFAULT_CAPACITY];
		this.size = 0;
		this.comparator = comparator;
	}
	
	public Heap(int capacity) {
		this(capacity, null);
	}
	
	public Heap(int capacity, Comparator<? super E> comparator) {
		this.array = new Object[capacity];
		this.size = 0;
		this.comparator = comparator;
	}
	
	// 받은 인덱스의 부모 노드 인덱스를 반환
	private int getParent(int index) {
		return index/2;
	}
	
	// 받은 인덱스의 왼쪽 자식 노드 인덱스를 반환
	private int getLeftChild(int index) {
		return index*2;
	}
	
	private int getRightChild(int index) {
		return index*2 +1;
	}
	
	private void resize(int newCapacity) {
		// 새로 만들 배열
		Object[] newArray = new Object[newCapacity];
		
		// 새 배열에 기존에 있던 배열의 요소들을 모두 복사해준다.
		for (int i=1; i<=size; i++) {
			newArray[i] = array[i];
		}
		
		this.array = null;
		this.array = newArray;
	}
	
	public void push(E value) {
		// 배열 용적이 꽉 차있을 경우 용적을 두배로 늘려준다.
		if(size +1 == array.length) {
			resize(array.length *2);
		}
		siftUp(size+1, value); 
		size++;
	}
	
	private void siftUp(int idx, E target) {
		if(comparator != null) {
			siftUpComparator(idx, target, comparator);
		}
		else {
			siftUpComparable(idx, target);
		}
	}
	
	private void siftUpComparator(int idx, E target, Comparator<? super E> comp) {
		// root노드보다 작을때까지 탐색
		while(idx > 1) {
			int parent = getParent(idx);
			Object parentVal = array[parent];
		
			if(comp.compare(target, (E) parentVal) > 0) {
				break;
			}
		
			array[idx] = parentVal;
			idx = parent;
		}
		array[idx] = target;
	}
	private void siftUpComparable(int idx, E target) {
		Comparable<? super E> comp = (Comparable<? super E>) target;
		
		while(idx > 1) {
			int parent = getParent(idx);
			Object parentVal = array[parent];
			
			if(comp.compareTo((E)parentVal) > 0) {
				break; 
			}
			array[idx] = parentVal;
			idx = parent;
		}
		array[idx] = comp;
	}
	
	public E pop() {
		if(array[1] == null) {
			// root(max)가 빈 경우
			throw new NoSuchElementException();
		}
		
		E result = (E) array[1];
		E target = (E) array[size];
		array[size] = null;
		
		siftDown(1, target);
		
		return result;
	}
	
	private void siftDown(int idx, E target) {
		if(comparator != null) {
			siftDownComparator(idx, target, comparator);
		}
		else {
			siftDownComparable(idx, target);
		}
	}
	
	private void siftDownComparator(int idx, E target, Comparator<? super E> comp) {
		array[idx] = null;
		size --;
		
		int parent = idx;
		int child;
		
		while((child = getLeftChild(parent)) <= size) {
			int right = getRightChild(parent);
			Object childVal = array[child];
			
			if(right <= size && comp.compare((E) childVal, (E) array[right]) <= 0) {
				child = right;
				childVal = array[child];
			}
			
			if(comp.compare(target, (E) childVal) <= 0) {
				break;
			}
			
			array[parent] = childVal;
			parent = child;
		}
		array[parent] = target;
		
		if(array.length > DEFAULT_CAPACITY && size < array.length/4) {
			resize(Math.max(DEFAULT_CAPACITY, array.length/2));
		}
	}
	private void siftDownComparable(int idx, E target) {
		Comparable<? super E> comp = (Comparable<? super E>) target;
		
		array[idx] = null;
		size --;
		
		int parent = idx;
		int child;
		
		while((child = getLeftChild(parent)) <= size) {
			int right = getRightChild(parent);
			
			Object childVal = array[child];
			
			if(right <= size && ((Comparable<? super E>)childVal).compareTo((E)array[right]) > 0) {
				child = right;
				childVal = array[child];
			}
			
			if(comp.compareTo((E) childVal) <= 0) {
				break;
			}
			array[parent] = childVal;
			parent = child;
		}
		array[parent] = comp;
		
		if(array.length > DEFAULT_CAPACITY && size < array.length/4) {
			resize(Math.max(DEFAULT_CAPACITY, array.length/2));
		}
	}
	public boolean isEmpty() {
		return size == 0;
	}
	
	public Object[] toArray() {
		return Arrays.copyOf(array, size+1);
	}

}


public class Test {

	public static void main(String[] args) {
		Heap<Integer> heap = new Heap<>();
		Integer[] sortarray = new Integer[1000];
		
		Integer[] newarray = new Integer[1000];
		
		Random rnd = new Random();
		
		for(int i=0; i<1000; i++) {
			int num = rnd.nextInt(100);
			heap.push(num);
			sortarray[i] = num;
		}
		
		// 힙 내부 배열의 요소 상태
		System.out.print("내부 배열 상태 : ");
		for(Object val : heap.toArray()) {
			System.out.print(val+" ");
		}

		for (int i = 0; i<1000; i++) {
			newarray[i] = heap.pop();
		}
		System.out.println();
		
		
		Arrays.sort(sortarray);
		System.out.print("내림차순 정렬:\t");
		for(int i=0; i<sortarray.length; i++) {
			System.out.print(sortarray[i]+" ");
		}
		System.out.println();

		System.out.println("------비교");
		for(int i = 0; i<sortarray.length; i++) {
			if(newarray[i] != sortarray[i]) System.out.println("---Error "+i+"번째 같지 않음!");
		}
		System.out.println("------끝!!!");
	}

}
