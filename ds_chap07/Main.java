// 60200860 김민희 과제 #8
package ds_chap07;

public class Main {
	
	public static void main(String[] args) {
		Entry[] a = new Entry[16];
//		a[1] = new Entry(90, "watermelon");	a[2] = new Entry(80, "pear");
//		a[3] = new Entry(70, "melon"); 		a[4] = new Entry(50, "lime");
//		a[5] = new Entry(60, "mango"); 		a[6] = new Entry(20, "cherry");
//		a[7] = new Entry(30, "grape"); 		a[8] = new Entry(35, "orange");
//		a[9] = new Entry(10, "apricot"); 	a[10] = new Entry(15, "banana");
//		a[11] = new Entry(45, "lemon");		a[12] = new Entry(40, "kiwi");
		
		
		BHeap h = new BHeap(a, 0);
		
		h.createheap();
//		System.out.println("최소힙: "); 
		h.print();
	
		h.insert(80,  "가");  h.print();
		h.insert(40,  "나");  h.print();
		h.insert(70,  "다");  h.print();
		h.insert(30,  "라");  h.print();
		h.insert(60,  "마");  h.print();
		h.insert(20,  "바");  h.print();
		h.insert(50,  "사");  h.print();
		h.insert(10,  "아");  h.print();

		
//		System.out.println("min 삭제 후: "); System.out.println(h.deleteMin().getValue());
//		h.print();
//		h.insert(5, "apple"); System.out.println("5 삽입 후: "); h.print();
		
		

	}

}
