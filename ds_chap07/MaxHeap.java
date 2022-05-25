package ds_chap07;

class BHeapMax {
	private int[] a; // a[0]은 사용안함
	private int N;  // 힙의 크기
	public BHeapMax(int[] arr, int s) { // 생성자 호출
		a=arr; N=s;
	}
	public int size() { return N; }
	private boolean greater(int i, int j) {
		return a[j] >= a[i];
	}
	private void swap(int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	public void createheap() {
		for (int i=N/2; i>0; i--) downheap(i);
	}
	private void downheap(int i) {
		while(2*i <= N) {
			int k =2*i;
			if (k<N && greater(k, k+1)) k++;
			if (!greater(i, k)) break;
			swap(i,k);
			i=k;
		}
	}
	public void push(int num) {
		a[++N] = num;
		upheap(N);
	}
	private void upheap(int j) {
		while(j>1 && greater(j/2, j)) {
			swap(j/2, j); j=j/2;
		}
	}
	public int pop() {
		int min = a[1];
		swap(1, N--);
		//a[N+1] = (Integer) null;
		downheap(1);
		return min;
	}
	public String heapsort() {
		String res="";
		
		for(int i=1; i<size()+1; i++) { res += ("["+a[i]+"] "); }
		return res;
	}
}

public class MaxHeap {

	public static void main(String[] args) {
		int[] arr = new int[10];
		arr[1]=35; arr[2]=10; arr[3]=20;
		arr[4]=15; arr[5]=25; arr[6]=40;
		
		BHeapMax h1 = new BHeapMax(arr, 6);
		
		System.out.println("힙 만들기 전: "); System.out.println(h1.heapsort());
		
		h1.createheap();
		System.out.println("최소힙: "); System.out.println(h1.heapsort());
		
		h1.push(65);
		System.out.println("65 삽입 후: "); System.out.println(h1.heapsort());
		
		int len = h1.size()+1;
		for (int i=1; i<len; i++) {
			System.out.print("("+h1.pop()+") ");
		}
	}

}
