package ds_chap07;

import java.util.LinkedList;
import java.util.Queue;

class Node<Key extends Comparable<Key>> {
	public Key item;
	public Node<Key> left;
	public Node<Key> right;
	
	public Node(Key newItem, Node lt, Node rt) {
		item=newItem; left=lt; right=rt;
	}
}

class BinaryTree<Key extends Comparable<Key>> {
private Node root;
	
	public BinaryTree() { root=null; }
	
	public Node getRoot() { return root; }
	public void setRoot(Node newRoot) { root=newRoot; }
	
	public boolean isEmpty() { return root==null; }
	
	// 전위 순회
	public void preorder(Node n) {
		if (n != null) {
			System.out.print(n+" "); // 노드 n 방문
			preorder(n.left);
			preorder(n.right);
		}
	}
	
	// size(후위순회), height(후위순회), isEqual 메소드 추가
	// n을 루트로 하는 (서브)트리의 노드 수
	public int size(Node n) {
		if (n==null) return 0;
		else return (1+size(n.left)+size(n.right));
		// 1+root노드의 left subtree에 있는 노드수+right subtree에 있는 노드수
	}
	
	// n을 루트로 하는 (서브)트리의 높이
	public int height(Node n) {
		if (n==null) return 0;
		else return (1+Math.max(height(n.left), height(n.right)));
	}
	
	public static boolean isEqual(Node n, Node m) {
		// 둘다 null이면 true, 아니면 false
		if (n==null || m==null) return n==m; //true
		
		// 둘다 null이 아니면 item 비교
		if (n != m) return false;
		
		// itme이 같으면 왼쪽/오른쪽 자식으로 재귀호출
		return (isEqual(n.left, m.left) && 
				isEqual(n.right, m.right));
	}
}

public class BT {

	public static void main(String[] args) {
		Node n1 = new Node(10, null, null);
		Node n2 = new Node(30, null, null);
		Node n3 = new Node(20, null, null);
		Node n4 = new Node(15, null, null);
		Node n5 = new Node(27, null, null);
		Node n6 = new Node(40, null, null);
		
		n1.left = n2; n1.right = n3;
		n2.left = n4; n2.right = n5;
		n3.left = n6;
		
		BinaryTree t = new BinaryTree();
		t.setRoot(n1);
		
		System.out.printf("t의 전위 순회: ");
		t.preorder(t.getRoot());
	}

}
