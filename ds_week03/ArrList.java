package ds_week03;

import java.util.NoSuchElementException;

public class ArrList <E> {
	private E a[]; // 리스트의 항목들을 저장할 배열
	private int size; // 리스트의 항목 수

	// 생성자
	public ArrList() {
		a = (E[]) new Object[1]; // 최초로 1개의 원소를 가진 배열 생성
		size = 0;
	}
	// 탐색, 삽입, 삭제 연산을 위한 메소드 선언
	
	// k번째 항목을 리턴, 단순히 읽기만 한다.
	public E peek(int k) {
		// underflow 경우에 프로그램 정지
		if (isEmpty())
			throw new NoSuchElementException();
		return a[k]; // k번째 인덱스를 가진 배열의 원소 반환
	}
	
	// 리스트가 empty이면 true 리턴
	public boolean isEmpty() {
		return size == 0;
	}
	
	// 가장 뒤에 새 항목 삽입
	public void insertLast(E newItem) {
		if (size == a.length) // 배열에 빈 공간이 없으면
			resize(2*a.length); // 배열 크기 2배로 확장
		
		a[size++] = newItem; // 새 항목 삽입
		// ++후위연산자 a[size]=newItem; ++size;
	}
	
	// 새 항목을 k-1번째 항목 다음에 삽입
	public void insert(E newItem, int k) { // 매개변수 2개
		// 배열에 빈 공간이 없으면 배열 크기 2배로 확장
		if (size == a.length)
			resize(2*a.length);
		
		// 한 칸씩 뒤로 이동 (맨 마지막 원소부터)
		for (int i = size-1; i >= k; i--)
			a[i+1] = a[i];
		
		a[k] = newItem;
		size ++;
	}
	
	// 배열 크기 조절
	private void resize(int newSize) {
		// newSize 크기의 새로운 배열 t 생성
		Object[] t = new Object[newSize];
		
		// 배열 s를 배열 t로 복사
		for (int i = 0; i < size; i++)
			t[i] = a[i];
		
		// 배열 t를 배열 s로
		a = (E[]) t;
	}
	
	// k번째 항목 삭제
	public E delete(int k) {
		// underflow 경우에 프로그램 정지
		if (isEmpty())
			throw new NoSuchElementException();
		
		E item = a[k];
		
		// 한 칸씩 앞으로 이동
		for (int i = k; i < size; i++)
			a[i] = a[i+1];
		
		size --;
		
		// 배열에 항목들이 1/4만 차지한다면 배열을 1/2 크기로 축소
		if (size > 0 && size == a.length/4)
			resize(a.length/2);
		
		return item;
	}

	public void print() {
		if (isEmpty()) 
			System.out.println("배열이 비어있음.");
		else {
			for(int i=0; i<a.length; i++) {
				System.out.printf("%-8s", a[i]);
			} System.out.println();
		}
		
	}

}
