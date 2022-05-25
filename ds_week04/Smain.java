package ds_week04;

public class Smain {

	public static void main(String[] args) {

		SList<String> s = new SList<String>(); // 연결리스트 객체 s 생성
		s.insertFront("orange"); s.insertFront("apple");
		s.insertAfter("cherry", s.head.getNext());
		s.insertFront("pear");		
		s.print();
		System.out.println(": s의 길이 = "+s.size()+"\n");
		
		System.out.println("체리가 \t"+s.search("cherry")+"번째에 있다.");
		System.out.println("키위가 \t"+s.search("kiwi")+"번째에 있다.");
		
		s.deleteAfter(s.head);
		s.print();
		System.out.println(": s의 길이 = "+s.size()+"\n");
		
		s.deleteFront();
		s.print();
		System.out.println(": s의 길이 = "+s.size()+"\n");
		
		s.deleteFront();
		s.deleteFront();
		s.print();
		System.out.println(": s의 길이 = "+s.size()+"\n");
		
//		s.deleteFront(); // -> NoSuchElementException
		
		SList<Integer> t = new SList<Integer>();
		t.insertFront(500);
		t.insertFront(200);
		t.insertAfter(400, t.head);
		t.insertFront(100);
		t.insertAfter(300, t.head.getNext());
		// 100 200 300 400 500
		t.print();
		System.out.println(": t의 길이 = "+t.size()+"\n");
		
		
	}

}
