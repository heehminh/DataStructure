// 자료구조 과제#2 (60200680 김민희)
package ds_week04;

public class Main {

	public static void main(String[] args) {
		
		int[] list1 = {10, 20, 30, 40, 50};
		int[] list2 = {15, 18, 35, 37, 55};
		
		var<Integer> s1 = new SList<Integer>();
		var<Integer> s2 = new SList<Integer>();
		
		for (int i = list1.length - 1; i >= 0; i--) {
			s1.insertFront(list1[i]);
		}
		for (int i = list2.length - 1; i >= 0; i--) {
			s2.insertFront(list2[i]);
		}
		
		System.out.print("Sorted List 1:\t"); s1.print();
		System.out.print("Sorted List 2:\t"); s2.print();
		
		s1.mergeLists(s1.head, s2.head);
		System.out.print("Merged List:\t"); s1.print(); 
		System.out.println("---------------------------\n");
		
		int[] list3 = {10, 90, 15, 10, 35, 57, 50, 20, 17, 45};
		int k = 20;
		
		var s3 = new SList<Integer>();
		for (int i = list3.length - 1; i >= 0; i--) {
			s3.insertFront(list3[i]);
		}
		
		System.out.print("Single List:\t"); s3.print();
		System.out.println("k="+k+"을 기준으로 두 개의 리스트로 분리:");
		
		var t1 = new SList<Integer>();
		var t2 = new SList<Integer>();
		
		Object[] res = s3.splitList(s3.head, k, t1,  t2);
		
		t1 = (SList<Integer>) res[0];
		t2 = (SList<Integer>) res[1];
		
		System.out.print("List 1(<=20):\t"); t1.print();
		System.out.print("List 2(> 20):\t"); t2.print();
		
		
	}

}
