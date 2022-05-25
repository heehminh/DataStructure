package ds_week03;

public class Travel {
	private Node start;
	
	public Travel() {
		start = null;
	}
	
	public class Node {
		private char name; // 섬이름
		private Node left, right; // 섬사이의 다리연결
		
		public Node(char newIsland, Node lt, Node rt) { // 섬생성자
			this.name = newIsland;
			this.left = lt; this.right = rt;
		}
	}
	public Node map() { // 지도만들기
		Node n1 = new Node('H', null, null); Node n2 = new Node('F', null, null);
		Node n3 = new Node('S', null, null); Node n4 = new Node('U', null, null);
		Node n5 = new Node('E', null, null); Node n6 = new Node('Z', null, null);
		Node n7 = new Node('K', null, null); Node n8 = new Node('N', null, null);
		Node n9 = new Node('A', null, null); Node n10 = new Node('Y', null, null);
		Node n11 = new Node('T', null, null); 
		// 연결
		n1.left = n2; n1.right = n3;
		n2.left = n4; n2.right = n5;
		n3.left = n6; n3.right = n7;
		n4.left = n8; 
		n5.left = n9;
		n7.right = n10;
		n9.right = n11;
			
		return n1; // 시작 섬 리턴 
	}
		
	public void A_course(Node n) { // A코스
		// 섬 n 방문 -> 왼쪽 -> 오른쪽
		if(n != null) {
			System.out.print(n.name+"-> "); // 섬 n 방문
			A_course(n.left); // n의 왼쪽으로 진행
			A_course(n.right); // n의 오른쪽으로 진행
		}
	}
		
	public void B_course(Node n) { // B코스
		// 왼쪽 -> 섬 n 방문 -> 오른족
		if(n != null) {
			B_course(n.left); // n의 왼쪽으로 진행
			System.out.print(n.name+"-> "); // 섬 n 방문
			B_course(n.right); // n의 오른쪽으로 진행
		}
	}
		
	public void C_course(Node n) { // C코스
		// 왼쪽 -> 오른쪽 -> 섬 n 방문
		if(n != null) {
			C_course(n.left); // n의 왼쪽으로 진행
			C_course(n.right); // n의 오른쪽으로 진행
			System.out.print(n.name+"-> "); // 섬 n 방문
		}
	}
	public static void main(String[] args) {
		Travel t = new Travel(); // 여행 객체 t 생성
		t.start = t.map();
		System.out.print("A코스: "); t.A_course(t.start);
		System.out.print("\nB코스: "); t.B_course(t.start);
		System.out.print("\nC코스: "); t.C_course(t.start);
		
	}


}
