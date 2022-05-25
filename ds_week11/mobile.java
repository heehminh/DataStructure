package ds_week11;

// Entry선언
class Entry<Key extends Comparable<Key>> {
	private Key ky;
	public Entry (Key newKey) {
		ky = newKey;
	}
	
	public Key getKey() { return ky; }
	public int getKey_toInt(Key keey) { return (int)keey; } 
	public void setKey(Key newKey) { ky = newKey; }
}

// maxHeap 선언
class BHeap<Key extends Comparable<Key>> {
	private Entry[] a; // a[0]은 사용안함
	private int N; // 힙의 크기
	public BHeap (Entry[] harray, int initialSize) {
		a = harray;
		N = initialSize;
	}
	
	public int size() { return N; }
	private boolean greater(int i, int j) {
		return a[j].getKey().compareTo(a[i].getKey()) >= 0;
	}
	private void swap(int i, int j) { // a[i]와 a[j] 교환
		Entry temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public void createheap() {
		for (int i=N/2; i>0; i--) {
			downheap(i);
			//upheap(i);
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
	public void push(Key newKey) {
		Entry temp = new Entry(newKey);
		a[++N] = temp;
		upheap(N);
		//downheap(N);
	}

	private void upheap(int j) {
		while(j>1 && greater(j/2, j)) {
			swap(j/2, j);
			j = j/2;
		}
	}
	
	public Entry pop() {
		Entry min = a[1];
		swap(1, N--);
		a[N+1] = null;
		downheap(1);
		//upheap(1);
		return min;
	}
	
	public String heapsort() {
		String res = "";
		
		for (int i=1; i<size()+1; i++) {
			res += ("["+a[i].getKey()+"] ");
		}
		res += ("\n힙 크기 = "+size()+"\n");	
		return res;
	}
}

public class mobile {
	
	public static void main(String[] args) {
		
		Entry[] arr = new Entry[8];
		arr[1] = new Entry(35); arr[2] = new Entry(10);
		arr[3] = new Entry(20); arr[4] = new Entry(15);
		arr[5] = new Entry(25); arr[6] = new Entry(40);
		
		BHeap h1 = new BHeap(arr, 6);

		System.out.println("힙 만들기 전: "); System.out.println(h1.heapsort());
		
		h1.createheap();
		System.out.println("최소힙: "); System.out.println(h1.heapsort());
		
		
		
		h1.push(65); System.out.println("65 삽입 후: "); 
		System.out.println(h1.heapsort());
		
		h1.pop();
		System.out.println("65 삽입 후: "); 
		System.out.println(h1.heapsort());
		
	}

}
