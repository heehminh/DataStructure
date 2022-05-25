// 자료구조 과제#5 (60200860 김민희)
package ds_week07;

public class Main {

	public static void main(String[] args) {
		
		// 첫번째 이진트리 t
		Node n1 = new Node('A', null, null); Node n2 = new Node('B', null, null); 
		Node n3 = new Node('C', null, null); Node n4 = new Node('D', null, null); 
		Node n5 = new Node('E', null, null); Node n6 = new Node('F', null, null); 
		Node n7 = new Node('G', null, null); Node n8 = new Node('H', null, null); 
		Node n9 = new Node('I', null, null); 
		
		n1.setLeft(n2); n1.setRight(n3); // n1의 왼쪽자식 -> n2, n1의 오른쪽자식 -> n3
		n2.setLeft(n4); n2.setRight(n5); // n2의 왼쪽자식 -> n4, n2의 오른쪽자식 -> n5
		n3.setLeft(n6); n3.setRight(n7); // n3의 왼쪽자식 -> n6, n3의 오른쪽자식 -> n7
		n6.setLeft(n8);	n7.setRight(n9);	 // n4의 왼쪽자식 -> n8
		
		BinaryTree t = new BinaryTree(); // 이진트리의 객체 t 생성
		t.setRoot(n1);
		
		System.out.printf("t의 전위 순회: ");
		t.preorder(t.getRoot());
	
		System.out.printf("\nt의 레벨 순회: ");
		t.levelorder(t.getRoot());
		System.out.println();
		
		// 복사
		BinaryTree newTree = new BinaryTree();
		Node newRoot = newTree.copyTree(n1);
		newTree.setRoot(newRoot);
		
		System.out.printf("\nnewTree의 전위 순회: ");
		newTree.preorder(newRoot);
		
		
		System.out.printf("\nnewTree의 레벨 순회: ");
		newTree.levelorder(newRoot);
		System.out.println();
		
		System.out.println("동일성 검사: "+BinaryTree.isEqual(t.getRoot(), newTree.getRoot()));
		
		
	}

	

}
