// 60200860 김민희 과제 #8
package ds_chap07;

public class BHeap<Key extends Comparable<Key>, Value> {
	private Entry[] a; // a[0]은 사용안함
	private int N; // 힙의 크기
	public BHeap (Entry[] harray, int initialSize) {
		a = harray;
		N = initialSize;
	}
	
	public int size() { return N; }
	private boolean greater(int i, int j) {
		return a[j].getKey().compareTo(a[i].getKey()) < 0;
	}
	private void swap(int i, int j) {
		Entry temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public void createheap() {
		for (int i=N/2; i>0; i--) {
			downheap(i);
		}
	}
	private void downheap(int i) {
		while (2*i <= N) { // 왼쪽 자식이 있다면
			int k = 2*i;
			if (k<N && greater(k, k+1)) // 오른쪽 자식이 있고 && 왼쪽 자식이 크다면
				k++;
			if (!greater(i, k)) // 부모가 왼쪽 자식보다 크지 않자면
				break;
			swap(i, k);
			i = k;
		}
	}
	public void insert(Key newKey, Value newValue) {
		Entry temp = new Entry(newKey, newValue);
		a[++N] = temp;
		upheap(N);
	}
	private void upheap(int j) {
		while(j>1 && greater(j/2, j)) {
			swap(j/2, j);
			j = j/2;
		}
	}
	
	public Entry deleteMin() {
		Entry min = a[1];
		swap(1, N--);
		a[N+1] = null;
		downheap(1);
		return min;
	}
	
	public void print() {
		for (int i=1; i<size()+1; i++) {
			System.out.printf("["+a[i].getKey()+" "+a[i].getValue()+"] ");
		}
		System.out.println("\n힙 크기 = "+size()+"\n");	
	}
	

}
